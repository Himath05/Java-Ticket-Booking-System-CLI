/**
 * Student Name: Himath De Silva
 * Student ID (IIT): 20031127
 * Student ID (UOW): W2051895
 * */
import java.math.BigDecimal;
/**
 * initialises the tickets
 * toSting to print the ticket object
 * */
public class ticket {
    private int ticketNo;
    private String eventName;
    private BigDecimal ticketPrice;

    public ticket(int ticketNo, String eventName, BigDecimal ticketPrice) {
        this.ticketNo = ticketNo;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
    }

    public int getTicketNo() {
        return this.ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public BigDecimal getTicketPrice() {
        return this.ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String toString() {
        int var10000 = this.ticketNo;
        return "ticket{ticketNo=" + var10000 + ", eventName='" + this.eventName + "', ticketPrice=" + String.valueOf(this.ticketPrice) + "}";
    }
}

