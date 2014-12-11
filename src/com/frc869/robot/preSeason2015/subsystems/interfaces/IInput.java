/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems.interfaces;

/**
 *
 * @author Michael
 */
public interface IInput {
    public final static int aButton = 0;
    public final static int bButton = 1;
    public final static int yButton = 2;
    public final static int xButton = 3;
    public final static int rtButton = 4;
    public final static int rbButton = 5;
    public final static int ltButton = 6;
    public final static int lbButton = 7;
    public final static int backButton = 8;
    public final static int startButton = 9;
    public final static int upButton = 10;
    public final static int downButton = 11;
    public final static int leftButton = 12;
    public final static int rightButton = 13;
    public final static int leftJoyButton = 14;
    public final static int rightJoyButton = 15;
    
    public double getJoystick(boolean rightStick, boolean yAxis);
    public boolean getButton(int buttonNum);
}
