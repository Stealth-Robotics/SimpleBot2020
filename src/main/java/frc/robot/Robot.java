/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;


/**
 * This sample program shows how to control a motor using a joystick. In the
 * operator control part of the program, the joystick is read and the value is
 * written to the motor.
 *
 * <p>
 * Joystick analog values range from -1 to 1 and speed controller inputs also
 * range from -1 to 1 making it easy to work together.
 */
public class Robot extends TimedRobot 
{
  private static final int kMotorPort1 = 54;
  private static final int kMotorPort2 = 58;
  private static final int kMotorPort3 = 57;
  private static final int kMotorPort4 = 55;
  private static final int kNEOWinchPort = 29;
  private static final int kLeftClimb = 30;
  private static final int kRightClimb = 36;
  private static final int k_NeoPort = 28;
  public static final int leftLimitSwitch = 3;
  public static final int rightLimitSwitch = 4;
   
  private DigitalInput mleftLimitSwitch; 
  private  DigitalInput mrightLimitSwitch;
 
//motor port = 57
  private WPI_TalonSRX m_motorLeft;
  private WPI_TalonSRX m_motorRight;
  private WPI_TalonSRX m_belt;
  
  private WPI_TalonSRX m_belt2;
  private XboxController m_DriveJoystick;
  private WPI_TalonSRX mleftClimber ;
  private WPI_TalonSRX mrightClimber;
  private final SpeedControllerGroup m_WINCHMotors = new SpeedControllerGroup(/*new CANSparkMax(k_NeoPort, MotorType.kBrushless, */new CANSparkMax(k_NeoPort, MotorType.kBrushless)
		);
  

  @Override
  public void robotInit() 
  {
       /// m_joystick = new Joystick(kJoystickPort);

    m_motorLeft = new WPI_TalonSRX(kMotorPort1);
    m_motorRight = new WPI_TalonSRX(kMotorPort2);
    m_belt = new WPI_TalonSRX(kMotorPort3);
    mleftLimitSwitch = new DigitalInput(leftLimitSwitch);
    mrightLimitSwitch  = new DigitalInput(rightLimitSwitch);
    m_belt2 = new WPI_TalonSRX(kMotorPort4);
    mleftClimber =  new WPI_TalonSRX(30);
    mrightClimber =  new WPI_TalonSRX(36);

  }
  @Override
  public void teleopInit()
  {
      
  }
  public void teleopPeriodic() {
   if(mleftLimitSwitch.get() || mrightLimitSwitch.get())
   { 
     
     mleftClimber.set(1);
     mrightClimber.set(1);
    m_WINCHMotors.set(1);
     
   }
   else 
    {
      mleftClimber.set(0);
     mrightClimber.set(0);
    m_WINCHMotors.set(0);

   }
     /*m_motorLeft.set(-0.8);
     m_motorRight.set(0.3);
     m_belt.set(.5);
     m_belt2.set(.5);
     m_ShooterMotors.set(-1);
  */
  }
  @Override
  public void disabledInit()
  {
    m_motorLeft.set(0);
    m_motorRight.set(0);
    m_belt.set(0);
    m_belt2.set(0);
    
  

  }
}
