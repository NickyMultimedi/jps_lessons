package be.multimed.jpa.shop.customers;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;

public class CustomerRepoImpl implements CustomerRepo {
    @Override
    public void save(Customer customer) {
        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            handler.merge(customer);

            handler.commitTransaction();
        }
    }

    @Override
    public Customer find(long id) {
        Customer customer;

        try (EntityHandler handler = new EntityHandlerImpl("course")) {
            handler.beginTransaction();

            customer = handler.find(Customer.class, id);

            handler.commitTransaction();
        }

        return customer;
    }
}
