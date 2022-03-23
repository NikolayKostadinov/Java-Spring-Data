package _04HospitalDatabase.entities;

import Common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity<Integer> {

    private String firstName;

    private String lastName;

    private Address address;

    private String email;

    private LocalDate dateОfBirth;

    private byte[] picture;

    private Boolean hasInsurance;

    private Set<Visitation> visitations;

    public Patient() {
    }

    public Patient(String firstName, String lastName, Address address,
                   String email, LocalDate dateОfBirth, Boolean hasInsurance) {
        this(0, firstName, lastName, address, email, dateОfBirth, null, hasInsurance);
    }

    public Patient(int id, String firstName, String lastName, Address address,
                   String email, LocalDate dateОfBirth, byte[] picture, Boolean hasInsurance) {
        this.setId(id == 0 ? null : 0);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.dateОfBirth = dateОfBirth;
        this.picture = picture;
        this.hasInsurance = hasInsurance;
    }

    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToOne
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "date_of_birth")
    public LocalDate getDateОfBirth() {
        return dateОfBirth;
    }

    public void setDateОfBirth(LocalDate dateОfBirth) {
        this.dateОfBirth = dateОfBirth;
    }

    @Lob
    @Column(name = "picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Column(name = "has_insurance")
    public Boolean getHasInsurance() {
        return hasInsurance;
    }

    public void setHasInsurance(Boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }

    @OneToMany(mappedBy = "patient")
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }
}
