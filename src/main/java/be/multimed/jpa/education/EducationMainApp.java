package be.multimed.jpa.education;

import be.multimed.jpa.education.school.School;
import be.multimed.jpa.education.school.SchoolRepo;
import be.multimed.jpa.education.school.SchoolRepoImpl;
import be.multimed.jpa.education.student.Student;

import java.util.ArrayList;
import java.util.List;

public class EducationMainApp {
    public static void main(String[] args) {
        SchoolRepo schoolRepo = new SchoolRepoImpl();

        List<Student> students = new ArrayList<>();
        students.add(new Student("Nick"));
        students.add(new Student("Sam"));
        students.add(new Student("Koen"));

        School school = new School();
        school.setName("KAM");
        school.addStudent(students.get(0));
        school.addStudent(students.get(1));
        School school2 = new School();
        school2.setName("KAV");
        school2.addStudent(students.get(2));

        schoolRepo.save(school);
        schoolRepo.save(school2);
        System.out.println(schoolRepo.find(8L));
    }
}
