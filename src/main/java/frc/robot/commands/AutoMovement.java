// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// A complex auto command that drives forward, 

public class AutoMovement extends SequentialCommandGroup{
    /**Creates a new AutoMovement 
     * 
     * @param drivetrain The drivetrain subsystem this command group will run on
     */
    public AutoMovement(RomiDrivetrain drivetrain){
        addCommands(
            //Drive forward the specified amount of time
            new DriveForwardTimed(drivetrain, 1.0, -0.6), 
            new TurnRight(drivetrain, -0.6),
            new TurnLeft(drivetrain, -0.6),
            new DriveBackwardsTimed(drivetrain, 1.0, -0.6)
            //DriveForwardTimed command using the drivetrain object m_romiDrivetrain and with a power -0.6, for 1 second

        );
    }
}