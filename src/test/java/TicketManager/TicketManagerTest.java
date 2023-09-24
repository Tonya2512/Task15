package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    @Test
    public void testSortTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "LA", 500, 7, 11);
        Ticket ticket3 = new Ticket("UFA", "NEW", 800, 1, 2);
        Ticket ticket4 = new Ticket("MSK", "SPB", 700, 11, 15);
        Ticket ticket5 = new Ticket("LA", "NEW", 100, 9, 13);
        Ticket ticket6 = new Ticket("MSK", "SPB", 800, 6, 9);
        Ticket ticket7 = new Ticket("MSK", "SPB", 100, 6, 9);
        Ticket ticket8 = new Ticket("MSK", "SPB", 600, 6, 9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket7, ticket1, ticket8, ticket4, ticket6};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testOneDirection() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "LA", 500, 7, 11);
        Ticket ticket3 = new Ticket("UFA", "NEW", 800, 1, 2);
        Ticket ticket4 = new Ticket("MSK", "SPB", 700, 11, 15);
        Ticket ticket5 = new Ticket("LA", "NEW", 100, 9, 13);
        Ticket ticket6 = new Ticket("MSK", "SPB", 800, 6, 9);
        Ticket ticket7 = new Ticket("MSK", "SPB", 100, 6, 9);
        Ticket ticket8 = new Ticket("MSK", "SPB", 600, 6, 9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("UFA", "NEW");
        Ticket[] expected = {ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testUnknownDirection() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "LA", 500, 7, 11);
        Ticket ticket3 = new Ticket("UFA", "NEW", 800, 1, 2);
        Ticket ticket4 = new Ticket("MSK", "SPB", 700, 11, 15);
        Ticket ticket5 = new Ticket("LA", "NEW", 100, 9, 13);
        Ticket ticket6 = new Ticket("MSK", "SPB", 800, 6, 9);
        Ticket ticket7 = new Ticket("MSK", "SPB", 100, 6, 9);
        Ticket ticket8 = new Ticket("MSK", "SPB", 600, 6, 9);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("lA", "SPB");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}