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
public interface ISpike extends IControlable {
    public final static int OFF = 3;
    public final static int FORWARD = 1;
    public final static int BACKWARD = 2;
    public void setDirection(int direction, boolean rightSpike);
    public int getDirection(boolean rightSpike);
}
