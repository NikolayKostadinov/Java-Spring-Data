package _04HospitalDatabase.models;

public class AddressModel {
    private int id;
    private String text;
    private int townId;

    public AddressModel(int id, String text) {
        this(id, text, 0);
    }

    public AddressModel(String text, int townId) {
        this(0,text, townId);
    }

    public AddressModel(int id, String text, int townId) {
        this.id = id;
        this.text = text;
        this.townId = townId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getTownId() {
        return townId;
    }

    @Override
    public String toString() {
        return String.format("%d. %s", this.id, this.text);
    }
}
