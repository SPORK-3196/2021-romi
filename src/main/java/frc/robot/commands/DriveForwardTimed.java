// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class DriveForwardTimed extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})


  RomiDrivetrain drivetrain;

  public Timer driveTimer = new Timer();
  public double time = 3.0;
  public double power = 0.6;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveForwardTimed(RomiDrivetrain d_drivetrain, double p_time, double p_power) {
    drivetrain = d_drivetrain;
    time = p_time
    //Time determines how long the robot drives forward
    power = p_power
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.drivetrain.arcadeDrive(power, 0.0);
    driveTimer.reset();
    driveTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.drivetrain.arcadeDrive(power, 0;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.drivetrain.arcadeDrive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return driveTimer.get() >= time;
  }
}
