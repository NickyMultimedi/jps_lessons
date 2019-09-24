package be.multimed.jpa.education.school;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;

public class SchoolRepoImpl implements SchoolRepo {
    @Override
    public void save(School school) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            handler.merge(school);

            handler.commitTransaction();
        }
    }

    @Override
    public School find(long SchoolId) {
        School school;

        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            school = handler.find(School.class, SchoolId);

            handler.commitTransaction();
        }

        return school;
    }
}
