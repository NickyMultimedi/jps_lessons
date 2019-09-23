package be.multimed.jpa.bankieren;

import java.math.BigDecimal;

public class Bankieren {
    public static void main(String[] args) throws NotEnoughFundsException {
        BankAccountRepo repo = new BankAccountRepoImpl();

        BankAccount acc1 = repo.find("BE261234567890");
        BankAccount acc2 = repo.find("BE260987654321");
        System.out.println(acc1);
        acc1.setSaldo(new BigDecimal(120));
        acc2.setSaldo(new BigDecimal(100));
        BankTransaction transaction = new BankTransaction(acc1, acc2, 20);
//        System.out.println(transaction);
//        transaction.transfer();
//        repo.save(acc1);
//        repo.save(acc2);
//        repo.transferMoney(transaction);

        System.out.println(transaction);
    }
}
