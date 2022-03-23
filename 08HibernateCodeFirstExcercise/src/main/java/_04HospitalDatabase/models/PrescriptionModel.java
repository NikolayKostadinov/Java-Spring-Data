package _04HospitalDatabase.models;

import _04HospitalDatabase.entities.Diagnose;
import _04HospitalDatabase.entities.PrescriptionRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PrescriptionModel {
    private int id;
    private Set<PrescriptionRow> rows;
    private Diagnose diagnose;

    public PrescriptionModel(Set<PrescriptionRow> rows, Diagnose diagnose) {
        this(0, rows, diagnose);
    }

    public PrescriptionModel(int id, Set<PrescriptionRow> rows, Diagnose diagnose) {
        this.id = id;
        this.diagnose = diagnose;
        this.rows = rows;
    }

    public int getId() {
        return id;
    }

    public Set<PrescriptionRow> getRows() {
        return rows;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }
}
