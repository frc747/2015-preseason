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
        throw new RuntimeException("Not supported yet.");
    }

    public int getDirection(boolean rightSpike) {
        throw new RuntimeException("Not supported yet.");
    }

    public void control() {
        throw new RuntimeException("Not supported yet.");
    }
    
}
