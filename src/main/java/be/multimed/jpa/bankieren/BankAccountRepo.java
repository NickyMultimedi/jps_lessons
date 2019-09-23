package be.multimed.jpa.bankieren;

public interface BankAccountRepo {
    BankAccount find(String iban);
    String save(BankAccount account);
    void transferMoney(BankTransaction moneyTransfer);
}
