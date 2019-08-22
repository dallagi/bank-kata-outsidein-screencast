package dev.dallagi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountShould {
    private List<Transaction> TRANSACTIONS = new ArrayList<>();

    @Mock TransactionRepository transactionRepository;
    @Mock StatementPrinter statementPrinter;

    @Test
    public void store_deposit_transactions() {
        Account account = new Account(transactionRepository, statementPrinter);

        account.deposit(100);

        Transaction deposit = transaction(100);
        verify(transactionRepository).add(deposit);
    }

    @Test
    public void store_withdrawal_transactions() {
        Account account = new Account(transactionRepository, statementPrinter);

        account.withdraw(100);

        Transaction deposit = transaction(-100);
        verify(transactionRepository).add(deposit);
    }

    @Test
    public void print_statement_for_all_transactions() {
        given(transactionRepository.all()).willReturn(TRANSACTIONS);
        Account account = new Account(transactionRepository, statementPrinter);

        account.printStatement();

        verify(statementPrinter).printStatement(TRANSACTIONS);
    }

    private Transaction transaction(int amount) {
        return new Transaction(amount);
    }
}
