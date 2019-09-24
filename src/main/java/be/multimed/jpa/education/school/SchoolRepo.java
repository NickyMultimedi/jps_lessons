package be.multimed.jpa.education.school;

public interface SchoolRepo {
    void save(School school);
    School find(long id);
}
