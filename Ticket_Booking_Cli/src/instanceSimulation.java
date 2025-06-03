/**
 * Student Name: Himath De Silva
 * Student ID (IIT): 20031127
 * Student ID (UOW): W2051895
 * */
/**
 * Runs the instance of the multi-thread environment
 * creates threads according to the configuration settings
 * */

public class instanceSimulation {

    public static void main(String[] args) {

        configuration config = new configuration();


        ticketPool ticketPool = new ticketPool(config.getMaxCapacity());


        for (int i = 0; i < config.getNumVendors(); ++i) {
            vendor vendor = new vendor(ticketPool, config.getTicketReleaseRate(), config.getTotalTickets());
            new Thread(vendor, "Vendor-" + i).start();
        }


        for (int i = 0; i < config.getNumCustomers(); ++i) {
            customer customer = new customer(ticketPool, config.getCustomerRetrievalRate(), 1);
            new Thread(customer, "Customer-" + i).start();
        }
    }
}