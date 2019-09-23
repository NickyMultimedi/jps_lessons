package be.multimed.jpa.bankieren;

import java.util.Objects;

public class BankTransaction {
    private BankAccount sender;
    private BankAccount recipient;
    private double amount;

    public BankTransaction() {
    }

    public BankTransaction(BankAccount sender, BankAccount recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    public BankAccount getSender() {
        return sender;
    }

    public void setSender(BankAccount sender) {
        this.sender = sender;
    }

    public BankAccount getRecipient() {
        return recipient;
    }

    public void setRecipient(BankAccount recipient) {
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 &&
                Objects.equals(getSender(), that.getSender()) &&
                Objects.equals(getRecipient(), that.getRecipient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSender(), getRecipient(), getAmount());
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "sender=" + sender +
                ", recipient=" + recipient +
                ", amount=" + amount +
                '}';
    }
}
