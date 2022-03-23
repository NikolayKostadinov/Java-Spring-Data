package _04HospitalDatabase.entities;

import Common.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "prescription")
public class Prescription extends BaseEntity<Integer> {

    private Set<PrescriptionRow> rows;

    private Diagnose diagnose;

    public Prescription(Set<PrescriptionRow> rows) {
        this(0, rows, null);
    }

    public Prescription(Set<PrescriptionRow> rows, Diagnose diagnose) {
        this(0, rows, diagnose);
    }

    public Prescription(Integer id, Set<PrescriptionRow> rows, Diagnose diagnose) {
        this.setId(id == 0 ? null : id);
        this.rows = rows;
        this.diagnose = diagnose;
    }

    public Prescription() {

    }

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.PERSIST)
    public Set<PrescriptionRow> getRows() {
        return rows;
    }

    public void setRows(Set<PrescriptionRow> rows) {
        this.rows = rows;
    }

    @OneToOne(optional = false)
    @JoinColumn(name = "diagnose_id", referencedColumnName = "id", unique = true)
    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }
}
