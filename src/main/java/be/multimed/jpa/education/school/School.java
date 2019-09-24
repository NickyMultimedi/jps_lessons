package be.multimed.jpa.education.school;

import be.multimed.jpa.education.student.Student;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class School implements Serializable {
    @Id @Column(name = "SchoolId") @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @Column(name = "SchoolName") String name;
    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER, cascade = CascadeType.ALL) @OrderBy("name ASC") List<Student> students = new ArrayList<>();

    public School() {
    }

    public School(String name, List<Student> students) {
        this.name = name;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.setSchool(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setSchool(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return getId() == school.getId() &&
                Objects.equals(getName(), school.getName()) &&
                Objects.equals(getStudents(), school.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStudents());
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
