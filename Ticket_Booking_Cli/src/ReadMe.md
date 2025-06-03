# Concert Ticket Booking System (CLI)

## Project Overview
The Concert Ticket Booking System is a CLI-based application that allows vendors to add tickets to a pool, and customers to purchase tickets. It simulates a multi-threaded environment where vendors and customers interact with a shared ticket pool using advanced synchronization techniques.

## Features
- **Vendor Simulation:** At a predetermined rate, vendors release tickets into the ticket pool.
- **Customer Simulation:** Customers buy tickets from the ticket pool at a set rate.
- **Thread Safety:** To ensure thread safety, synchronisation is performed via ReentrantLocks.
- **Configuration**: The system can be set either using a text file or by entering information manually.
## Setup Instructions

### Prerequisites
- Java 8 or higher
- IntelliJ IDEA or any Java IDE

### Steps for Setup

1. **Clone or Download the Repository**
    - Clone the repository or download the project files to your local machine.
    -  using Git, you can clone the repository with the following command set in the terminal/cmd:
      ```bash
      git clone <repository-url>
      ```

2. **Open the Project in a IDE**
    - Open your chosen IDE and navigate to the project folder.
    - Click on **Open** and select the folder containing the Concert Ticket Booking System.
    - then select **Open** and open the project in a window.

3. **Run the Project**
   -**Run Though IDE**
           - In IntelliJ IDEA, go to **File > Project Structure** and make sure the project SDK is set to Java 8 or higher.
           - to run the project navigate to the **instanceSimulation** and **run** through the IDE.
    -**Run though terminal**
            -navigate to the *project files* and compile the java files.
   ```bash
            cd concert-ticket-booking-system
            javac *.java
   ```
   
-Run the **application**
 ```bash
           java instanceSimulation

   ```
## Usage (CLI)

### Running the Application

1. **Run the `instanceSimulation` class:**
    - The entry point of the application is the `instanceSimulation` class, which starts the simulation.
    - Right-click on `instanceSimulation.java` in IntelliJ IDEA and select **Run**.

2. **Configure the System:**
    - Upon running the program, you will be prompted with the following options:
        - **Option 1:** Load the last saved configuration (if the `config.txt` file exists).
        - **Option 2:** Manually configure the system by entering:
            - Maximum ticket pool capacity
            - Total tickets to be released by each vendor
            - Ticket release rate for vendors (seconds)
            - Ticket retrieval rate for customers (seconds)
            - Number of vendors and customers

3. **Simulating the System:**
    - After configuration, the system starts with vendors adding tickets to the pool, and customers buying tickets.
    - You can see the logs of ticket addition and purchases in the console.

### Configuration File
- The system saves the configuration data in a `config.txt` file. You can edit this file manually or use the CLI to load the configuration.

## Troubleshooting
        1. Configuration File Is Not Found:
        
        If the system cannot discover config.txt, you will be prompted to enter configuration values manually. Ensure that the file is in the same directory as the Java files.
        
        2. Thread Interruption Error:
        
        If you see Thread.sleep() interruptions, it is most probable that the main thread or another process interrupted a thread (either vendor or customer). This frequently occurs when you manually stop the software. To remedy the issue, restart the software.
        
        3. Ticket Pool is Full:
        
        If you get notifications such as "Ticket pool is full." "Waiting for space…" indicates that vendor threads are attempting to add tickets to the pool, but the pool has reached its maximum capacity. The system will wait till there is space for more tickets.
        
        4. No tickets available.

        If the message reads, "No tickets available." "Waiting for vendors to add tickets!" displays when customers attempt to retrieve tickets when none are available in the pool. This is expected during the simulation if client retrieval is faster than ticket creation.
        
        5. Error Saving Configuration
        
        If you encounter an error when the system attempts to save the configuration to a file, ensure that you have write permissions in the directory where the system is executing.
        
        6. Incorrect Ticket Information:
        
        Ensure that the ticket data is properly formatted. If there is a problem with ticket generation (for example, an invalid ticket number or price), look into the ticket class for any data processing concerns.


### Common Issues

- **Error: "Ticket pool is full. Waiting for space..."**
    - This message appears when the ticket pool reaches its maximum capacity. Ensure that your ticket pool size is large enough to handle the expected number of tickets.

- **Error: "No tickets available. Waiting for vendors..."**
    - This message appears when there are no tickets available for customers to buy. Ensure that vendors are releasing tickets into the pool.

- **InterruptedException during simulation:**
    - This can happen if a thread is interrupted. Make sure your system has enough resources to handle the number of threads being used.

- **FileNotFoundException or IOException:**
    - If the configuration file (`config.txt`) is not found or there are issues with reading or writing the file, ensure that the file exists and is in the correct location.

## Contributing
Feel free to fork this repository, make improvements, and create pull requests. Contributions are always welcome!

## Author 
-Himath De Silva
-IIT stu ID : 20231127
-Uow ID : W2051895