package dev.dallagi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;

public class StatementPrinter {
    private Console console;
    private DecimalFormat decimalFormatter = new DecimalFormat("#.00");

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void printStatement(List<Transaction> transactions) {
        printHeader();
        printLines(statementLines(transactions));
    }

    private void printHeader() {
        console.printLine("DATE | AMOUNT | BALANCE");
    }

    private void printLines(List<String> lines) {
        for(String line: lines) {
            console.printLine(line);
        }
    }

    private List<String> statementLines(List<Transaction> transactions) {
        int runningBalance = 0;
        List<String> lines = new ArrayList<>();
        for(Transaction transaction: transactions) {
            runningBalance += transaction.amount();
            String line = statementLine(transaction, runningBalance);
            lines.add(line);
        }
        reverse(lines);
        return lines;
    }

    private String statementLine(Transaction transaction, int runningBalance) {
        return transaction.date() + " | " + decimalFormatter.format(transaction.amount()) + " | " + decimalFormatter.format(runningBalance);
    }
}
