package be.multimed.jpa.bankieren;

import be.multimed.jpa.handlers.EntityHandler;
import be.multimed.jpa.handlers.EntityHandlerImpl;

import javax.persistence.*;

public class BankAccountRepoImpl implements BankAccountRepo {
    EntityManagerFactory factory;
    EntityManager manager;
    EntityTransaction transaction;

    @Override
    public BankAccount find(String iban) {
        BankAccount account;

        try {
            factory = Persistence.createEntityManagerFactory("banking");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();

            account = manager.find(BankAccount.class, iban);

            transaction.commit();
        } finally {
            manager.close();
            factory.close();
        }

        return account;
    }

    @Override
    public String save(BankAccount account) {
        try {
            factory = Persistence.createEntityManagerFactory("banking");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();

            BankAccount acc1 = manager.find(BankAccount.class, account.getIban());
            acc1.fill(account);

            transaction.commit();
        } finally {
            factory.close();
            manager.close();
        }

        return account.getIban();
    }

    @Override
    public void transferMoney(BankTransaction moneyTransfer) {
        String senderIban = moneyTransfer.getSender().getIban();
        String recipientIban = moneyTransfer.getRecipient().getIban();

        try {
            factory = Persistence.createEntityManagerFactory("banking");
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            moneyTransfer.setSender(manager.find(BankAccount.class, senderIban, LockModeType.OPTIMISTIC_FORCE_INCREMENT));
            moneyTransfer.setRecipient(manager.find(BankAccount.class, recipientIban, LockModeType.OPTIMISTIC_FORCE_INCREMENT));
            transaction.commit();

            moneyTransfer.transfer();

            transaction.begin();
            transaction.commit();

        } catch (NotEnoughFundsException nefe) {
            transaction.rollback();
        } finally {
            manager.close();
            factory.close();
        }
    }
}
