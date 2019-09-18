package be.multimed.jpa.handlers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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

    //TODO een find methode schrijven. Hoe werkt dit?????
    @Override
    @Deprecated
    public void find(Class<Object> aClass, Object o) {
        manager.find(aClass, o);
    }

    @Override
    public void close() {
        manager.close();
        factory.close();
    }
}
