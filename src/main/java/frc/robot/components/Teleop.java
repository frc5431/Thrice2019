package frc.robot.components;

//import frc.robot.components.Climber;
import frc.robot.components.Drivebase;
import frc.robot.components.Arm;
import frc.robot.components.Intake;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.Titan;

public class Teleop{
    private Titan.Xbox driver;

    public Teleop(){
    driver = new Titan.Xbox(Constants.DRIVER_JOYSTICK_ID);
    driver.setDeadzone(Constants.DRIVER_JOYSTICK_DEADZONE);
    }

    public void periodic(final Robot robot){
        robot.getDrivebase().drive(-driver.getRawAxis(Titan.Xbox.Axis.LEFT_Y)/2, driver.getRawAxis(Titan.Xbox.Axis.RIGHT_Y)/2);
   
        if(driver.getRawButton(Titan.Xbox.Button.BUMPER_R)) {
          robot.getIntake().runIntake(.75);
        } else if(driver.getRawButton(Titan.Xbox.Button.BUMPER_L)) {
            robot.getIntake().runIntake(-.75);
        } else {
          robot.getIntake().runIntake(0);
        }
    
        robot.getArm().runArm((driver.getRawAxis(Titan.Xbox.Axis.TRIGGER_LEFT)));
        if(driver.getRawAxis(Titan.Xbox.Axis.TRIGGER_LEFT) == 0){
            robot.getArm().runArm(-(driver.getRawAxis(Titan.Xbox.Axis.TRIGGER_RIGHT)));
        }
    }

    public Titan.Xbox getDriver(){
        return driver;
    }

}