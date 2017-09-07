package org.usfirst.frc.team2212.robot;

import org.usfirst.frc.team2212.robot.subsystems.Climber;
import org.usfirst.frc.team2212.robot.subsystems.Feeder;
import org.usfirst.frc.team2212.robot.subsystems.Gear;
import org.usfirst.frc.team2212.robot.subsystems.Picker;
import org.usfirst.frc.team2212.robot.subsystems.Shooter;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI /*GEVALD*/ {
	
	private Joystick joystickLeft;
	private Joystick joystickRight;
	
	private Button pickButton;
	private Button climbButton;
	private Button feedButton;
	private Button gearButton;
	private Button shootButton;
	
	public OI(){
		joystickLeft = new Joystick(0);
		joystickRight = new Joystick(1);
		
		pickButton = new JoystickButton(joystickRight, 1);
		feedButton = new JoystickButton(joystickRight, 2);
		gearButton = new JoystickButton(joystickRight, 3);
		climbButton = new JoystickButton(joystickLeft, 2);
		shootButton = new JoystickButton(joystickLeft, 1);
		
		pickButton.whileHeld(new MoveLimitedSubsystem(Robot.picker, Picker.PICKER_SPEED));
		climbButton.whenPressed(new MoveLimitedSubsystem(Robot.climber, Climber.CLIMBER_SPEED));
		feedButton.toggleWhenPressed(new MoveLimitedSubsystem(Robot.feeder, Feeder.FEEDER_SPINNY_SPEED));
		gearButton.whileHeld(new MoveLimitedSubsystem(Robot.gear, Gear.GEAR_OPEN_SPEED));
		shootButton.whileHeld(new MoveLimitedSubsystem(Robot.shooter, Shooter.SHOOTER_SPEED));
	}
	
	public double getLeftY(){
		return joystickLeft.getY();
	}
	
	public double getRightY(){
		return joystickRight.getY();
	}
}
