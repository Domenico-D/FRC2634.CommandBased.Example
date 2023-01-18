// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  private WPI_TalonFX armJointMotor; 
  private WPI_TalonFX telescopeMotor;

  public Arm() {
    armJointMotor = new WPI_TalonFX(0);
    telescopeMotor = new WPI_TalonFX(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void RotateArmManual(double speed){
    armJointMotor.set(ControlMode.Position, speed);
    
  }
}
