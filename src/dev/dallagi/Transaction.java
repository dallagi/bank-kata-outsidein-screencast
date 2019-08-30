package dev.dallagi;

import java.util.Objects;

public class Transaction {
    private int amount;
    private String date;

    public Transaction(int amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public float amount() {
        return amount;
    }

    public String date() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date);
    }
}
