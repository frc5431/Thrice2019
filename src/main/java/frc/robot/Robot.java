package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.components.Arm;
//import frc.robot.components.Climber;
import frc.robot.components.Drivebase;
import frc.robot.components.Intake;
import frc.robot.components.Teleop;

public class Robot extends TimedRobot {
  private static enum Mode{
    DISABLED, TELEOP
  }

  private Mode mode = Mode.DISABLED;

  //private Climber climber;
  private Drivebase driveBase;
  private Arm arm;
  private Intake intake;

  private Teleop teleop;

  @Override
  public void robotInit() {
    teleop = new Teleop();

    //climber = new Climber();
    driveBase = new Drivebase();
    arm = new Arm();
    intake = new Intake();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void teleopInit() {
    mode = Mode.TELEOP;
  }

  @Override
  public void teleopPeriodic() {
    teleop.periodic(this);
  }

  @Override
  public void disabledInit(){
    mode = Mode.DISABLED;
  }

  public Mode getMode(){
    return mode;
  }

  public Teleop getTeleop(){
    return teleop;
  }
  
  public Arm getArm(){
     return arm;
  }

  // public Climber getClimber(){
  //   return climber;
  // }

  public Drivebase getDrivebase(){
     return driveBase;
  }

  public Intake getIntake(){
    return intake;
  }
}