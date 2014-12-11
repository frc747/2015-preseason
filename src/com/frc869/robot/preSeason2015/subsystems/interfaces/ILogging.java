/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems.interfaces;

/**
 *
 * @author Michael
 */
public interface ILogging {
    public final static int wtf = 5;
    public final static int fatal = 4;
    public final static int bad = 3;
    public final static int warning = 2;
    public final static int info = 1;
    public final static int debug = 0;
    
    public void log(int level, String tag, String text);
    public void log(int level, String tag, int num);
    public void log(int level, String tag, double num);
    public void log(int level, String tag, float num);
    public void log(int level, String tag, short num);
    public void log(int level, String tag, boolean num);
    public void log(int level, String tag, char num);
    public void log(int level, String tag, byte num);
}
