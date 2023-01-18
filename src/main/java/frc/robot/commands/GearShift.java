// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class GearShift extends CommandBase {
  /** Creates a new GearShift. */
  private final DriveTrain driveTrain;
  public GearShift(DriveTrain driveSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = driveSubsystem;
    addRequirements(driveTrain);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.shiftGears();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
