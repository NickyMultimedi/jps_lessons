package be.multimed.jpa.people;

import be.multimed.jpa.people.address.Address;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "PERSONS", indexes = {@Index(name = "LAST_NAME_INDEX", columnList = "LAST_NAME"), @Index(name = "BIRTHDAY_INDEX", columnList = "BIRTHDAY")})
@SecondaryTable(name="URLS")
public class Person implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID") long id;
    @Version @Column(name = "VERSION") long version;
    @Column(name = "FIRST_NAME", nullable = false, length = 40) String firstName;
    @Column(name = "LAST_NAME", nullable = false, length = 40) String lastName;
    @Column(name = "BIRTHDAY") LocalDate birthday;
    @Column(name = "GENDER", length = 10, nullable = false, updatable = false) @Enumerated(EnumType.STRING) GenderType gender;
    @Column(name = "PICTURE") @Lob @Basic(fetch = FetchType.LAZY) byte[] picture;
    @Column(name = "COMMNT") @Lob @Basic(fetch = FetchType.LAZY) String comment;
    @Column(name = "MARRIED", columnDefinition = "BOOLEAN") boolean married;
    @Column(name = "HOMEPAGE", table = "URLS", length = 255) String homepage;
    @Embedded Address address = new Address();

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate birthday, GenderType gender, byte[] picture, String comment, boolean married, String homepage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.picture = picture;
        this.comment = comment;
        this.married = married;
        this.homepage = homepage;
    }

    public Person(String firstName, String lastName, LocalDate birthday, GenderType gender, byte[] picture, String comment, boolean married, String homepage, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.picture = picture;
        this.comment = comment;
        this.married = married;
        this.homepage = homepage;
        this.address = address;
    }

    public Person(long id, long version, String firstName, String lastName, LocalDate birthday, GenderType gender, byte[] picture, String comment, boolean married, String homepage) {
        this.id = id;
        this.version = version;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.picture = picture;
        this.comment = comment;
        this.married = married;
        this.homepage = homepage;
    }

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getAge() {
        int age;
        LocalDate now = LocalDate.now();

        age = (int) ChronoUnit.YEARS.between(now, birthday);

        return age;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                getVersion() == person.getVersion() &&
                isMarried() == person.isMarried() &&
                Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getLastName(), person.getLastName()) &&
                Objects.equals(getBirthday(), person.getBirthday()) &&
                getGender() == person.getGender() &&
                Arrays.equals(getPicture(), person.getPicture()) &&
                Objects.equals(getComment(), person.getComment()) &&
                Objects.equals(getHomepage(), person.getHomepage()) &&
                Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getVersion(), getFirstName(), getLastName(), getBirthday(), getGender(), getComment(), isMarried(), getHomepage(), getAddress());
        result = 31 * result + Arrays.hashCode(getPicture());
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", picture=" + Arrays.toString(picture) +
                ", comment='" + comment + '\'' +
                ", married=" + married +
                ", homepage='" + homepage + '\'' +
                ", address=" + address +
                '}';
    }
}
