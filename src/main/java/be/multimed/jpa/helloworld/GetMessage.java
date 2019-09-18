package be.multimed.jpa.helloworld;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetMessage {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;
        try {
            factory = Persistence.createEntityManagerFactory("course");
            manager = factory.createEntityManager();
            EntityTransaction transaction = manager.getTransaction();

            transaction.begin();

            Message message = manager.find(Message.class, 1);
            System.out.println(message.getMessage());

            transaction.commit();
        } finally {
            if (manager != null) {
                manager.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}
