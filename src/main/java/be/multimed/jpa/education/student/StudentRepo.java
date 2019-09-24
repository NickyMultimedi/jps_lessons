package be.multimed.jpa.education.student;

public interface StudentRepo {
    void save(Student student);
    Student find(long studentId);
}
