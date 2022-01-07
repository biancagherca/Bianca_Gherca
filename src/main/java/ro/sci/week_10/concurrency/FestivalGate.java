package ro.sci.week_10.concurrency;

import java.util.ArrayList;
import java.util.List;

public class FestivalGate extends Thread {

    List<TicketType> tickets = new ArrayList<>();

    public void addTicket(TicketType ticketType) {
        tickets.add(ticketType);
    }
}
