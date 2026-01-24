// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */



SparkMax r_motor_1; //creating motors
SparkMax r_motor_2;
SparkMax l_motor_1;
SparkMax l_motor_2;

SparkMax pivot_motor;

SparkMaxConfig follow_config_1;
SparkMaxConfig follow_config_2;
SparkMaxConfig motor_config;

double x;
double y;







  public Drivetrain() {


    r_motor_1 = new SparkMax(Constants.r_motor_1_id, MotorType.kBrushless); //initializing motors
    r_motor_2 = new SparkMax(Constants.r_motor_2_id, MotorType.kBrushless); 
    l_motor_1 = new SparkMax(Constants.l_motor_1_id, MotorType.kBrushless); 
    l_motor_2 = new SparkMax(Constants.l_motor_2_id, MotorType.kBrushless); 

    pivot_motor = new SparkMax(Constants.pivot_motor_id, MotorType.kBrushless);


    follow_config_1 = new SparkMaxConfig(); //initializing configs
    follow_config_2 = new SparkMaxConfig();
    motor_config = new SparkMaxConfig();

    follow_config_1
    .inverted(false)
    .follow(1)
    .idleMode(IdleMode.kBrake);

    follow_config_2 //config for following motors
    .inverted(false)
    .follow(3)
    .idleMode(IdleMode.kBrake);

    motor_config
    .inverted(false)
    .idleMode(IdleMode.kBrake);


    this.r_motor_1.configure(motor_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters); //applying configurations

    this.r_motor_2.configure(follow_config_1, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    this.l_motor_1.configure(motor_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    this.r_motor_2.configure(follow_config_2, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);


  }


  public void arcade(Joystick r_Joystick, Joystick l_Joystick){

  x = r_Joystick.getX();
  y = -r_Joystick.getY();

  r_motor_1.set(y - x);
  l_motor_1.set(y + x);


  }

  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
