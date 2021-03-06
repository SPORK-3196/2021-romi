// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;


/** An example command that uses an example subsystem. */
public class JoystickDrive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})


  RomiDrivetrain drivetrain;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public JoystickDrive(RomiDrivetrain d_drivetrain) {
    drivetrain = d_drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //System.out.println("Functional");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftX = Robot.controllerDrive.getX(Hand.kLeft);
    double leftY = Robot.controllerDrive.getY(Hand.kLeft);
    boolean moveForward = Robot.controllerDrive.getAButton();
    boolean moveBackward = Robot.controllerDrive.getBButton();
    drivetrain.arcadeDrive(leftY * -1, leftX * 1);
    if (moveForward) {
      drivetrain.arcadeDrive(0.8, 0.0);
    }
    if (moveBackward) {
      drivetrain.arcadeDrive(0.8, 0.0);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
