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
    public double speed;    
    }
    public double getJoystick(boolean rightStick, boolean yAxis) {
        {if ((rightStick = true) && (yAxis = true))
            {getJoystick = rightStick.getY() };
        else if ((rightStick = true) && (yAxis = false)
            {getJoystick = rightStick.getX() };
        else if ((rightstick = false) && (yAxis = true))
            {getJoystick = leftStick.getY() };
        else
            {getJoystick = leftStick.getX() };
        }    
        {if (getJoystick == 0)
            {speed = 0};
        else if (getJoystick > 0)
            {speed = getJoystick * 100}; //foward
        else if (getJoystick < 0)
            {speed = getJoystick * 100}; //backward
        /** the double is the the joystick movement from -1 to 1
         *  I need to find out how to convert the comments below into syntax
         */
        }
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return 0;
    }

    public boolean getButton(int buttonNum) {
        speed = getSpeed //from Move.java
        Scanner scan = new Scanner (System.in);
        int buttonNum = scan.nextInt();
        if getButton (true)
            {if (buttonNum = 0)
                {//preform function of aButton
                };
            else if (buttonNum = 1)
                {//preform function of bButton
                };
            else if (buttonNum = 2)
                {//preform function of yButton
                };
            else if (buttonNum = 3)
                {//preform function of xButton
                };
            else if (buttonNum = 4)
                {//preform function of rtButton
                };
            else if (buttonNum = 5)
                {//preform function of rbButton
                };
            else if (buttonNum = 6)
                {//preform function of ltButton
                };
            else if (buttonNum = 7)
                {//preform function of lbButton
                };   
            else if (buttonNum = 8)
                {//preform function of backButton
                };  
            else if (buttonNum = 9)
                {//preform function of startButton
                };   
            else if (buttonNum = 10)
                {if (speed = 0)
                    {speed = speed + 10};
                else    
                    {speed = speed + speed/10}; // upButton
                };   
            else if (buttonNum = 11)
                {if (speed = 0)
                    {speed = speed - 10};
                 else 
                    {speed = speed - speed/10}; // downButton
                };    
            else if (buttonNum = 12)
                {speed = 0 //leftButton: reset
                };
            else if (buttonNum = 13)
                {speed = 0 //rightButton: reset
                };    
            else if (buttonNum = 14)
                {//preform function of leftJoyButton
                };    
            else if (buttonNum = 15)
                {//preform function of rightJoyButton
                };        
                }
            }
        else
            {// keep scanning
            }
    
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return false;
    }
    
}
