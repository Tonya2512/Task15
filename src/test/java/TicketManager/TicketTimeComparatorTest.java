package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketTimeComparatorTest {
    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12); //2
        Ticket ticket2 = new Ticket("MSK", "LA", 500, 7, 11);
        Ticket ticket3 = new Ticket("UFA", "NEW", 800, 1, 2);
        Ticket ticket4 = new Ticket("MSK", "SPB", 700, 11, 15); //4
        Ticket ticket5 = new Ticket("LA", "NEW", 100, 9, 13);
        Ticket ticket6 = new Ticket("MSK", "SPB", 800, 6, 9); //3
        Ticket ticket7 = new Ticket("MSK", "SPB", 100, 5, 9); //4
        Ticket ticket8 = new Ticket("MSK", "SPB", 600, 4, 9); //5
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();
          Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket1, ticket6, ticket4, ticket7, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
        public void testSortUnknownDirections() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12); //2
        Ticket ticket2 = new Ticket("MSK", "LA", 500, 7, 11);
        Ticket ticket3 = new Ticket("UFA", "NEW", 800, 1, 2);
        Ticket ticket4 = new Ticket("MSK", "SPB", 700, 11, 15); //4
        Ticket ticket5 = new Ticket("LA", "NEW", 100, 9, 13);
        Ticket ticket6 = new Ticket("MSK", "SPB", 800, 6, 9); //3
        Ticket ticket7 = new Ticket("MSK", "SPB", 100, 5, 9); //4
        Ticket ticket8 = new Ticket("MSK", "SPB", 600, 4, 9); //5
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.search("NEW", "SPB", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortCoupleDirections() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12); //2
        Ticket ticket2 = new Ticket("MSK", "LA", 500, 7, 11);
        Ticket ticket3 = new Ticket("UFA", "NEW", 800, 1, 12); //11
        Ticket ticket4 = new Ticket("MSK", "SPB", 700, 11, 15); //4
        Ticket ticket5 = new Ticket("UFA", "NEW", 100, 1, 13); //12
        Ticket ticket6 = new Ticket("MSK", "SPB", 800, 6, 9); //3
        Ticket ticket7 = new Ticket("MSK", "SPB", 100, 5, 9); //4
        Ticket ticket8 = new Ticket("MSK", "SPB", 600, 4, 9); //5
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual1 = manager.search("MSK", "SPB", comparator);
        Ticket[] expected1 = {ticket1, ticket6, ticket4, ticket7, ticket8};

        Assertions.assertArrayEquals(expected1, actual1);

        Ticket[] actual2 = manager.search("UFA", "NEW", comparator);
        Ticket[] expected2 = {ticket3, ticket5};
        Assertions.assertArrayEquals(expected2, actual2);
    }

}