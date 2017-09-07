package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveTank;
import com.spikes2212.utils.DoubleSpeedcontroller;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends TankDrivetrain {

	private DoubleSpeedcontroller gearboxLeft;
	private DoubleSpeedcontroller gearboxRight;

	public Drivetrain(DoubleSpeedcontroller gearboxLeft, DoubleSpeedcontroller gearboxRight) {
		this.gearboxLeft = gearboxLeft;
		this.gearboxRight = gearboxRight;
	}

	public Drivetrain(SpeedController leftFront, SpeedController leftRear, SpeedController rightFront,
			SpeedController rightRear) {
		gearboxLeft = new DoubleSpeedcontroller(leftFront, leftRear);
		gearboxRight = new DoubleSpeedcontroller(rightFront, rightRear);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveTank(Robot.drivetrain, Robot.oi::getLeftY, Robot.oi::getRightY));
	}

	@Override
	public PIDSource getLeftPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PIDSource getRightPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLeft(double speed) {
		gearboxLeft.set(speed);
	}

	@Override
	public void setRight(double speed) {
		gearboxRight.set(speed);
	}
}
