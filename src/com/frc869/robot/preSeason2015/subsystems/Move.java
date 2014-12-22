/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.IMove;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author Liam
 */
public class Move implements IMove {
    private final static String TAG = "Move";
    //Singleton
    private static Move instance;
    public static Move getInstance() {
        if(instance == null) {
            instance = new Move();
        }
        return instance;
    }
    private final Talon left, right;
    private final Encoders encoders;
    private final Limits limits;
    private final Input input;
    private final Logging logger;
    private Move() {
        left = new Talon(1);
        right = new Talon(2);
        encoders = Encoders.getInstance();
        limits = Limits.getInstance();
        input = Input.getInstance();
        logger = Logging.getInstance();
    }
    public void setSpeed(boolean rightSpeedController, double speed) {
        if(rightSpeedController) {
            right.set(speed);
        } else {
            left.set(speed);
        }
    }
    public void setSpeed(boolean clockwise, boolean rightSpeedController, double speed) {
        if(clockwise) {
            this.setSpeed(rightSpeedController,speed);
        } else {
            this.setSpeed(rightSpeedController,-speed);
        }
    }
    
    public double getRawSpeed(boolean rightSpeedController) {
        if(rightSpeedController) {
            return right.get();
        } else {
            return left.get();
        }
    }

    public double getSpeed(boolean rightSpeedController) {
        if(rightSpeedController) {
            return Math.abs(right.get());
        } else {
            return Math.abs(left.get());
        }
    }

    public boolean getDirection(boolean rightSpeedController) {
        if(rightSpeedController) {
            return right.get()>0;
        } else {
            return left.get()>0;
        }
    }

    public void control() {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
    }
    
}
