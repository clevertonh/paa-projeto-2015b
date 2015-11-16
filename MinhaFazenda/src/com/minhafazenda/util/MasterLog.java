/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author cleverton
 */
public class MasterLog {
 
    private static Logger logger;
    
    private static void criaLog() {
    
        if(logger == null){
            
            logger = Logger.getLogger("LogMinhaFazenda"); 
            
            FileHandler fh;  
            try {
                fh = new FileHandler("LogMinhaFazenda.log");
                logger.addHandler(fh);
                SimpleFormatter formatter = new SimpleFormatter();  
                fh.setFormatter(formatter);  
            } catch (IOException ex) {
                Logger.getLogger(MasterLog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(MasterLog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void addWarning(String msg){
        criaLog();
        logger.log(Level.WARNING, "{0}", msg);
    }
    
    public static void addWarning(String msg, Class cls){
        criaLog();
        logger.log(Level.WARNING, "[{0}] {1}", new Object[]{cls.getName(), msg});
    }    
    
    public static void addInfo(String msg){
        criaLog();
        logger.log(Level.INFO, "{0}", msg);
    }
    
    public static void addInfo(String msg, Class cls){
        criaLog();
        logger.log(Level.INFO, "[{0}] {1}", new Object[]{cls.getName(), msg});
    }
    
    public static void addSevere(String msg){
        criaLog();
        logger.severe(msg);
    }
    
    public static void addSevere(String msg, Class cls){
        criaLog();
        logger.log(Level.SEVERE, "[{0}] {1}", new Object[]{cls.getName(), msg});
    }
}
