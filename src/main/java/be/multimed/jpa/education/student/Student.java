package be.multimed.jpa.education.student;

import be.multimed.jpa.education.school.School;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Student implements Serializable {
    @Id @Column(name = "StudentId") @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @Column(name = "StudentName") String name;
    @ManyToOne @JoinColumn(name = "SchoolId")
    School school;

    public Student() {
    }

    public Student(String name, School school) {
        this.name = name;
        this.school = school;
    }

    public Student(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getId() == student.getId() &&
                Objects.equals(getName(), student.getName()) &&
                Objects.equals(getSchool(), student.getSchool());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSchool());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", school=" + school.getName() +
                '}';
    }
}
