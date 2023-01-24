package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.drivetrain.SwerveWheelController;

public class TeleopDrive extends CommandBase {

	private final SwerveWheelController swerve;


	private boolean currentFOD = false;

	public TeleopDrive() {

		addRequirements(Robot.swerve);
		
	}

	@Override
	public void initialize() {
		currentFOD = swerve.getFOD();

		swerve.resetGyro();
	}

	@Override
	public void execute() {
		if (Robot.driver.getAButton()) {
			swerve.resetGyro();
		}

		if (Robot.driver.getBButton()) {
			currentFOD = !currentFOD;
			swerve.setFOD(currentFOD);
		}

		swerve.drive(Robot.driver.getLeftX(), Robot.driver.getLeftY(),
					 Robot.driver.getRightX(), swerve.gyroAngle());

		System.out.println(swerve.gyroAngle());
	}
}
