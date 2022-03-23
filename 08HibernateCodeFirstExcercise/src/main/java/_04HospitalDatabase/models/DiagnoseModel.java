package _04HospitalDatabase.models;

public class DiagnoseModel {
    private int id;

    private String name;

    private String comments;

    private int visitationId;

    public DiagnoseModel(String name, String comments, int visitationId) {
        this(0, name, comments, visitationId);
    }

    public DiagnoseModel(int id, String name, String comments, int visitationId) {
        this.id = id;
        this.name = name;
        this.comments = comments;
        this.visitationId = visitationId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComments() {
        return comments;
    }

    public int getVisitationId() {
        return visitationId;
    }

    @Override
    public String toString() {
        return String.format("%d. %s - %s", id, name, comments);
    }
}
