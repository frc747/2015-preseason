/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.ILimits;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Brian
 */
public class Limits implements ILimits {
    private final static String TAG = "Limits";
    private final static String limit1Open = "Limit switch 1 normally open";
    private final static String limit2Open = "Limit switch 2 normally open";
    private final static String limit3Open = "Limit switch 3 normally open";
    private final static String limit4Open = "Limit switch 4 normally open";
    private final static String limit5Open = "Limit switch 5 normally open";
    private final static String limit6Open = "Limit switch 6 normally open";
    private final static String limit7Open = "Limit switch 7 normally open";
    private final static String limit8Open = "Limit switch 8 normally open";
    private final static String limit9Open = "Limit switch 9 normally open";
    private final static String limit10Open = "Limit switch 10 normally open";
    //Singleton
    private static Limits instance;
    public static Limits getInstance() {
        if(instance == null) {
            instance = new Limits();
        }
        return instance;
    }
    private final DigitalInput limit1, limit2, limit3, limit4, limit5, limit6, limit7, limit8, limit9, limit10; //digital inputs 11-14 are for the encoders
    private final Logging logger;
    private Limits() {
        limit1 = new DigitalInput(1);
        limit2 = new DigitalInput(2);
        limit3 = new DigitalInput(3);
        limit4 = new DigitalInput(4);
        limit5 = new DigitalInput(5);
        limit6 = new DigitalInput(6);
        limit7 = new DigitalInput(7);
        limit8 = new DigitalInput(8);
        limit9 = new DigitalInput(9);
        limit10 = new DigitalInput(10);
        logger = Logging.getInstance();
        SmartDashboard.putBoolean(limit1Open, true);
        SmartDashboard.putBoolean(limit2Open, true);
        SmartDashboard.putBoolean(limit3Open, true);
        SmartDashboard.putBoolean(limit4Open, true);
        SmartDashboard.putBoolean(limit5Open, true);
        SmartDashboard.putBoolean(limit6Open, true);
        SmartDashboard.putBoolean(limit7Open, true);
        SmartDashboard.putBoolean(limit8Open, true);
        SmartDashboard.putBoolean(limit9Open, true);
        SmartDashboard.putBoolean(limit10Open, true);
    }
    public boolean getRealSwitch(int number) {
        switch(number) {
            case 1:
                return limit1.get();
            case 2:
                return limit2.get();
            case 3:
                return limit3.get();
            case 4:
                return limit4.get();
            case 5:
                return limit5.get();
            case 6:
                return limit6.get();
            case 7:
                return limit7.get();
            case 8:
                return limit8.get();
            case 9:
                return limit9.get();
            case 10:
                return limit10.get();
        }
        return false;
    }

    public boolean getInversed(int number) {
        switch(number) {
            case 1:
                return SmartDashboard.getBoolean(limit1Open, true);
            case 2:
                return SmartDashboard.getBoolean(limit2Open, true);
            case 3:
                return SmartDashboard.getBoolean(limit3Open, true);
            case 4:
                return SmartDashboard.getBoolean(limit4Open, true);
            case 5:
                return SmartDashboard.getBoolean(limit5Open, true);
            case 6:
                return SmartDashboard.getBoolean(limit6Open, true);
            case 7:
                return SmartDashboard.getBoolean(limit7Open, true);
            case 8:
                return SmartDashboard.getBoolean(limit8Open, true);
            case 9:
                return SmartDashboard.getBoolean(limit9Open, true);
            case 10:
                return SmartDashboard.getBoolean(limit10Open, true);
        }
        return false;
    }

    public boolean getSwitch(int number) {
        if(getInversed(number)) {
            return !getRealSwitch(number);
        } else {
            return getRealSwitch(number);
        }
    }

    public void setup() {
        //no setup
    }
    
    public SendableChooser getLimitChooser() {
        SendableChooser chooser = new SendableChooser();
        chooser.addDefault("None",new Integer(0));
        chooser.addObject("Limit Switch 1", new Integer(1));
        chooser.addObject("Limit Switch 2", new Integer(2));
        chooser.addObject("Limit Switch 3", new Integer(3));
        chooser.addObject("Limit Switch 4", new Integer(4));
        chooser.addObject("Limit Switch 5", new Integer(5));
        chooser.addObject("Limit Switch 6", new Integer(6));
        chooser.addObject("Limit Switch 7", new Integer(7));
        chooser.addObject("Limit Switch 8", new Integer(8));
        chooser.addObject("Limit Switch 9", new Integer(9));
        chooser.addObject("Limit Switch 10", new Integer(10));
        return chooser;
    }
    
    public boolean getSwitch(SendableChooser chooser) {
        Integer valueObject = (Integer) chooser.getSelected();
        int value = 0;
        if(null!=valueObject) {
            value = valueObject.intValue();
        }
        return this.getSwitch(value);
    }
}
