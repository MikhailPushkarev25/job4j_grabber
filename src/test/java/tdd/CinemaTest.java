package tdd;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

class CinemaTest {

    @Test
    void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    public void noTickets() {
        Cinema cinema = new Cinema3D();
        cinema.add(null);
        List<Session> sessions = cinema.find(session -> false);
        assertNull(null, sessions);
    }

    @Test
    public void unopened() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 10, 10, 3, 00);
        cinema.add(null);
        List<Session> sessions = cinema.find(session -> false);
        assertNull(null, sessions);
    }
}