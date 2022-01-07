package ro.sci.week_10.concurrency;

import java.util.Random;

public class MainWeek10_concurrency {
    public static void main(String[] args) throws InterruptedException {
        FestivalGate gate = new FestivalGate();
        FestivalAttendeeThread festivalAttendee;
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        TicketType ticketType;
        statsThread.start();


        for (int i = 1; i <= 100; i++) {
            ticketType = TicketType.values()[new Random().nextInt(TicketType.values().length)];
            festivalAttendee = new FestivalAttendeeThread(ticketType, gate);
            festivalAttendee.start();
            festivalAttendee.join();

        }


    }

}
