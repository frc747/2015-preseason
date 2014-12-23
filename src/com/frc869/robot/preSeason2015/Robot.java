/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.frc869.robot.preSeason2015;

import com.frc869.robot.preSeason2015.subsystems.Encoders;
import com.frc869.robot.preSeason2015.subsystems.Limits;
import com.frc869.robot.preSeason2015.subsystems.Logging;
import com.frc869.robot.preSeason2015.subsystems.LogitechGamepad;
import com.frc869.robot.preSeason2015.subsystems.Move;
import com.frc869.robot.preSeason2015.subsystems.Spikes;
import com.frc869.robot.preSeason2015.subsystems.interfaces.IInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    private static final String TAG = "Robot";
    private Logging logger;
    private Encoders encoder;
    private Limits limits;
    private Move move;
    private Spikes spikes;
    private IInput controller;
    
    /**
     * Robot-wide initialization code should go here.
     *
     * Users should override this method for default Robot-wide initialization which will
     * be called when the robot is first powered on.  It will be called exactly 1 time.
     */
    public void robotInit() {
        logger = Logging.getInstance();
        logger.log(Logging.info, TAG, "Starting robot");
        encoder = Encoders.getInstance();
        limits = Limits.getInstance();
        move = Move.getInstance();
        spikes = Spikes.getInstance();
        controller = LogitechGamepad.getInstance();
        encoder.setup();
        limits.setup();
        this.getWatchdog().setExpiration(5);
        this.getWatchdog().setEnabled(true);
        logger.log(Logging.info, TAG, "Done starting robot");
    }

    /**
     * Initialization code for disabled mode should go here.
     *
     * Users should override this method for initialization code which will be called each time
     * the robot enters disabled mode.
     */
    public void disabledInit() {
        logger.log(Logging.info, TAG, "Disabled");
    }

    /**
     * Initialization code for autonomous mode should go here.
     *
     * Users should override this method for initialization code which will be called each time
     * the robot enters autonomous mode.
     */
    public void autonomousInit() {
        logger.log(Logging.info, TAG, "Use test mode not autonomous");
    }

    /**
     * Initialization code for teleop mode should go here.
     *
     * Users should override this method for initialization code which will be called each time
     * the robot enters teleop mode.
     */
    public void teleopInit() {
        logger.log(Logging.info, TAG, "Use test mode not teleoperated");
    }
    
    /**
     * Initialization code for test mode should go here.
     * 
     * Users should override this method for initialization code which will be called each time
     * the robot enters test mode.
     */
    public void testInit() {
        
    }
    
    /**
     * Periodic code for disabled mode should go here.
     *
     * Users should override this method for code which will be called periodically at a regular
     * rate while the robot is in disabled mode.
     */
    public void disabledPeriodic() {
        this.getWatchdog().feed();
        Timer.delay(0.001);
    }

    /**
     * Periodic code for autonomous mode should go here.
     *
     * Users should override this method for code which will be called periodically at a regular
     * rate while the robot is in autonomous mode.
     */
    public void autonomousPeriodic() {
        this.getWatchdog().feed();
        Timer.delay(0.001);
    }

    /**
     * Periodic code for teleop mode should go here.
     *
     * Users should override this method for code which will be called periodically at a regular
     * rate while the robot is in teleop mode.
     */
    public void teleopPeriodic() {
        this.getWatchdog().feed();
        Timer.delay(0.001);
    }
    
    /**
     * Periodic code for test mode should go here
     * 
     * Users should override this method for code which will be called periodically at a regular rate
     * while the robot is in test mode.
     */
    //treat this as teleoperated, it gives is amazing output on smartdashboard :)
    public void testPeriodic() {
        logger.log(Logging.info, TAG, "Test Loop Start");
        this.getWatchdog().feed();
        move.control(controller);
        spikes.control(controller);
        SmartDashboard.putNumber("Left encoder distance", encoder.getDistance(false));
        SmartDashboard.putNumber("Right encoder distance", encoder.getDistance(true));
        Timer.delay(0.001);
        logger.log(Logging.info, TAG, "Test Loop End");
    }
    
}
