// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends CommandBase {
  /** Creates a new ArcadeDrive. */
  private final DriveTrain driveTrain;
  private DoubleSupplier xSpeed;
  private DoubleSupplier zRotation;

  public ArcadeDrive(DriveTrain driveSubsystem, DoubleSupplier xSpeed, DoubleSupplier zRotation) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = driveSubsystem;
    this.xSpeed = xSpeed;
    this.zRotation = zRotation;
    addRequirements(driveTrain);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Still need to add joystick
    driveTrain.arcadeDrive(xSpeed.getAsDouble(), zRotation.getAsDouble());
  }


}
