/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.util;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a class to implement logging functionality
 * @author AlexK
 */
public class Logging {
    private static Logger logger;
    
    private static Logger getLogger(){
        if (Logging.logger != null)
            return Logging.logger;
        Throwable t = new Throwable();
        StackTraceElement methodCaller = t.getStackTrace()[1];
        Logger logger = Logger.getLogger(methodCaller.getClassName());
        logger.setLevel(Level.SEVERE);
        Logging.logger = logger;
        return Logging.logger;
    }
    
    public static void logMessage(String message){
        Logger log = Logging.getLogger();
        Date date = new Date();
        String mssge = date.toString()+": "+message+"\n";
        log.log(Level.SEVERE, mssge);
    }
            
}
