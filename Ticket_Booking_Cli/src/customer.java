/**
 * Student Name: Himath De Silva
 * Student ID (IIT): 20031127
 * Student ID (UOW): W2051895
 * */
import java.io.PrintStream;

/**
 * Customer class handles the customer objects under the runnable interface.
 */
public class customer implements Runnable {
    private final ticketPool ticketPool;
    private final int customerRetrievalRate;
    private final int noOfTickets;

    public customer(ticketPool ticketPool, int customerRetrievalRate, int noOfTickets) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
        this.noOfTickets = noOfTickets;
    }

    /**
     * Removes tickets from the ticket pool
     * runs the customer to the customer retrieval rate
     */
    public void run() {
        for(int i = 0; i < this.noOfTickets; ++i) {
            ticket ticket = this.ticketPool.removeTicket();
            PrintStream customerTransaction = System.out;
            String customer = Thread.currentThread().getName();
            customerTransaction.println("Bought by: " + customer + " - ticket: " + String.valueOf(ticket));

            try {
                Thread.sleep((long)this.customerRetrievalRate * 1000L);
            } catch (InterruptedException e) {
                System.err.println("Customer interrupted: " + e.getMessage());
            }
        }

    }
}
