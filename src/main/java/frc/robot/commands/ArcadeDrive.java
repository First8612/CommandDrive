package frc.robot.commands;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.Drivebase;

public class ArcadeDrive extends RunCommand {
    public ArcadeDrive(DoubleSupplier speedSupplier, DoubleSupplier rotationSupplier, Drivebase drivebase) {
        super(() -> {
            drivebase.arcadeDrive(speedSupplier.getAsDouble(), rotationSupplier.getAsDouble());
        }, drivebase);
    }
}
