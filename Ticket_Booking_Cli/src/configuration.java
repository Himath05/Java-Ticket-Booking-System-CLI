/**
 * Student Name: Himath De Silva
 * Student ID (IIT): 20031127
 * Student ID (UOW): W2051895
 * */



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Handles the configuration settings of the system.
 * takes user inputs and stores the data on a file
 * fetches the configuration data stored and executes the system with thr last saved configuration data
 * */
public class configuration {
    private int numVendors;
    private int numCustomers;
    private int maxCapacity;
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;

    private static final String CONFIG_FILE = "config.txt";

    public configuration() {
        // Check if a config file exists and ask the user if they want to use it
        if (new File(CONFIG_FILE).exists()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to use the last saved configuration? (y/n):");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                loadConfiguration();
            } else {
                configureSystem();
            }
        } else {
            configureSystem();
        }
    }

    private void configureSystem() {
        Scanner scanner = new Scanner(System.in);


        this.maxCapacity = getIntInput("Enter the maximum ticket pool capacity:", scanner);

        this.totalTickets = getIntInput("Enter the total tickets to be released by each vendor:", scanner);

        this.ticketReleaseRate = getIntInput("Enter the ticket release rate for vendors (seconds):", scanner);

        this.customerRetrievalRate = getIntInput("Enter the ticket retrieval rate for customers (seconds):", scanner);

        this.numVendors = getIntInput("Enter the number of vendors:", scanner);

        this.numCustomers = getIntInput("Enter the number of customers:", scanner);

        saveConfiguration();
    }

    private void saveConfiguration() {
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            writer.write(this.maxCapacity + "\n");
            writer.write(this.totalTickets + "\n");
            writer.write(this.ticketReleaseRate + "\n");
            writer.write(this.customerRetrievalRate + "\n");
            writer.write(this.numVendors + "\n");
            writer.write(this.numCustomers + "\n");
            System.out.println("Configuration saved to " + CONFIG_FILE);
        } catch (IOException e) {
            System.out.println("Error saving configuration: " + e.getMessage());
        }
    }


    private void loadConfiguration() {
        try (Scanner fileScanner = new Scanner(new File(CONFIG_FILE))) {
            this.maxCapacity = Integer.parseInt(fileScanner.nextLine());
            this.totalTickets = Integer.parseInt(fileScanner.nextLine());
            this.ticketReleaseRate = Integer.parseInt(fileScanner.nextLine());
            this.customerRetrievalRate = Integer.parseInt(fileScanner.nextLine());
            this.numVendors = Integer.parseInt(fileScanner.nextLine());
            this.numCustomers = Integer.parseInt(fileScanner.nextLine());
            System.out.println("Configuration loaded from " + CONFIG_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Configuration file not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing the configuration file: " + e.getMessage());
        }
    }


    private int getIntInput(String prompt, Scanner scanner) {
        int value;
        while (true) {
            System.out.println(prompt);
            try {
                value = scanner.nextInt();
                if (value <= 0) {
                    System.out.println("Please enter a positive integer.");
                } else {
                    return value;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    public int getNumVendors() {
        return this.numVendors;
    }

    public int getNumCustomers() {
        return this.numCustomers;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public int getTotalTickets() {
        return this.totalTickets;
    }

    public int getTicketReleaseRate() {
        return this.ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return this.customerRetrievalRate;
    }
}