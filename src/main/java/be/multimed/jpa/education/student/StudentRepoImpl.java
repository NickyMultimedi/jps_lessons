package be.multimed.jpa.education.student;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;

public class StudentRepoImpl implements StudentRepo {

    @Override
    public void save(Student student) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            handler.merge(student);

            handler.commitTransaction();
        }
    }

    @Override
    public Student find(long studentId) {
        Student student;

        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            student = handler.find(Student.class, studentId);

            handler.commitTransaction();
        }


        return student;
    }
}
