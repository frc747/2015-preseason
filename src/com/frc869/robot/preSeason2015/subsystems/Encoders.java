/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.IEncoders;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author Kurt
 */
public class Encoders implements IEncoders {
    private final static String TAG = "Encoders";
    //Singleton
    private static Encoders instance;
    public static Encoders getInstance() {
        if(instance == null) {
            instance = new Encoders();
        }
        return instance;
    }
    
    private final Encoder left, right;
    private final Logging logger;
    private Encoders() {
        right = new Encoder(11,12, false);
        left = new Encoder(13,14, true);
        logger = Logging.getInstance();
    }
    public double getDistance(boolean right) {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return 0;
    }

    public int turnedLeft(boolean right) {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return 0;
    }

    public int turnedRight(boolean right) {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return 0;
    }

    public void reset(boolean right) {
        if(right) {
            this.right.reset();
        } else {
            this.left.reset();
        }
    }
    
    public void reset() {
        this.reset(true);
        this.reset(false);
    }

    public void setup() {
        this.left.start();
        this.right.start();
    }
    
}
