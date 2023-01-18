// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator.Validity;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  private WPI_TalonFX leftMotorBack;
  private WPI_TalonFX leftMotorCenter;
  private WPI_TalonFX leftMotorFront;

  private WPI_TalonFX rightMotorBack;
  private WPI_TalonFX rightMotorCenter;
  private WPI_TalonFX rightMotorFront;

  private MotorControllerGroup leftMotorControllerGroup;
  private MotorControllerGroup rightMotorControllerGroup;

  private DoubleSolenoid leftShiftSolenoid;
  private DoubleSolenoid rightShiftSolenoid;

  private DifferentialDrive differentialDrive;

  public DriveTrain() {
    leftMotorBack = new WPI_TalonFX(Constants.CanDeviceIds.BACK_LEFT_MOTOR_ID);
    leftMotorCenter = new WPI_TalonFX(Constants.CanDeviceIds.CENTER_LEFT_MOTOR_ID);
    leftMotorFront = new WPI_TalonFX(Constants.CanDeviceIds.FRONT_LEFT_MOTOR_ID);

    rightMotorBack = new WPI_TalonFX(Constants.CanDeviceIds.BACK_RIGHT_MOTOR_ID);
    rightMotorCenter = new WPI_TalonFX(Constants.CanDeviceIds.CENTER_RIGHT_MOTOR_ID);
    rightMotorFront = new WPI_TalonFX(Constants.CanDeviceIds.FRONT_RIGHT_MOTOR_ID);

    leftShiftSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
        Constants.PCMIds.LEFT_DRIVE_SOLENOID_FORWARD,
        Constants.PCMIds.LEFT_DRIVE_SOLENOID_REVERSE);

    rightShiftSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
        Constants.PCMIds.RIGHT_DRIVE_SOLENOID_FORWARD,
        Constants.PCMIds.RIGHT_DRIVE_SOLENOID_REVERSE);

    leftMotorControllerGroup = new MotorControllerGroup(leftMotorBack, leftMotorCenter, leftMotorFront);
    rightMotorControllerGroup = new MotorControllerGroup(rightMotorBack, rightMotorCenter, rightMotorFront);

    differentialDrive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);
  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    differentialDrive.arcadeDrive(xSpeed, zRotation);
  }

  public void shiftGears() {
    if (rightShiftSolenoid.get() == Value.kForward) {
      rightShiftSolenoid.set(Value.kReverse);
      leftShiftSolenoid.set(Value.kReverse);
    } else if (rightShiftSolenoid.get() == Value.kReverse) {
      rightShiftSolenoid.set(Value.kForward);
      leftShiftSolenoid.set(Value.kForward);
    } else {
      rightShiftSolenoid.set(Value.kOff);
      leftShiftSolenoid.set(Value.kOff);
    }
  }

  @Override
  public void periodic() {

  }
}
