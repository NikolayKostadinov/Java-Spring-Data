package _04HospitalDatabase.models;

import _04HospitalDatabase.entities.Diagnose;
import _04HospitalDatabase.entities.Patient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class VisitationModel {
    int id;

    private LocalDateTime date;

    private String comments;

    private Patient patient;

    private Diagnose diagnose;

    public VisitationModel(int id, LocalDateTime date, String comments, Patient patient, Diagnose diagnose) {
        this.id = id;
        this.date = date;
        this.comments = comments;
        this.patient = patient;
        this.diagnose = diagnose;
    }

    public VisitationModel(LocalDateTime date, String comments, Patient patient, Diagnose diagnose) {
        this(0, date, comments,patient, diagnose);
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getComments() {
        return comments;
    }

    public Patient getPatient() {
        return patient;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d. %s", id, dtf.format(date))).append(System.lineSeparator());
        sb.append(String.format("\tComments: %s", comments)).append(System.lineSeparator());
        sb.append(String.format("\tPatient: %s %s %s", patient.getFirstName(), patient.getLastName(),df.format(patient.getDateОfBirth()))).append(System.lineSeparator());
        sb.append(String.format("\tDiagnose: %s%n\t\tComment: %s", diagnose.getName(), diagnose.getComments())).append(System.lineSeparator());
        sb.append(String.format("\tPrescription Id: %d", diagnose.getPrescription().getId())).append(System.lineSeparator());
        AtomicInteger index = new AtomicInteger();
        sb.append(diagnose.getPrescription().getRows()
                .stream()
                .map(r->
                        String.format("\t\t%d. %s - %d x %d",
                                index.incrementAndGet(), r.getMedicament().getName(),
                                r.getTimesPerDay(),r.getQuantityPerConsumption()))
                .collect(Collectors.joining(System.lineSeparator())));
        sb.append(System.lineSeparator()).append("----------------------------------------------------------------");
        return sb.toString();
    }
}
