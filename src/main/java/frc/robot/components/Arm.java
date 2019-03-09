package frc.robot.components;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;

public class Arm{
    private final WPI_TalonSRX arm;

    public Arm(){
        arm = new WPI_TalonSRX(Constants.ARM_ID);
        arm.setInverted(Constants.ARM_INVERTED);
    }
    
    public void runArm(final double speed) {
        arm.set(speed);
    }

}