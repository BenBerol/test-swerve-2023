// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.DriveTrainConstants;;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.WheelSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final CANSparkMax frontRightAngleMotor = new CANSparkMax(DriveTrainConstants.frontRightAngleMotorID, MotorType.kBrushless);
  private final CANSparkMax frontRightSpeedMotor = new CANSparkMax(DriveTrainConstants.frontRightSpeedMotorID, MotorType.kBrushless);

  private final CANSparkMax frontLeftAngleMotor = new CANSparkMax(DriveTrainConstants.frontLeftAngleMotorID, MotorType.kBrushless);
  private final CANSparkMax frontLeftSpeedMotor = new CANSparkMax(DriveTrainConstants.frontLeftSpeedMotorID, MotorType.kBrushless);

  private final CANSparkMax backRightAngleMotor = new CANSparkMax(DriveTrainConstants.backRightAngleMotorID, MotorType.kBrushless);
  private final CANSparkMax backRightSpeedMotor = new CANSparkMax(DriveTrainConstants.backRightSpeedMotorID, MotorType.kBrushless);

  private final CANSparkMax backLeftAngleMotor = new CANSparkMax(DriveTrainConstants.backLeftAngleMotorID, MotorType.kBrushless);
  private final CANSparkMax backLeftSpeedMotor = new CANSparkMax(DriveTrainConstants.backLeftSpeedMotorID, MotorType.kBrushless);

  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final WheelSubsystem m_frontRightWheelSubsystem = new WheelSubsystem(frontRightAngleMotor, frontRightSpeedMotor);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
