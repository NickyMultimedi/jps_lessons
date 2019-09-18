package be.multimed.jpa.helloworld;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMessage {
    public static void main(String[] args) {
        saveMessage();
    }

    public static void saveMessage() {
        EntityManagerFactory emf = null;
        EntityManager manager = null;
        try {
            emf = Persistence.createEntityManagerFactory("course");
            manager = emf.createEntityManager();
            EntityTransaction transaction = manager.getTransaction();

            transaction.begin();

            Message message = new Message(1, "Hello World");
            manager.persist(message);

            transaction.commit();
            System.out.println("Message saved");
        } finally {
            if (manager != null) {
                manager.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
