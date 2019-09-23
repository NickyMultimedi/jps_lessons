package be.multimed.jpa.handlers;

import javax.persistence.*;
import java.io.Closeable;
import java.io.IOException;

public class EntityHandlerImpl implements EntityHandler {
    EntityManagerFactory factory;
    EntityManager manager;
    EntityTransaction transaction;

    public EntityHandlerImpl(String persistenceUnitName) {
        factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        manager = factory.createEntityManager();
        transaction = manager.getTransaction();
    }

    @Override
    public EntityManagerFactory getFactory() {
        return factory;
    }

    @Override
    public EntityManager getManager() {
        return manager;
    }

    @Override
    public EntityTransaction getTransaction() {
        return transaction;
    }

    @Override
    public void beginTransaction() {
        transaction.begin();
    }

    @Override
    public void commitTransaction() {
        transaction.commit();
    }

    @Override
    public void persist(Object o) {
        manager.persist(o);
    }

    @Override
    public <T> T find(Class<T> aClass, Object o) {
        return manager.find(aClass, o);
    }

    @Override
    public <T> T find(Class<T> aClass, Object o, LockModeType type) {
        return manager.find(aClass, o, type);
    }

    @Override
    public void rollback() {
        transaction.rollback();
    }

    @Override
    public void close() {
        manager.close();
        factory.close();
    }
}
