package ro.sci.week_10.concurrency;

public class FestivalStatisticsThread extends Thread {

    final private FestivalGate gate;
    private int full = 0;
    private int fullVip = 0;
    private int freePass = 0;
    private int oneDay = 0;
    private int oneDayVip = 0;
    private int attendees = 0;


    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    public void resetCalc() {
        full = 0;
        fullVip = 0;
        freePass = 0;
        oneDay = 0;
        oneDayVip = 0;
        attendees = 0;
    }

    @Override
    public void run() {
        while (attendees < 100) {
            resetCalc();
            numberOfEachTicketType();
            numberOfAttendees();
            printStatistics();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void numberOfEachTicketType() {
        synchronized (this.gate.tickets) {
            for (TicketType ticketType : this.gate.tickets) {
                if (ticketType.equals(TicketType.FULL)) {
                    full++;
                } else if (ticketType.equals(TicketType.ONE_DAY)) {
                    oneDay++;
                } else if (ticketType.equals(TicketType.FULL_VIP)) {
                    fullVip++;
                } else if (ticketType.equals(TicketType.FREE_PASS)) {
                    freePass++;
                } else if (ticketType.equals(TicketType.ONE_DAY_VIP)) {
                    oneDayVip++;
                }
            }
        }

    }

    private void numberOfAttendees() {
        attendees = full +
                fullVip +
                freePass +
                oneDay +
                oneDayVip +
                attendees;
    }

    private void printStatistics() {
        System.out.println("-------------");
        System.out.println( attendees + " people entered " + "\n" +
                full + " have full tickets " + "\n" +
                freePass + " have free tickets " + "\n" +
                fullVip + " have full vip tickets " + "\n" +
                oneDay + " have one day tickets " + "\n" +
                oneDayVip + " have one day vip tickets ");
        System.out.println("-------------");
    }


}
