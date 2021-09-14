// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;


/** An example command that uses an example subsystem. */
public class TurnLeft extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})


  RomiDrivetrain drivetrain;

  public Timer turnLeftTimer = new Timer();
  public double time = 0.2;
  public double power = 0.6;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TurnLeft(RomiDrivetrain d_drivetrain, double p_power) {
    drivetrain = d_drivetrain;
    //Time determines how long the robot drives forward
    power = p_power;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.arcadeDrive(power, 0.0);
    turnLeftTimer.reset();
    turnLeftTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(power, -1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return turnLeftTimer.get() >= time;
  }
}
