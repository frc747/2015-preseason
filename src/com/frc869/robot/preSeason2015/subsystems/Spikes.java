/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frc869.robot.preSeason2015.subsystems;

import com.frc869.robot.preSeason2015.subsystems.interfaces.ISpike;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author Liam
 */
public class Spikes implements ISpike {
    private final static String TAG = "Spikes";
    //Singleton
    private static Spikes instance;
    public static Spikes getInstance() {
        if(instance == null) {
            instance = new Spikes();
        }
        return instance;
    }
    private final Relay left, right;
    private final Encoders encoders;
    private final Limits limits;
    private final Input input;
    private final Logging logger;
    private Spikes() {
        left = new Relay(1);
        right = new Relay(2);
        encoders = Encoders.getInstance();
        limits = Limits.getInstance();
        input = Input.getInstance();
        logger = Logging.getInstance();
    }
    public void setDirection(int direction, boolean rightSpike) {
        switch(direction) {
            case ISpike.OFF:
                this.setDirectionValue(Relay.Value.kOff,rightSpike);
                break;
            case ISpike.FORWARD:
                this.setDirectionValue(Relay.Value.kForward,rightSpike);
                break;
            case ISpike.BACKWARD:
                this.setDirectionValue(Relay.Value.kReverse,rightSpike);
                break;
            default:
                logger.log(Logging.wtf, TAG, "Unknown direction "+direction);
                break;
        }
    }
    public void setDirectionValue(Relay.Value direction, boolean rightSpike) {
        if(rightSpike) {
            right.set(direction);
        } else {
            left.set(direction);
        }
    }

    public int getDirection(boolean rightSpike) {
        if(this.getDirectionValue(rightSpike).equals(Relay.Value.kForward)) {
            return ISpike.FORWARD;
        } else if(this.getDirectionValue(rightSpike).equals(Relay.Value.kReverse)) {
            return ISpike.BACKWARD;
        } else {
            return ISpike.OFF;
        }
        
    }
    
    public Relay.Value getDirectionValue(boolean rightSpike) {
        if(rightSpike) {
            return right.get();
        } else {
            return left.get();
        }
    }

    public void control() {
        throw new RuntimeException("Not supported yet.");
    }
    
}
