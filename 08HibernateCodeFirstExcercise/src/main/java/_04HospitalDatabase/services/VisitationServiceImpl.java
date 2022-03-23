package _04HospitalDatabase.services;

import _04HospitalDatabase.entities.*;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.MedicamentModel;
import _04HospitalDatabase.models.PatientModel;
import _04HospitalDatabase.models.VisitationModel;
import _04HospitalDatabase.repository.MedicamentRepositoryImpl;
import _04HospitalDatabase.repository.PatientRepositoryImpl;
import _04HospitalDatabase.repository.Repository;
import _04HospitalDatabase.repository.VisitationRepositoryImpl;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static _04HospitalDatabase.common.Utilities.*;

public class VisitationServiceImpl implements Service<Visitation, VisitationModel> {
    private final Repository<Visitation, VisitationModel, Integer> repository;
    private final Repository<Patient, PatientModel, Integer> patientRepository;
    private final  Repository<Medicament, MedicamentModel, Integer> medicamentRepository;

    public VisitationServiceImpl(Repository<Visitation, VisitationModel, Integer> repository,
                                 Repository<Patient, PatientModel, Integer> patientRepository,
                                 Repository<Medicament, MedicamentModel, Integer> medicamentRepository) {
        this.repository = repository;
        this.patientRepository = patientRepository;
        this.medicamentRepository = medicamentRepository;
    }

    @Override
    public Visitation create() throws ValidationException, IOException {
        Patient patient = getPatient();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime date = LocalDateTime.parse(
                readStringFromConsole("Enter visitation date and time /dd.mm.yyyy hh:mm/: "), df);
        String comment = readStringFromConsole("Enter comment: ");
        Prescription prescription = getPrescription();
        Diagnose diagnose = getDiagnose(prescription);
        prescription.setDiagnose(diagnose);
        return this.repository.persist(new VisitationModel(date, comment, patient, diagnose));
    }

    private Patient getPatient() throws IOException {
        printPatientsList();
        int patientId = readIntFromConsole("Enter patient number: ");
        Patient patient = patientRepository.findById(patientId);
        return patient;
    }

    private void printPatientsList() {
        printMessage("Choose Patient");
        printMessage("--------------");
        printMessage(this.patientRepository.all()
                .stream()
                .map(PatientModel::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private Prescription getPrescription() throws IOException {
        printMedicaments();
        Prescription prescription = new Prescription();
        int medicamentId = readIntFromConsole("Enter medicament Id: ");
        Set<PrescriptionRow> rows = new HashSet<>();
        while (medicamentId > 0){
            Medicament medicament = medicamentRepository.findById(medicamentId);
            int timesPerDay = readIntFromConsole("Enter times per day: ");
            int quantityPerConsumption = readIntFromConsole("Enter quantity per consumption: ");
            rows.add(new PrescriptionRow(medicament, timesPerDay, quantityPerConsumption, prescription));
            printMedicaments();
            medicamentId = readIntFromConsole("Enter medicament Id: ");
        }
        prescription.setRows(rows);
        return prescription;
    }

    private void printMedicaments() {
        printMessage("Choose medicament");
        printMessage("-----------------");
        printMessage(this.medicamentRepository.all()
                .stream()
                .map(MedicamentModel::toString)
                .collect(Collectors.joining(System.lineSeparator())));
        printMessage("0. For quit prescription");
    }

    private Diagnose getDiagnose(Prescription prescription) throws IOException {
        String diagnoseName = readStringFromConsole("Enter diagnose name: ");
        String diagnoseComment = readStringFromConsole("Enter diagnose comment: ");
        return new Diagnose(diagnoseName, diagnoseComment, prescription);
    }

    @Override
    public List<VisitationModel> getAll() {
        return this.repository.all();
    }
}
