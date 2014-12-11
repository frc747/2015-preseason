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
public interface IEncoders extends ISensor {
    public double getDistance(boolean right);
    public int turnedLeft(boolean right);
    public int turnedRight(boolean right);
    public void reset(boolean right);
}
