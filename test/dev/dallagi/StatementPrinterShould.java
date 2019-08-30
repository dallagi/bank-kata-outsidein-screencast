package dev.dallagi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StatementPrinterShould {
    @Mock Console console;

    @Test
    public void always_print_header() {
        List<Transaction> transactions = Collections.emptyList();
        StatementPrinter statementPrinter = new StatementPrinter(console);

        statementPrinter.printStatement(transactions);

        verify(console).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void print_transactions_in_reverse_order() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1000, "01/04/2014"));
        transactions.add(new Transaction(-100, "02/04/2014"));
        transactions.add(new Transaction(500, "10/04/2014"));

        StatementPrinter statementPrinter = new StatementPrinter(console);
        statementPrinter.printStatement(transactions);

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
