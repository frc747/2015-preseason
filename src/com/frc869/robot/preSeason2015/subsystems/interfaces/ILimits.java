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
public interface ILimits extends ISensor {
    //get the limit switch real value
    public boolean getRealSwitch(int number);
    
    //get the driver station information of whether or not the limit switch should be inversed
    public boolean getInversed(int number);
    
    //get the switch value based on the real value and whether or not it is inversed
    public boolean getSwitch(int number);
}
