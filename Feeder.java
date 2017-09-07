package org.usfirst.frc.team2212.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Feeder extends LimitedSubsystem{

	public static final double FEEDER_SPINNY_SPEED=0.67;
	public static final double FEEDER_TRAIN_SPEED=0.4;
	
	SpeedController FeederSpinnyMotor;
	SpeedController FeederTrainMotor;
	
	public Feeder(SpeedController spinnyMotor, SpeedController trainMotor){
		this.FeederSpinnyMotor = spinnyMotor;
		this.FeederTrainMotor = trainMotor;
	}
	
    public void initDefaultCommand() {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void move(double speedSpinny) {
		FeederSpinnyMotor.set(speedSpinny);
		FeederTrainMotor.set(Feeder.FEEDER_TRAIN_SPEED);
	}
	
}

