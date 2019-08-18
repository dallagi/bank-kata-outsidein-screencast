package dev.dallagi;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;
import static java.util.Collections.unmodifiableList;

public class TransactionRepository {
    private List<Transaction> transactions;

    public TransactionRepository() {
        this.transactions = new ArrayList<>();
    }

    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> all() {
        List<Transaction> transactionsCopy = new ArrayList<>(transactions);
        reverse(transactionsCopy);

        return unmodifiableList(transactionsCopy);
    }
}
