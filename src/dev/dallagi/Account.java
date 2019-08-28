package dev.dallagi;

public class Account {
    private TransactionRepository transactionRepository;
    private StatementPrinter statementPrinter;
    private Clock clock;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter, Clock clock) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
        this.clock = clock;
    }

    public void deposit(int amount) {
        transactionRepository.add(transaction(amount, clock.todayAsString()));
    }

    public void withdraw(int amount) {
        transactionRepository.add(transaction(-amount, clock.todayAsString()));
    }

    public void printStatement() {
        statementPrinter.printStatement(transactionRepository.all());
    }

    private Transaction transaction(int amount, String localDate) {
        return new Transaction(amount, localDate);
    }
}
