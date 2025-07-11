package se.kth.iv1350.sellProcess.integration;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaleLogger implements Logger {


private PrintWriter logStream;
private static final DateTimeFormatter TimeAndDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    /**
    * Prints log messages to a file. The log file will be in the
    * current directory and will be called log.txt.

    /**
     * Creates a new instance and also creates a new log file.
     * An existing log file will be deleted.
     */
    public SaleLogger() {
        

        try {
            logStream = new PrintWriter(
                new FileWriter("SalesLog.txt"), true);
        } catch (IOException ioe) {
            System.out.println("CAN NOT LOG.");
            ioe.printStackTrace();
        }
    }
    
    @Override
    public void log(String message) 
    {
        String time = LocalDateTime.now().format(TimeAndDate);
        logStream.println("Date and time: " + time + " "+ message);
    }

   
}


