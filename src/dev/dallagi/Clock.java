package dev.dallagi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clock {
    public String todayAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return today().format(formatter);
    }

    protected LocalDate today() {
        return LocalDate.now();
    }
}
