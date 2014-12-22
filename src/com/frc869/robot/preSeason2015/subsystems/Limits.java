/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.ILimits;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Brian
 */
public class Limits implements ILimits {
    private final static String TAG = "Limits";
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
    
}
