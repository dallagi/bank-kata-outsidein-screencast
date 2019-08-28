package dev.dallagi;

import java.util.List;

public class StatementPrinter {
    private Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void printStatement(List<Transaction> transactions) {
        printHeader();
    }

    private void printHeader() {
        console.printLine("DATE | AMOUNT | BALANCE");
    }
}
