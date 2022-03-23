package _04HospitalDatabase.entities;

import Common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="towns")
public class Town extends BaseEntity<Integer> {
    private String name;
    private Set<Address> address;

    public Town(Integer id, String name) {
        this.setId(id);
        this.name = name;
    }

    public Town() {
    }

    @Column(name = "name", length = 50, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "town")
    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
}
