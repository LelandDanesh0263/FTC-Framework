package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.debug.AccumulationControlledDcMotor;
import org.firstinspires.ftc.teamcode.debug.AccumulationControlledServo;

@TeleOp()
public class TankDrive extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AccumulationControlledDcMotor left = new AccumulationControlledDcMotor.AccumulationControlledDcMotorBuilder((DcMotor) hardwareMap.get("left"))
                .setkP(0.15)
                .build();

        left.setDirection(DcMotorSimple.Direction.REVERSE);

        AccumulationControlledDcMotor right = new AccumulationControlledDcMotor.AccumulationControlledDcMotorBuilder((DcMotor) hardwareMap.get("right"))
                .setkP(0.15)
                .build();

        right.setDirection(DcMotorSimple.Direction.FORWARD);

        AccumulationControlledServo leftPlow = new AccumulationControlledServo.AccumulationControlledServoBuilder((Servo) hardwareMap.get("leftPlow"))
                .setkP(0.25)
                .build();

        AccumulationControlledServo rightPlow = new AccumulationControlledServo.AccumulationControlledServoBuilder((Servo) hardwareMap.get("rightPlow"))
                .setkP(0.25)
                .build();

        Servo eye = (Servo) hardwareMap.get("eye");

        waitForStart();

        while (opModeIsActive() && !isStopRequested()) {
            if (gamepad1.right_stick_button) {
                left.setPower(0);
                right.setPower(0);
            } else {
                left.setPower(-gamepad1.left_stick_y - gamepad1.right_stick_x);
                right.setPower(-gamepad1.left_stick_y + gamepad1.right_stick_x);
            }

            if (gamepad1.square){
                eye.setPosition(0.5);
            }
            if (gamepad1.triangle){
                eye.setPosition(0.345);
            }

            if (gamepad1.circle){
                eye.setPosition(0.25);
            }

            leftPlow.setPosition(gamepad1.left_trigger-gamepad1.right_trigger);
            rightPlow.setPosition(gamepad1.right_trigger-gamepad1.left_trigger);

            telemetry.addData("Left Power", left.getPower());
            telemetry.addData("Right Power", right.getPower());
            telemetry.addData("Left Velo", left.getVelocity(AngleUnit.RADIANS));
            telemetry.addData("Right Velo", right.getVelocity(AngleUnit.RADIANS));
            telemetry.addData("leftPlow", leftPlow.getPosition());
            telemetry.addData("rightPlow", rightPlow.getPosition());
            telemetry.update();
        }
    }
}
