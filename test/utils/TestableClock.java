package utils;

import dev.dallagi.Clock;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

import static java.util.Arrays.asList;

public class TestableClock extends Clock {
    private Queue<LocalDate> dates;

    public TestableClock(LocalDate ...dates) {
        this.dates = new LinkedList<>(asList(dates));
    }

    @Override
    protected LocalDate today() {
        return this.dates.poll();
    }
}
