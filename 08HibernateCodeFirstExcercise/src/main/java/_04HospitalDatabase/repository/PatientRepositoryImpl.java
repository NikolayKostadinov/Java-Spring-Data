package _04HospitalDatabase.repository;

import _04HospitalDatabase.entities.Address;
import _04HospitalDatabase.entities.Patient;
import _04HospitalDatabase.exceptions.ValidationException;
import _04HospitalDatabase.models.PatientModel;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1;
import static _04HospitalDatabase.common.ErrorMessages.FIELD_IN_ENTITY_IS_REQUIRED;

public class PatientRepositoryImpl extends BaseRepository implements Repository<Patient, PatientModel, Integer> {

    public PatientRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Patient findById(Integer id) {
        return this.getEm().find(Patient.class, id);
    }

    @Override
    public List<PatientModel> all() {
        return this.getEm()
                .createQuery(
                        "SELECT NEW _04HospitalDatabase.models.PatientModel(p.id, p.firstName, p.lastName, " +
                                "p.address.id, p.address.text, p.address.town.name, " +
                                "p.email, p.dateОfBirth, p.hasInsurance) " +
                                "FROM Patient p ", PatientModel.class).getResultList();
    }

    @Override
    public Patient persist(PatientModel patient) throws ValidationException {
        Address address = this.getEm().find(Address.class, patient.getAddressId());
        validate(patient, address);
        Patient dbPatient = new Patient(patient.getId(), patient.getFirstName(),
                patient.getLastName(), address, patient.getEmail(),
                patient.getDateОfBirth(), null, patient.getHasInsurance());
        this.getEm().getTransaction().begin();
        this.getEm().persist(dbPatient);
        this.getEm().getTransaction().commit();
        return dbPatient;
    }

    private void validate(PatientModel patient, Address address) throws ValidationException {
        if (patient.getId() < 0) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_CANNOT_BE_LESS_THAN_1, "id", "patient"));
        } else if (patient.getFirstName() == null || patient.getFirstName().isBlank()) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "first name", "patient"));
        } else if (patient.getLastName() == null || patient.getLastName().isBlank()) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "last name", "patient"));
        } else if (address == null) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "address", "patient"));
        } else if (patient.getEmail() == null || patient.getEmail().isBlank()) {
            throw new ValidationException(
                    String.format(FIELD_IN_ENTITY_IS_REQUIRED, "email", "patient"));
        }
    }
}
