package _03UniversitySystem.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person {

    private double averageGrade;

    private int attendance;

    private Set<Course> courses;


    @Column(name = "average_grade")
    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double average_grade) {
        this.averageGrade = average_grade;
    }

    @Column(name= "attendance")
    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @ManyToMany(mappedBy = "students")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
