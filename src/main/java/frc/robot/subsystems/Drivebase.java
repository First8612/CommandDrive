package frc.robot.subsystems;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
    private CANSparkMax m_left = new CANSparkMax(1, MotorType.kBrushed);
    private CANSparkMax m_leftFollower = new CANSparkMax(2, MotorType.kBrushed);
    private CANSparkMax m_right = new CANSparkMax(3, MotorType.kBrushed);
    private CANSparkMax m_rightFollower = new CANSparkMax(4, MotorType.kBrushed);

    private CANSparkMax[] m_allMotors = {
        m_right,
        m_rightFollower,
        m_left,
        m_leftFollower
    };

    private DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);


    public Drivebase() {
        for (var motor : this.m_allMotors) {
            motor.restoreFactoryDefaults();
            // motor.setOpenLoopRampRate(0.5);
        }

        m_rightFollower.follow(m_right);
        m_leftFollower.follow(m_left);
    }

    public void arcadeDrive(double speed, double rotation) {
        m_drive.arcadeDrive(speed, rotation, true);
    }
}
