package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.drivetrain.SwerveWheelController;

public class Robot extends TimedRobot {

	private Command m_autonomousCommand;


	public static XboxController driver = new XboxController(0);

	public static SwerveWheelController swerve = new SwerveWheelController();

	public static RobotContainer m_RobotContainer;






	@Override
	public void robotInit() {
		System.out.println("--------------");
		System.out.println("Robot Init");
		System.out.println("--------------");

		m_RobotContainer = new RobotContainer();


	}

	@Override
	public void robotPeriodic() {

		CommandScheduler.getInstance().run();

	}

	@Override
	public void disabledInit() {
		System.out.println("--------------");
		System.out.println("Disabled");
		System.out.println("--------------");
	}

	@Override
	public void autonomousInit() {
		System.out.println("--------------");
		System.out.println("Autonomous");
		System.out.println("--------------");
	}

	@Override
	public void autonomousPeriodic() {



	}

	@Override
	public void teleopInit() {
		System.out.println("--------------");
		System.out.println("Teleop");
		System.out.println("--------------");

	// This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		  }

	}

	@Override
	public void teleopPeriodic() {

	}



	@Override
	public void testInit() {
	  // Cancels all running commands at the start of test mode.
	  CommandScheduler.getInstance().cancelAll();
	}
  
	/** This function is called periodically during test mode. */
	@Override
	public void testPeriodic() {}
  
	/** This function is called once when the robot is first started up. */
	@Override
	public void simulationInit() {}
  
	/** This function is called periodically whilst in simulation. */
	@Override
	public void simulationPeriodic() {}



	
}
