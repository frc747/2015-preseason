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
    public void log(int level, String tag, String val) {
        System.out.println("|"+level+"|"+tag+"|"+val+"|");
    }

    public void log(int level, String tag, int val) {
        System.out.println("|"+level+"|"+tag+"|"+val+"|");
    }

    public void log(int level, String tag, double val) {
        System.out.println("|"+level+"|"+tag+"|"+val+"|");
    }

    public void log(int level, String tag, float val) {
        System.out.println("|"+level+"|"+tag+"|"+val+"|");
    }

    public void log(int level, String tag, short val) {
        System.out.println("|"+level+"|"+tag+"|"+val+"|");
    }

    public void log(int level, String tag, boolean val) {
        System.out.println("|"+level+"|"+tag+"|"+val+"|");
    }

    public void log(int level, String tag, char val) {
        System.out.println("|"+level+"|"+tag+"|"+val+"|");
    }

    public void log(int level, String tag, byte val) {
        System.out.println("|"+level+"|"+tag+"|"+val+"|");
    }
    
}
