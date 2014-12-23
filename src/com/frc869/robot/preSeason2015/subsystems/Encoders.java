/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.IEncoders;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Kurt
 */
public class Encoders implements IEncoders {
    private final static String TAG = "Encoders";
    private final static String driveGear = "Drive Gear";
    private final static String wheelGear = "Wheel Gear";
    private final static String pulsePerRotation = "Pulses per rotation";
    private final static String wheelDiameter = "Wheel Diameter";
    private final static String wheelBase = "Wheelbase";
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
        SmartDashboard.putNumber(driveGear, 72);
        SmartDashboard.putNumber(wheelGear, 11);
        SmartDashboard.putNumber(pulsePerRotation, 250);
        SmartDashboard.putNumber(wheelDiameter, 4);
        SmartDashboard.putNumber(wheelBase, 34.1);
    }
    public double getDistance(boolean right) {
        if(right) {
            return this.right.getDistance();
        } else {
            return this.left.getDistance();
        }
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
        this.left.stop();
        this.right.stop();
        double pulsePerRotationScaled = ((SmartDashboard.getNumber(driveGear, 1)/SmartDashboard.getNumber(wheelGear, 1)) * SmartDashboard.getNumber(pulsePerRotation, 0));
        double clicksPerInch = pulsePerRotationScaled / (Math.PI * SmartDashboard.getNumber(wheelDiameter, 1));
        double distancePerClick = (Math.PI * SmartDashboard.getNumber(wheelDiameter, 1)) / pulsePerRotationScaled;
        double distanceToSpin = (Math.PI * SmartDashboard.getNumber(wheelBase, 0) * clicksPerInch);
        this.left.setDistancePerPulse(distancePerClick);
        this.left.setMaxPeriod(10);
        this.left.setMinRate(10);
        this.left.start();
        this.right.start();
    }
    
}
