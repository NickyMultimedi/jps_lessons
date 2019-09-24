package be.multimed.jpa.shop.customers;

import java.util.HashMap;
import java.util.Map;

public class CustomerMainApp {
    public static void main(String[] args) {
        CustomerRepo repo = new CustomerRepoImpl();

        Map<String, String> phones = new HashMap<>();
        Map<EmailType, Email> emails = new HashMap<>();
        phones.put("home", "555123469");
        phones.put("mobile", "555 777856");

        emails.put(EmailType.HOME, new Email("amail@mail.com"));
        emails.put(EmailType.BUSINESS, new Email("amailB@mail.com"));

        Customer customer = new Customer(
                "Nick",
                phones,
                emails
        );

        repo.save(customer);
        System.out.println(repo.find(1l));
        Customer customer2 = repo.find(1l);
        customer2.setName("BoeJa");
        repo.save(customer2);

    }
}
