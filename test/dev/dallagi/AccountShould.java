package dev.dallagi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AccountShould {
    @Mock
    TransactionRepository transactionRepository;

    @Test
    public void store_deposit_transactions() {
        Account account = new Account(transactionRepository);

        account.deposit(100);

        Transaction deposit = transaction(100);
        verify(transactionRepository).commit(deposit);
    }

    @Test
    public void store_withdrawal_transactions() {
        Account account = new Account(transactionRepository);

        account.withdraw(100);

        Transaction deposit = transaction(-100);
        verify(transactionRepository).commit(deposit);
    }

    private Transaction transaction(int amount) {
        return new Transaction(amount);
    }
}
