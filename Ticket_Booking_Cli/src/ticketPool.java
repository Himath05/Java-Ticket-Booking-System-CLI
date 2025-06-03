/**
 * Student Name: Himath De Silva
 * Student ID (IIT): 20031127
 * Student ID (UOW): W2051895
 * */

/**
 * has the methods for the functionality of the ticket pool
 * addTickets adds tickets to the Ticketpool
 * removeTicket removes tickets from the ticketpool after purchasing
 * */


import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ticketPool {
    private final Queue<ticket> ticketsList;
    private final ReentrantLock lock = new ReentrantLock();
    private final int maxCapacity;
    private int ticketCounter;

    public ticketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.ticketsList = new LinkedList<>();
        this.ticketCounter = 1;
    }

    public void addTickets(ticket ticket) {
        this.lock.lock();
        try {
            while(this.ticketsList.size() >= this.maxCapacity) {
                System.out.println("Ticket pool is full. Waiting for space...");
                this.lock.unlock();
                Thread.sleep(1000L);
                this.lock.lock();
            }

            this.ticketsList.add(ticket);
            System.out.println("Added: " + ticket + " by " + Thread.currentThread().getName());
        } catch (InterruptedException var6) {
            System.err.println("Error adding tickets: " + var6.getMessage());
        } finally {
            this.lock.unlock();
        }
    }

    public ticket removeTicket() {
        this.lock.lock();
        ticket Ticket = null;
        try {
            while(this.ticketsList.isEmpty()) {
                System.out.println("No tickets available. Waiting for vendors to add tickets!");
                this.lock.unlock();
                Thread.sleep(1000L);
                this.lock.lock();
            }

            ticket ticket = this.ticketsList.poll();
            System.out.println("Ticket Sale: " + ticket + " by " + Thread.currentThread().getName());
            Ticket = ticket;
        } catch (InterruptedException e) {
            System.err.println("Error occurred while removing tickets: " + e.getMessage());
        } finally {
            this.lock.unlock();
        }
        return Ticket;
    }

    public synchronized int getNextTicketNumber() {
        return ticketCounter++;
    }
}
