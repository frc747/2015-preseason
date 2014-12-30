/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.IInput;
import com.frc869.robot.preSeason2015.subsystems.interfaces.IMove;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Liam
 */
public class Move implements IMove {
    private final static String TAG = "Move";
    private final static String testTalonLeft = "Test talon left";
    private final static String testTalonLeftSpeed = "Test talon left speed";
    private final static String testTalonRight = "Test talon right";
    private final static String testTalonRightSpeed = "Test talon right speed";
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
    private final SendableChooser startLeftClockwise, stopLeftClockwise;
    private final SendableChooser startLeftCounterClockwise, stopLeftCounterClockwise;
    private final SendableChooser startRightClockwise, stopRightClockwise;
    private final SendableChooser startRightCounterClockwise, stopRightCounterClockwise;
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
        startLeftClockwise = limits.getLimitChooser();
        stopLeftClockwise = limits.getLimitChooser();
        startLeftCounterClockwise = limits.getLimitChooser();
        stopLeftCounterClockwise = limits.getLimitChooser();
        startRightClockwise = limits.getLimitChooser();
        stopRightClockwise = limits.getLimitChooser();
        startRightCounterClockwise = limits.getLimitChooser();
        stopRightCounterClockwise = limits.getLimitChooser();
        SmartDashboard.putData("Start left talon clockwise",startLeftClockwise);
        SmartDashboard.putData("Stop left talon clockwise",stopLeftClockwise);
        SmartDashboard.putData("Start left talon counter clockwise",startLeftCounterClockwise);
        SmartDashboard.putData("Stop left talon counter clockwise",stopLeftCounterClockwise);
        SmartDashboard.putData("Start right talon clockwise",startRightClockwise);
        SmartDashboard.putData("Stop right talon clockwise",stopRightClockwise);
        SmartDashboard.putData("Start right talon counter clockwise",startRightCounterClockwise);
        SmartDashboard.putData("Stop right talon counter clockwise",stopRightCounterClockwise);
        SmartDashboard.putBoolean(testTalonLeft, false);
        SmartDashboard.putNumber(testTalonLeftSpeed, 0);
        SmartDashboard.putBoolean(testTalonRight, false);
        SmartDashboard.putNumber(testTalonRightSpeed, 0);
    }
    public void setSpeed(boolean rightSpeedController, double speed) {
        if(rightSpeedController) {
            if(
                (speed>0 && !limits.getSwitch(stopRightClockwise)) || 
                (speed<0 && !limits.getSwitch(stopRightCounterClockwise))
            ) {
                right.set(speed);
            } else {
                right.set(0);
            }
        } else {
            if(
                (speed>0 && !limits.getSwitch(stopLeftClockwise)) || 
                (speed<0 && !limits.getSwitch(stopLeftCounterClockwise))
            ) {
                left.set(speed);
            } else {
                left.set(0);
            }
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
        if(stepLeft<1 && controller.getDpadY()>.1 && !leftUp) {
            leftUp = true;
            leftDown = false;
            stepLeft += .1;
        } else if(stepLeft>-1 && controller.getDpadY()<-.1 && !leftDown) {
            leftUp = false;
            leftDown = true;
            stepLeft -= .1;
        } else if (Math.abs(controller.getDpadY()<.1)) {
            leftUp = false;
            leftDown = false;
        }
        if(Math.abs(controller.getDpadX())>.1) {
            stepLeft = 0;
        }
        
        if(SmartDashboard.getBoolean(testTalonLeft, false) || controller.getButtonSelect()) {
            this.setSpeed(false,SmartDashboard.getNumber(testTalonLeftSpeed, 0));
        } else if(limits.getSwitch(startLeftClockwise)) {
            this.setSpeed(false,Math.abs(SmartDashboard.getNumber(testTalonLeftSpeed, 0)));
        } else if(limits.getSwitch(startLeftCounterClockwise)) {
            this.setSpeed(false,-Math.abs(SmartDashboard.getNumber(testTalonLeftSpeed, 0)));
        } else if(stepLeft!=0) {
            this.setSpeed(false,stepLeft);
        } else if(Math.abs(controller.getLeftY())>.1) {
            this.setSpeed(false,controller.getLeftY());
        }
        
        if(stepRight<1 && controller.getButtonY() && !rightUp) {
            rightUp = true;
            rightDown = false;
            stepRight += .1;
        } else if(stepRight>-1 && controller.getButtonA() && !rightDown) {
            rightUp = false;
            rightDown = true;
            stepRight -= .1;
        } else if (!controller.getButtonY() && !controller.getButtonA()) {
            rightUp = false;
            rightDown = false;
        }
        if(controller.getButtonX() || controller.getButtonB()) {
            stepRight = 0;
        }
        
        if(SmartDashboard.getBoolean(testTalonRight, false) || controller.getButtonStart()) {
            this.setSpeed(true,SmartDashboard.getNumber(testTalonRightSpeed, 0));
        } else if(limits.getSwitch(startRightClockwise)) {
            this.setSpeed(true,Math.abs(SmartDashboard.getNumber(testTalonRightSpeed, 0)));
        } else if(limits.getSwitch(startRightCounterClockwise)) {
            this.setSpeed(true,-Math.abs(SmartDashboard.getNumber(testTalonRightSpeed, 0)));
        } else if(stepRight!=0) {
            this.setSpeed(true,stepRight);
        } else if(Math.abs(controller.getRightY())>.1) {
            this.setSpeed(true,controller.getRightY());
        }
    }
}
