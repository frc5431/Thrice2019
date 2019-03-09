package frc.robot.components;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;

public class Drivebase {
    private final WPI_TalonSRX frontRight, backRight, frontLeft, backLeft;

    public Drivebase(){
        frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_ID);
        frontRight.setInverted(Constants.FRONT_RIGHT_INVERTED);

        backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_ID);
        backRight.setInverted(Constants.BACK_RIGHT_INVERTED);

        frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_ID);
        frontLeft.setInverted(Constants.FRONT_LEFT_INVERTED);

        backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_ID);
        backLeft.setInverted(Constants.BACK_LEFT_INVERTED);
    }

    public void driveLeft(final double val){
        frontLeft.set(val);
        backLeft.set(val);
    }

    public void driveRight(final double val){
        frontRight.set(val);
        backRight.set(val);
    }

    public void drive(final double left, final double right){
        driveLeft(left);
        driveRight(right);
    }

}