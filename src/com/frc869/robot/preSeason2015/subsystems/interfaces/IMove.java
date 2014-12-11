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
public interface IMove extends IControlable {
    public void setSpeed(boolean clockwise, boolean rightSpeedController, double speed);
    public double getSpeed(boolean rightSpeedController);
    public boolean getDirection(boolean rightSpeedController);
}
