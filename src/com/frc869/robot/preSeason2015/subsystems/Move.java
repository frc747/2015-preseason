/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.IInput;
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
    private boolean leftUp, leftDown, rightUp, rightDown;
    private double stepLeft,stepRight;
    private final Talon left, right;
    private final Encoders encoders;
    private final Limits limits;
    private final Logging logger;
    private Move() {
        left = new Talon(1);
        right = new Talon(2);
        encoders = Encoders.getInstance();
        limits = Limits.getInstance();
        logger = Logging.getInstance();
        stepLeft = 0;
        stepRight = 0;
        leftUp = false;
        leftDown = false;
        rightUp = false;
        rightDown = false;
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
    public void control(IInput controller) {
        if(stepLeft==0) {
            this.setSpeed(false,controller.getLeftY());
        } else {
            if(stepLeft<1 && controller.getDpadY()>.1 && !leftUp) {
                leftUp = true;
                leftDown = false;
                stepLeft += .1;
                if(stepLeft>1) {
                    stepLeft = 1;
                }
            } else if(stepLeft>-1 && controller.getDpadY()<-.1 && !leftDown) {
                leftUp = false;
                leftDown = true;
                stepLeft -= .1;
            } else {
                leftUp = false;
                leftDown = false;
            }
            if(controller.getDpadX()<.1 || controller.getDpadX()>-.1) {
                stepLeft = 0;
            }
            this.setSpeed(false,stepLeft);
        }
        if(stepRight==0) {
            this.setSpeed(true,controller.getRightY());
        } else {
            if(stepRight<1 && controller.getButtonX() && !rightUp) {
                rightUp = true;
                rightDown = false;
                stepRight += .1;
            } else if(stepRight>-1 && controller.getButtonA() && !rightDown) {
                rightUp = false;
                rightDown = true;
                stepRight -= .1;
            } else {
                rightUp = false;
                rightDown = false;
            }
            if(controller.getButtonY() || controller.getButtonB()) {
                stepRight = 0;
            }
            this.setSpeed(true,stepRight);
        }
    }
    
}
