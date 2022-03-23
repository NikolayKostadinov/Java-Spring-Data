package _04HospitalDatabase.entities;

import Common.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "prescriptions_row")
public class PrescriptionRow extends BaseEntity<Integer> {

    private Medicament medicament;

    private int timesPerDay;

    private int quantityPerConsumption;

    private Prescription prescription;

    public PrescriptionRow() {
    }

    public PrescriptionRow(Medicament medicament, int timesPerDay, int quantityPerConsumption, Prescription prescription) {
        this.medicament = medicament;
        this.timesPerDay = timesPerDay;
        this.quantityPerConsumption = quantityPerConsumption;
        this.prescription = prescription;
    }

    @Column(name="times_per_day", nullable = false)
    public int getTimesPerDay() {
        return timesPerDay;
    }

    public void setTimesPerDay(int timesPerDay) {
        this.timesPerDay = timesPerDay;
    }

    @Column(name="quantity_per_consumption", nullable = false)
    public int getQuantityPerConsumption() {
        return quantityPerConsumption;
    }

    public void setQuantityPerConsumption(int quantityPerConsumption) {
        this.quantityPerConsumption = quantityPerConsumption;
    }

    @ManyToOne
    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    @ManyToOne
    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionRow that = (PrescriptionRow) o;
        return medicament.equals(that.medicament) && prescription.equals(that.prescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicament, prescription);
    }
}
