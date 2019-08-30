package dev.dallagi;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionRepositoryShould {
    private String EARLIER_DATE = "2019-01-01";
    private String LATER_DATE = "2019-01-02";

    @Test
    public void store_and_return_transactions_in_chronological_order() {
        TransactionRepository transactionRepository = new TransactionRepository();

        transactionRepository.add(new Transaction(1000, EARLIER_DATE));
        transactionRepository.add(new Transaction(-100, LATER_DATE));
        List<Transaction> transactions = transactionRepository.all();

        assertEquals(2, transactions.size());
        assertEquals(new Transaction(1000, EARLIER_DATE), transactions.get(0));
        assertEquals(new Transaction(-100, LATER_DATE), transactions.get(1));
    }
}