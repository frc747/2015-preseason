/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.ILogging;

/**
 *
 * @author Kevin
 */
public class Logging implements ILogging {
    private final static String TAG = "Logging";
    //Singleton
    private static Logging instance;
    public static Logging getInstance() {
        if(instance == null) {
            instance = new Logging();
        }
        return instance;
    }
    private Logging() {
        
    }
    public void log(int level, String tag, String text) {
        
    }

    public void log(int level, String tag, int num) {
        
    }

    public void log(int level, String tag, double num) {
        
    }

    public void log(int level, String tag, float num) {
        
    }

    public void log(int level, String tag, short num) {
        
    }

    public void log(int level, String tag, boolean num) {
        
    }

    public void log(int level, String tag, char num) {
        
    }

    public void log(int level, String tag, byte num) {
        
    }
    
}
