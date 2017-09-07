package org.usfirst.frc.team2212.robot.subsystems;

import org.usfirst.frc.team2212.robot.Robot;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gear extends LimitedSubsystem {

	public static final double GEAR_CLOSE_SPEED = -0.66;
	public static final double GEAR_OPEN_SPEED=0.5;
	private SpeedController gearmotor;
	private DigitalInput open;
	private DigitalInput closed;
	
	public Gear(SpeedController motor, DigitalInput open, DigitalInput closed){
		gearmotor=motor;
		this.open=open;
		this.closed=closed;
		
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new MoveLimitedSubsystem(Robot.gear, GEAR_CLOSE_SPEED));
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMax() {
		return open.get();
	}

	@Override
	public boolean isMin() {
		return closed.get();
	}

	@Override
	protected void move(double arg0) {
		gearmotor.set(arg0);
	}
}

