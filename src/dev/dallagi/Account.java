package dev.dallagi;

public class Account {
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.add(transaction(amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(transaction(-amount));
    }

    public void printStatement() {
        statementPrinter.printStatement(transactionRepository.all());
    }

    private Transaction transaction(int amount) {
        return new Transaction(amount);
    }
}
