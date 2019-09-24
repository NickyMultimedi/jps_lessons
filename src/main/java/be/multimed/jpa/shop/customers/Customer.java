package be.multimed.jpa.shop.customers;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
public class Customer implements Serializable {
    @Id @Column(name = "CustomerID") @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @Column(name = "CustomerName") String name;
    @ElementCollection(fetch = FetchType.EAGER) @Column(name = "Phonenumber") @MapKeyColumn(name = "PhoneType") @CollectionTable(name = "Phones")
    Map<String, String> phones = new HashMap<>();
    @ElementCollection(fetch = FetchType.EAGER) @MapKeyColumn(name = "EmailType") @MapKeyEnumerated(EnumType.STRING) @CollectionTable(name = "Emails")
    Map<EmailType, Email> emails = new HashMap<>();

    public Customer() {
    }

    public Customer(String name, Map<String, String> phones, Map<EmailType, Email> emails) {
        this.name = name;
        this.phones = phones;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getPhones() {
        return phones;
    }

    public void setPhones(Map<String, String> phones) {
        this.phones = phones;
    }

    public Map<EmailType, Email> getEmails() {
        return emails;
    }

    public void setEmails(Map<EmailType, Email> emails) {
        this.emails = emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(getName(), customer.getName()) &&
                Objects.equals(getPhones(), customer.getPhones()) &&
                Objects.equals(getEmails(), customer.getEmails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getPhones(), getEmails());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phones=" + phones +
                ", emails=" + emails +
                '}';
    }
}
