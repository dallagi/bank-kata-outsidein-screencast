package acceptance;

import dev.dallagi.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.TestableClock;

import java.time.LocalDate;

import static org.mockito.Mockito.inOrder;

@ExtendWith(MockitoExtension.class)
public class PrintStatementFeature {
    @Mock
    Console console;

    @Test
    void should_print_statement_for_all_transactions() {
        TransactionRepository transactionRepository = new TransactionRepository();
        StatementPrinter statementPrinter = new StatementPrinter(console);
        Clock clock = new TestableClock(
                LocalDate.of(2014, 4, 1),
                LocalDate.of(2014, 4, 2),
                LocalDate.of(2014, 4, 10)
        );

        Account account = new Account(transactionRepository, statementPrinter, clock);

        account.deposit(1000);
        account.withdraw(100);
        account.deposit(500);

        account.printStatement();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
