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
    public void setSpeed(boolean clockwise, boolean rightSpeedController, double speed) {
        
        logger.log(Logging.wtf, TAG, "Not supported yet.");
    }

    public double getSpeed(boolean rightSpeedController) {
        // getSpeed from joystick (the double)  from Input.java
        if (rightSpeedController = true)
            {//right talon
            }
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return 0;
    }

    public boolean getDirection(boolean rightSpeedController) {
        // getDirection from Input.java (foward=positve, backward=negative)
        if (getJoystick > 0)
            {getDirection = true);
        else if (getJoystick < 0)
            {getDirection = false};
        else
            {null};
        if getDirection = true
            {//foward
            }
        else 
            {//backward
            }
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return false;
    }

    public void control() {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
    }
    
}
