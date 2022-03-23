package _03UniversitySystem.entities;

import Common.BaseEntity;

import javax.persistence.*;

@Entity()
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person extends BaseEntity<Integer> {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    @Column(name = "phone_number", unique = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

}
