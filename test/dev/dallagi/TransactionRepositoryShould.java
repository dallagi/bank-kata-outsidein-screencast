package dev.dallagi;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionRepositoryShould {
    @Test
    public void store_and_return_transactions_in_reverse_chronological_order() {
        TransactionRepository transactionRepository = new TransactionRepository();

        transactionRepository.add(new Transaction(1000));
        transactionRepository.add(new Transaction(-100));
        List<Transaction> transactions = transactionRepository.all();

        assertEquals(2, transactions.size());
        assertEquals(new Transaction(-100), transactions.get(0));
        assertEquals(new Transaction(1000), transactions.get(1));
    }
}