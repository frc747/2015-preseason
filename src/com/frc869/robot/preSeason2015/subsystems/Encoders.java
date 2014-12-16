/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.IEncoders;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author Kurt
 */
public class Encoders implements IEncoders {
    private final static String TAG = "Encoders";
    //Singleton
    private static Encoders instance;
    public static Encoders getInstance() {
        if(instance == null) {
            instance = new Encoders();
        }
        return instance;
    }
    
    private final Encoder left, right;
    private final Logging logger;
    private Encoders() {
        //digital inputs 13 & 14
        left = new Encoder(13,14, true);
        //digital inputs 9 & 10
        right = new Encoder(11,12, false);
        logger = Logging.getInstance();
    }
    public double getDistance(boolean right) {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return 0;
    }

    public int turnedLeft(boolean right) {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return 0;
    }

    public int turnedRight(boolean right) {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
        return 0;
    }

    public void reset(boolean right) {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
    }

    public void setup() {
        logger.log(Logging.wtf, TAG, "Not supported yet.");
    }
    

//My code starts here; Im sure there will be many mistakes, please let me know what and where they are and I will correct the immediately, sorry for the inconvenience.
    
    public boolean Direction(forwards);
    public int WheelCirc =??? //The circumference of the wheel will be need to find direction
    public int RotationNum =??? ///Im not entirely sure of how to retrieve this information from the encoders
    public int Distance = WheelCirc * RotationNum;
    public int Time = //I am not sure how to code any type of time keeping device in java.  If i was more familiar with the syntax, It would count the seconds from when directional input began and when it ends
    public int Speed = Distance/Time;
    
        if (Direction = forwards){
            system.out.print(Distance);
            system.out.print("forwards at");
            system.out.print(Speed);
            system.out.print("feet/second");
        }
}       else {
            system.out.print(Distance);
            system.out.print("backwards at");
            system.out.print(Speed);
            system.out.print("feet/second");
}
}
