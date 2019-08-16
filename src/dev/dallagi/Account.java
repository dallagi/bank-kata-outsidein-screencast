package dev.dallagi;

public class Account {
    private TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {
        transactionRepository.commit(transaction(amount));
    }

    public void withdraw(int amount) {
        transactionRepository.commit(transaction(-amount));
    }

    public void printStatement() {
        throw new UnsupportedOperationException();
    }

    private Transaction transaction(int amount) {
        return new Transaction(amount);
    }
}
