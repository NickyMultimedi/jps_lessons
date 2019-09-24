package be.multimed.jpa.people;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;

public class PersonRepoImpl implements PersonRepo {

    @Override
    public void save(Person person) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            if (person.getId() != 0) {
                handler.merge(person);
            } else {
                handler.persist(person);
            }

            handler.commitTransaction();
        }
    }

    @Override
    public Person find(long personId) {
        Person personToFind;

        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            personToFind = handler.find(Person.class, personId);

            handler.commitTransaction();
        }

        return personToFind;
    }
}
