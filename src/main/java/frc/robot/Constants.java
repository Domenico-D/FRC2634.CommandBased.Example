// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import edu.wpi.first.wpilibj.drive.Vector2d;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public final class CanDeviceIds {
        public final static int BACK_LEFT_MOTOR_ID = 0;
        public final static int CENTER_LEFT_MOTOR_ID = 1;
        public final static int FRONT_LEFT_MOTOR_ID = 2;
        public final static int BACK_RIGHT_MOTOR_ID = 3;
        public final static int CENTER_RIGHT_MOTOR_ID = 4;
        public final static int FRONT_RIGHT_MOTOR_ID = 5;
    }

    public final class PCMIds {
        public final static int LEFT_DRIVE_SOLENOID_FORWARD = 0;
        public final static int LEFT_DRIVE_SOLENOID_REVERSE = 1;
        public final static int RIGHT_DRIVE_SOLENOID_FORWARD = 2;
        public final static int RIGHT_DRIVE_SOLENOID_REVERSE = 3;
    }

}
