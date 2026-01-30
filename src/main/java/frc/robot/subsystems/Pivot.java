// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;

public class Pivot extends SubsystemBase {

  SparkMax pivot_motor;

  SparkMaxConfig pivot_config;

  /** Creates a new Pivot. */
  public Pivot() {

    pivot_motor = new SparkMax(Constants.pivot_motor_id, MotorType.kBrushless);

    pivot_config = new SparkMaxConfig();

    pivot_config
    .inverted(false)
    .idleMode(IdleMode.kBrake);

    this.pivot_motor.configure(pivot_config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);



  }

  public void pivot(double pivot_speed, JoystickButton pivot_up, JoystickButton pivot_down){

    if (pivot_up.getAsBoolean()){
      pivot_motor.set(0.5);
    }
    else if (pivot_down.getAsBoolean()){

      pivot_motor.set(-0.5);

    }
    else {

      pivot_motor.set(0);
    }


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
