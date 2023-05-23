package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;

public class WheelSubsystem extends SubsystemBase {
    private CANSparkMax angleMotor;
    private CANSparkMax speedMotor;

    public WheelSubsystem(CANSparkMax angleMotor, CANSparkMax speedMotor) {
        this.angleMotor = angleMotor;
        this.speedMotor = speedMotor;
    }

    
}
