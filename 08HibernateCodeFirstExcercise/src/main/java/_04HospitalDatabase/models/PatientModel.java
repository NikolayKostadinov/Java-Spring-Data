package _04HospitalDatabase.models;

import java.time.LocalDate;

public class PatientModel {

    private int id;

    private String firstName;

    private String lastName;

    private int addressId;

    private String addressText;

    private String townName;

    private String email;

    private LocalDate dateОfBirth;

    private Boolean hasInsurance;

    public PatientModel(String firstName, String lastName, int addressId, String email, LocalDate dateОfBirth, Boolean hasInsurance) {
        this(0, firstName, lastName, addressId, null, null, email, dateОfBirth, hasInsurance);
    }

    public PatientModel(int id, String firstName, String lastName, int addressId, String addressText, String townName, String email, LocalDate dateОfBirth, Boolean hasInsurance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressId = addressId;
        this.addressText = addressText;
        this.townName = townName;
        this.email = email;
        this.dateОfBirth = dateОfBirth;
        this.hasInsurance = hasInsurance;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getAddressText() {
        return addressText;
    }

    public String getTownName() {
        return townName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateОfBirth() {
        return dateОfBirth;
    }

    public Boolean getHasInsurance() {
        return hasInsurance;
    }

    @Override
    public String toString() {
        return String.format("%d. %s %s from %s, %s", id, firstName, lastName, townName, addressText);
    }
}
