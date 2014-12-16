/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.ILimits;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Brian
 */
public class Limits implements ILimits {
    private final static String TAG = "Limits";
    private final static String invert = "Invert limit ";
    
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
        for(int setupInverter=1;setupInverter<=10;++setupInverter) {
            SmartDashboard.getBoolean(invert+setupInverter, false);
        }
        logger = Logging.getInstance();
    }
    public boolean getRealSwitch(int number) {
        logger.log(Logging.debug, TAG, "Switch # "+number);
        boolean switchValue = false;
        switch(number) {
            case 1:
                switchValue = limit1.get();
                break;
            case 2:
                switchValue = limit2.get();
                break;
            case 3:
                switchValue = limit3.get();
                break;
            case 4:
                switchValue = limit4.get();
                break;
            case 5:
                switchValue = limit5.get();
                break;
            case 6:
                switchValue = limit6.get();
                break;
            case 7:
                switchValue = limit7.get();
                break;
            case 8:
                switchValue = limit8.get();
                break;
            case 9:
                switchValue = limit9.get();
                break;
            case 10:
                switchValue = limit10.get();
                break;
        }
        logger.log(Logging.debug, TAG, "Switch # "+number+" is "+switchValue);
        return switchValue;
    }

    public boolean getInversed(int number) {
        boolean invertValue = SmartDashboard.getBoolean(invert+number, false);
        logger.log(Logging.debug, TAG, "Inverter # "+number+" is "+invertValue);
        return invertValue;
    }

    public boolean getSwitch(int number) {
        boolean invertedSwitchValue = getRealSwitch(number) ^ getInversed(number); //^ is logical XOR in java http://en.wikipedia.org/wiki/Exclusive_or
        logger.log(Logging.debug, TAG, "Switch/Inverter # "+number+" is "+invertedSwitchValue);
        return invertedSwitchValue;
    }

    public void setup() {
        //not needed
    }
    
}
