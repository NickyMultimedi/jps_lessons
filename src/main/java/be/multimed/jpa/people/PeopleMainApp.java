package be.multimed.jpa.people;

import be.multimed.jpa.people.address.Address;

import java.time.LocalDate;

public class PeopleMainApp {
    public static void main(String[] args) {
        PersonRepo repo = new PersonRepoImpl();

        Address addres = new Address(
                "Trekweg",
                "94",
                "9030",
                "Mariakerke",
                "België"
        );

        Person person1 = new Person(
                "Nick",
                "Bauters",
                LocalDate.of(1991,03,16),
                GenderType.MALE,
                null,
                null,
                true,
                "www.milites-templi.be",
                addres
        );

        repo.save(person1);

        person1.setLastName("Bauters - de Lange");
        System.out.println(person1);

        Person person2 = repo.find(1L);
        System.out.println(person2);
        person2.setFirstName("Kelly");
        System.out.println(person2);

        repo.save(person1);
    }
}
