package se.kth.iv1350.sellProcess.integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Prints log messages to a file. The log file will be in the
 * current directory and will be called log.txt.
 */
public class FileLogger implements  Logger{
    private static final DateTimeFormatter TimeAndDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private PrintWriter logStream;
    //private static final FileLogger logger = new FileLogger();
    /**
     * Creates a new instance and also creates a new log file.
     * An existing log file will be deleted.
     */
    public FileLogger() {
        try {
            logStream = new PrintWriter(
                new FileWriter("ExceptionLog.txt"), true);
        } catch (IOException ioe) {
            System.out.println("CAN NOT LOG.");
            ioe.printStackTrace();
        }
    }

    /*public static FileLogger getLogger() {
        
        return logger;
    }*/
    
    @Override
    public void log(String message) 
    {
         String time = LocalDateTime.now().format(TimeAndDate);
        logStream.println("Date and time: " + time + " "+ message);
    }

   
}
