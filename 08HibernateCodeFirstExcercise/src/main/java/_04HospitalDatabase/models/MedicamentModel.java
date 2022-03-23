package _04HospitalDatabase.models;

public class MedicamentModel {
    int id;
    String name;

    public MedicamentModel(String name) {
        this(0, name);
    }

    public MedicamentModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%d. %s", this.id, this.name);
    }
}
