package dev.dallagi;

import utils.TestableClock;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClockShould {
    @Test
    public void return_date_as_dd_MM_yyyy() {
        Clock clock = new TestableClock(LocalDate.of(2019, 01, 01));

        assertEquals(clock.todayAsString(), "01/01/2019");
    }

}