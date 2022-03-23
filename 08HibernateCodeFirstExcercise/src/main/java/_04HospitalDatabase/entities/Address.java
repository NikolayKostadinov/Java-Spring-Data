package _04HospitalDatabase.entities;

import Common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "addresses")
public class Address extends BaseEntity<Integer> {
    private String text;

    private Town town;
    private Set<Patient> patients;

    public Address(int id, String text, Town town) {
        this.setId(id == 0 ? null : id);
        this.text = text;
        this.town = town;
    }

    public Address() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @OneToMany(mappedBy = "address")
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
