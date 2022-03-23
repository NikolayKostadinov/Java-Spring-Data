package _03UniversitySystem.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends Person{
    private String email;
    private BigDecimal salaryPerHour;
    private Set<Course> courses;


    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="salary_per_hour", nullable = false)
    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    @OneToMany(mappedBy = "teacher")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
