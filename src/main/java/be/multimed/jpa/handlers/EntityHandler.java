package be.multimed.jpa.handlers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.io.Closeable;

public interface EntityHandler extends Closeable, AutoCloseable {

    EntityManagerFactory getFactory();
    EntityManager getManager();
    EntityTransaction getTransaction();

    void beginTransaction();
    void commitTransaction();

    void persist(Object o);
    <T> T find(Class<T> aClass, Object o);

    @Override
    public void close();
}
