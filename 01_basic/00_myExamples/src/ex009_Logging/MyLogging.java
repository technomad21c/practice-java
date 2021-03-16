package ex009_Logging;
// source: https://www.journaldev.com/977/logger-in-java-logging-example

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class MyLogging {

    static Logger logger = Logger.getLogger(MyLogging.class.getName());

    public void run() {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("src/ex009_Logging/mylogging.properties"));
        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
        }

//        logger.setLevel(Level.FINE);
//        logger.addHandler(new ConsoleHandler());
//        logger.addHandler(new MyHandler());

//        try {
//            logger.addHandler(new FileHandler());
//            Handler fileHandler = new FileHandler("./logger.log", 2000, 5);
//            fileHandler.setFormatter(new MyFormatter());
//            fileHandler.setFilter(new MyFilter());
//            logger.addHandler(fileHandler);

            for (int i=0; i<1000; i++) {
                logger.log(Level.INFO, "Msg" + i);
            }
            logger.log(Level.CONFIG, "CONFIG DATA");
//        } catch (SecurityException | IOException e) {
//            e.printStackTrace();
//        }
    }
}
