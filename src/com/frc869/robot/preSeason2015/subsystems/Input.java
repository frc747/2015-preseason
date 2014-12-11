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
 * @author Liam
 */
public class Input implements IInput {
    private final static String TAG = "Input";
    //Singleton
    private static Input instance;
    public static Input getInstance() {
        if(instance == null) {
            instance = new Input();
        }
        return instance;
    }
    private final Joystick gamepad;
    private final Logging logger;
    private Input() {
        gamepad = new Joystick(1);
        logger = Logging.getInstance();
    }
    public double getJoystick(boolean rightStick, boolean yAxis) {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return 0;
    }

    public boolean getButton(int buttonNum) {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return false;
    }
    
}
