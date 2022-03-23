package _04HospitalDatabase.entities;

import Common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="medicaments")
public class Medicament extends BaseEntity<Integer> {
    private String name;

    private Set<PrescriptionRow> prescriptionRowSet;

    public Medicament(Integer id, String name) {
        this.setId(id);
        this.name = name;
    }

    public Medicament() {

    }

    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "medicament")
    public Set<PrescriptionRow> getPrescriptionRowSet() {
        return prescriptionRowSet;
    }

    public void setPrescriptionRowSet(Set<PrescriptionRow> prescriptionRowSet) {
        this.prescriptionRowSet = prescriptionRowSet;
    }
}
