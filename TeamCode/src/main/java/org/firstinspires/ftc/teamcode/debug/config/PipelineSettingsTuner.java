package org.firstinspires.ftc.teamcode.debug.config;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.shplib.vision.PixelDetectionPipeline;
import org.firstinspires.ftc.teamcode.subsystems.VisionSubsystem;
import org.opencv.core.Scalar;

@Disabled
@TeleOp()
public class PipelineSettingsTuner extends LinearOpMode {
    boolean holdingUp, holdingDown, holdingLeft, holdingRight = false;
    VisionSubsystem visionSubsystem;

    double hue = 255, sat = 255, val = 255;

    enum TuningVar {
        Hue,
        Saturation,
        Value
    }

    public void update(TuningVar tuningVar, int increment) {
        switch (tuningVar) {
            case Hue:
                hue += increment;
                break;
            case Saturation:
                sat += increment;
                break;
            case Value:
                val += increment;
                break;
        }

        PixelDetectionPipeline.highYellow = new Scalar(hue, sat, val);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        visionSubsystem = new VisionSubsystem(hardwareMap, "pixel");
        visionSubsystem.pixelDetectionPipeline.setPipelineMode(PixelDetectionPipeline.PipelineMode.YELLOW_ONLY);

        TuningVar tuningVar = TuningVar.Hue;

        while (opModeInInit() && !isStopRequested()) {
            telemetry.addData("Tuning Var", tuningVar);
            telemetry.addData("hue", hue);
            telemetry.addData("sat", sat);
            telemetry.addData("val", val);
            telemetry.update();

            if (gamepad1.dpad_up) {
                if (!holdingUp) {
                    update(tuningVar, 3);
                }
                holdingUp = true;
            } else {
                holdingUp = false;
            }

            if (gamepad1.dpad_down) {
                if (!holdingDown) {
                    update(tuningVar, -3);
                }
                holdingDown = true;
            } else {
                holdingDown = false;
            }

            if (gamepad1.dpad_right) {
                if (!holdingRight) {
                    tuningVar = (TuningVar.values())[(tuningVar.ordinal() + 1) % 3];
                }
                holdingRight = true;
            } else {
                holdingRight = false;
            }

            if (gamepad1.dpad_left) {
                if (!holdingLeft) {
                    tuningVar = (TuningVar.values())[(tuningVar.ordinal() + 2) % 3];
                }
                holdingLeft = true;
            } else {
                holdingLeft = false;
            }
        }

        waitForStart();
    }
}
