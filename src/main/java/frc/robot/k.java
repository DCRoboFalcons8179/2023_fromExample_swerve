package frc.robot;

// OVERALL CONSTANTS

public interface k {


    public static interface Controls {

        int kDriverControllerPort = 0;

    }



    public static interface SwerveConstants {
        

        // Length and Width of robot in inches
        public final double L = 25;
        public final double W = 23;
    
        // STEER PID & MOTION PROFILE
    
        public final double kSteerAccel = 9000;
        public final double kSteerCruiseVel = 5000;
    
        public final int STR_POS_SLOT = 0;
        public final double kP_STEER = 0;
        public final double kI_STEER = 0;
        public final double kD_STEER = 0;
        public final double kF_STEER = 0;
    
    
        // DRIVE PID VEL
    
        public final int DRV_VEL_SLOT = 0;
        public final double kP_DRIVE_VEL = 0;
        public final double kI_DRIVE_VEL = 0;
        public final double kD_DRIVE_VEL = 0;
        public final double kF_DRIVE_VEL = 0;
    
    
        // DRIVE PID POSITION
    
        public final double kDriveAccel = 0;
        public final double kDriveCruiseVel = 0;
    
        public final int DRV_POS_SLOT = 1;
        public final double kP_DRIVE_POS = 0;
        public final double kI_DRIVE_POS = 0;
        public final double kD_DRIVE_POS = 0;
        public final double kF_DRIVE_POS = 0;
    
    
        
        // Quadrature Encoder Ticks per Rotation
        public final int QUAD_COUNTS_PER_ROT = 1658;
    
        // Talon SRX Turn Motor CAN ID
        public final int frontLeftTurnTalonID = 31;
        public final int frontRightTurnTalonID = 41;
        public final int backLeftTurnTalonID = 11;
        public final int backRightTurnTalonID = 21;
    
        // IDs for Drive Motors
        public final int frontLeftDriveID = 32;
        public final int frontRightDriveID = 42;
        public final int backLeftDriveID = 0;
        public final int backRightDriveID = 22;
    
        // Analog Encoder ID
        public final int frontLeftEncoderID = 0;
        public final int frontRightEncoderID = 1;
        public final int backLeftEncoderID = 2;
        public final int backRightEncoderID = 3;
    
        // Offset of analog to make encoders face forward
        public final int frontLeftEncoderOffset = 1850;
        public final int frontRightEncoderOffset = 3675;
        public final int backLeftEncoderOffset = 550;
        public final int backRightEncoderOffset = 1600;






    }



    
}
