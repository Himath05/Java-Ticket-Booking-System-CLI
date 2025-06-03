/**
 * Student Name: Himath De Silva
 * Student ID (IIT): 20031127
 * Student ID (UOW): W2051895
 * */
import java.math.BigDecimal;
/**
 * Customer class handles the vendor objects under the runnable interface.
 */
public class vendor implements Runnable {
    private final ticketPool ticketPool;
    private final int ticketReleaseRate;
    private final int totalTickets;

    public vendor(ticketPool ticketPool, int ticketReleaseRate, int totalTickets) {
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
        this.totalTickets = totalTickets;
    }

    /**
     * Adds tickets to the ticket pool
     * runs the Vendor to the Vendor release rate
     */
    @Override
    public void run() {
        for(int i = 1; i <= this.totalTickets; ++i) {
            int ticketNo = this.ticketPool.getNextTicketNumber();
            ticket newTicket = new ticket(ticketNo, "Event-" + Thread.currentThread().getName(), new BigDecimal("100"));
            this.ticketPool.addTickets(newTicket);

            try {
                Thread.sleep((long)this.ticketReleaseRate * 1000L);
            } catch (InterruptedException e) {
                System.err.println("Vendor interrupted: " + e.getMessage());
            }
        }
    }
}


