/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.IInput;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Michael
 */
public class LogitechGamepad implements IInput {
    private final static String TAG = "LogitechGamepad";
    //Singleton
    private static LogitechGamepad instance;
    public static LogitechGamepad getInstance() {
        if(instance == null) {
            instance = new LogitechGamepad();
        }
        return instance;
    }
    private final Joystick gamepad;
    private final Logging logger;
    private LogitechGamepad() {
        gamepad = new Joystick(1);
        logger = Logging.getInstance();
    }
    public double getJoystick(boolean rightStick, boolean yAxis) {
        if(rightStick) {
            if(yAxis) {
                return this.getRightY();
            } else {
                return this.getRightX();
            }
        } else {
            if(yAxis) {
                return this.getLeftY();
            } else {
                return this.getLeftX();
            }
        }
    }
    public boolean getButton(int buttonNum) {
        switch(buttonNum) {
            case IInput.aButton:
                return this.getButtonA();
            case IInput.bButton:
                return this.getButtonB();
            case IInput.xButton:
                return this.getButtonX();
            case IInput.yButton:
                return this.getButtonY();
            case IInput.lbButton:
                return this.getButtonL1();
            case IInput.rbButton:
                return this.getButtonR1();
            case IInput.ltButton:
                return this.getButtonL2();
            case IInput.rtButton:
                return this.getButtonR2();
            case IInput.backButton:
                return this.getButtonSelect();
            case IInput.startButton:
                return this.getButtonStart();
            case IInput.leftJoyButton:
                return this.getButtonL3();
            case IInput.rightJoyButton:
                return this.getButtonR3();
            case IInput.upButton:
                return this.getDpadY()>0;
            case IInput.downButton:
                return this.getDpadY()<0;
            case IInput.leftButton:
                return this.getDpadX()<0;
            case IInput.rightButton:
                return this.getDpadX()>0;
        }
        return false;
    }
    
    public boolean getButtonA() {
        return gamepad.getRawButton(2);
    }
    public boolean getButtonB() {
        return gamepad.getRawButton(3);
    }
    public boolean getButtonX() {
        return gamepad.getRawButton(1);
    }
    public boolean getButtonY() {
        return gamepad.getRawButton(4);
    }
    public boolean getButtonL1() {
        return gamepad.getRawButton(5);
    }
    public boolean getButtonR1() {
        return gamepad.getRawButton(6);
    }
    public boolean getButtonL2() {
        return gamepad.getRawButton(7);
    }
    public boolean getButtonR2() {
        return gamepad.getRawButton(8);
    }
    public boolean getButtonSelect() {
        return gamepad.getRawButton(9);
    }
    public boolean getButtonStart() {
        return gamepad.getRawButton(10);
    }
    public boolean getButtonL3() {
        return gamepad.getRawButton(11);
    }
    public boolean getButtonR3() {
        return gamepad.getRawButton(12);
    }
    public double getLeftX() {
        return gamepad.getRawAxis(1);
    }
    public double getLeftY() {
        return gamepad.getRawAxis(2);
    }
    public double getRightX() {
        return gamepad.getRawAxis(3);
    }
    public double getRightY() {
        return gamepad.getRawAxis(4);
    }
    public double getDpadX() {
        return gamepad.getRawAxis(5);
    }
    public double getDpadY() {
        return gamepad.getRawAxis(6);
    }
}
