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
    private String DATE = "2019-01-01";

    @Mock TransactionRepository transactionRepository;
    @Mock StatementPrinter statementPrinter;
    @Mock Clock clock;

    @Test
    public void storeDepositTransactions() {
        given(clock.todayAsString()).willReturn(DATE);
        Account account = new Account(transactionRepository, statementPrinter, clock);

        account.deposit(100);

        Transaction deposit = transaction(100);
        verify(transactionRepository).add(deposit);
    }

    @Test
    public void storeWithdrawalTransactions() {
        given(clock.todayAsString()).willReturn(DATE);
        Account account = new Account(transactionRepository, statementPrinter, clock);

        account.withdraw(100);

        Transaction deposit = transaction(-100);
        verify(transactionRepository).add(deposit);
    }

    @Test
    public void printStatementForAllTransactions() {
        given(transactionRepository.all()).willReturn(TRANSACTIONS);
        Account account = new Account(transactionRepository, statementPrinter, clock);

        account.printStatement();

        verify(statementPrinter).printStatement(TRANSACTIONS);
    }

    private Transaction transaction(int amount) {
        return new Transaction(amount, DATE);
    }
}
