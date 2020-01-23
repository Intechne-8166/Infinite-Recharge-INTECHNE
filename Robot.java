/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Robot extends TimedRobot {
  private PWMVictorSPX left = new PWMVictorSPX(0);     //A fix might be to import PWMVictorSPX's and use them instead of WPI_VictorSPX's  /* Old Code private WPI_VictorSPX leftFront = new WPI_VictorSPX(0)
  private PWMVictorSPX right = new PWMVictorSPX(1);    //2nd old code SpeedController leftFront = new PWMVictorSPX

  private DifferentialDrive drive = new DifferentialDrive(left, right);

  private Joystick joystick1 = new Joystick(0);

  @Override
  public void robotInit() {
    //If joystick degree is lower then 0.05 it doesnt move 
    drive.setDeadband(0.05);
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    double power = -joystick1.getRawAxis(1);
    double turn = joystick1.getRawAxis(4);

    drive.arcadeDrive(power * 0.6, turn * 0.3);
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}