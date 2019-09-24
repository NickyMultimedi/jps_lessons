package be.multimed.jpa.people;

public interface PersonRepo {
    void save(Person person);
    Person find(long personId);
}
