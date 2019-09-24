package be.multimed.jpa.shop.customers;

public interface CustomerRepo {
    void save(Customer customer);
    Customer find(long id);
}
