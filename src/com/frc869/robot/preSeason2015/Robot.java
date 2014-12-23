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
    
    //start up the robot
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
        logger.log(Logging.info, TAG, "Done starting robot");
    }
    
    //treat this as teleoperated, it gives is amazing output on smartdashboard :)
    public void testPeriodic() {
        logger.log(Logging.info, TAG, "Test Loop Start");
        move.control(controller);
        spikes.control(controller);
        SmartDashboard.putNumber("Left encoder distance", encoder.getDistance(false));
        SmartDashboard.putNumber("Right encoder distance", encoder.getDistance(true));
        logger.log(Logging.info, TAG, "Test Loop End");
    }
    
}
