public class BankAccount {
    Double balance;

    BankAccount(Double balance) {
        this.balance = balance;
    }

    Double addBalance(Double total) {
        if (total > 0) {
            balance += total;
        }
        return balance;
    }

    Double removeBalance(Double total) {
        balance -= total;
        if (balance < 0) {
            balance = 0.0;
        }
        return balance;
    }

    Double getBalanace() {
        return balance;
    }
}
