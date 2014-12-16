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
        {if ((rightStick = true) && (yAxis = true))
            {//move double on y axis on rightstick
            };
        else if ((rightStick = true) && (yAxis = false)
            {// move double on x axis on rightstick
            };
        else if ((rightstick = false) && (yAxis = true))
            {// move double on y axis on leftstick
            };
        else
            {//move double on x axis on leftstick
            };
        }    
        {if (getJoystick == 0)
            {//no movement
            }
        else if (getJoystick > 0)
            {//move foward at (z/1 speed)
            }
        else if (getJoystick < 0)
            {//move backward at (z/-1 speed)
            }
        /** the double is the the joystick movement from -1 to 1
         * if double is 0,no movement; >0 is foward, <0 is backward
         * I read somewhere that on controllers, positive values for the y axis are actually backward
         * (pulling it towards the user) and vice versa. Is this true?
         */
        }
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return 0;
    }

    public boolean getButton(int buttonNum) {
        if (true)
            {if (buttonNum = 0)
                {//preform function of aButton
                };
            else if (buttonNum = 1)
                {//preform function of bButton
                };
            else if (buttonNum = 2)
                {//etc.
                };
            }
        else
            {//keep checking
            }
    
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return false;
    }
    
}
