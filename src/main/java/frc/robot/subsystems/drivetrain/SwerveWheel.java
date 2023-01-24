package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class SwerveWheel implements SwerveDrivetrainConstants {

	public String name;

	private WPI_TalonFX steerMotor;
	private AnalogInput absEnc;
	private WPI_TalonFX drive;

	private int countsWhenFrwd;

	public SwerveWheel(int m_drive, int m_steer, int analogEnc, int zeroOffset,
					   String name) {

		this.name = name;

		drive = new WPI_TalonFX(m_drive);
		steerMotor = new WPI_TalonFX(m_steer);

		countsWhenFrwd = zeroOffset;

		absEnc = new AnalogInput(analogEnc);

		// Reset all of the settings on startup
		steerMotor.configFactoryDefault();

		// Set the feedback device for the steering (turning) Talon SRX
		steerMotor.configSelectedFeedbackSensor(FeedbackDevice.Analog);

		// Set the current quadrature position relative to the analog position to make sure motor
		// has 0 position on startup
		steerMotor.setSelectedSensorPosition(getAbsAngleDeg() * QUAD_COUNTS_PER_ROT / 180);

		// Set the input range of the PIDF so that it will only accept angles between -180 to 180
		// and set it to continuous
		// getController().enableContinuousInput(-180, 180);

		// Sets name for viewing in SmartDashboard 
		// this.setName(name);


		// STEER MOTOR ADD PID and MOTION PROFILE

		steerMotor.configMotionAcceleration(kSteerAccel);
		steerMotor.configMotionCruiseVelocity(kSteerCruiseVel);

		steerMotor.config_kP(STR_POS_SLOT, kP_STEER);
		steerMotor.config_kI(STR_POS_SLOT, kI_STEER);
		steerMotor.config_kD(STR_POS_SLOT, kD_STEER);
		steerMotor.config_kF(STR_POS_SLOT, kF_STEER);


		// Drive Motor Velocity Loop
		drive.config_kP(DRV_POS_SLOT, kP_DRIVE);
		drive.config_kI(DRV_POS_SLOT, kI_DRIVE);
		drive.config_kD(DRV_POS_SLOT, kD_DRIVE);
		drive.config_kF(DRV_POS_SLOT, kF_DRIVE);




	}

	// Get the current angle of the analog encoder
	private int getAbsAngleDeg() {
		return (int)(180 * (absEnc.getValue() - countsWhenFrwd) / 4096);
	}

	// Get current ticks
	public int getTicks() {
		return (int)steerMotor.getSelectedSensorPosition();
	}

	public void setSpeed(double speed) {
		drive.set(ControlMode.Velocity, speed);
	}

	public void setSetpoint(double set) {
		steerMotor.set(ControlMode.MotionMagic, set);
	}

	// Convert ticks to angle bound from -180 to 180
	public double ticksToAngle(int ticks) {
		double angleTicks = ticks % QUAD_COUNTS_PER_ROT;

		double result = (angleTicks / (QUAD_COUNTS_PER_ROT / 2)) * 180;

		if (result > 180) {
			result -= 360;
		}

		return result;
	}

	public double getMeasurement() {

		return ticksToAngle((int)(steerMotor.getSelectedSensorPosition()));

	}

	// @Override
	// protected void useOutput(double output, double setpoint) {
	// 	steerMotor.set(ControlMode.PercentOutput, output);
	// }
}
