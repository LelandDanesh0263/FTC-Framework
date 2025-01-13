package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.shprobotics.pestocore.drivebases.MecanumController;
import com.shprobotics.pestocore.drivebases.TeleOpController;
import com.shprobotics.pestocore.drivebases.ThreeWheelOdometryTracker;
import com.shprobotics.pestocore.geometries.Pose2D;

@TeleOp
public class Test extends LinearOpMode {
    @Override
    public void runOpMode() {
        MecanumController mecanumController = PestoFTCConfig.getMecanumController(hardwareMap);
        ThreeWheelOdometryTracker tracker = PestoFTCConfig.getTracker(hardwareMap);
        TeleOpController teleOpController = PestoFTCConfig.getTeleOpController(mecanumController, tracker, hardwareMap);

        Pose2D currentPosition;
        double heading = tracker.getCurrentPosition().getHeadingRadians();

        DcMotor wormGearMotor = hardwareMap.get(DcMotor.class, "wormGear");
        wormGearMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        wormGearMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        wormGearMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        DcMotor strongArmMotor = hardwareMap.get(DcMotor.class, "strongArm");
        strongArmMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        strongArmMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        strongArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//        DcMotorEx strongArm2Motor = hardwareMap.get(DcMotor.class, "strongArm2");
//        strongArm2Motor.setDirection(DcMotorSimple.Direction.REVERSE);
//        strongArm2Motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        strongArm2Motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        DcMotor viperSlide = hardwareMap.get(DcMotor.class, "viperSlide");
        viperSlide.setDirection(DcMotorSimple.Direction.FORWARD);
        viperSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        viperSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Servo claw = hardwareMap.get(Servo.class, "Claw");
        claw.setDirection(Servo.Direction.REVERSE);

        waitForStart();
        tracker.reset();

        while (opModeIsActive()) {
            tracker.update();
            updateTelemetry(telemetry);
            currentPosition = tracker.getCurrentPosition();
            heading = tracker.getCurrentPosition().getHeadingRadians();

            teleOpController.driveFieldCentric(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

            //wormGearMotor Code
            if (gamepad1.right_trigger > 0.2) {
                wormGearMotor.setPower(gamepad1.right_trigger);
            } else if (gamepad1.left_trigger > 0.2) {
                wormGearMotor.setPower(-gamepad1.left_trigger);
            } else {
                wormGearMotor.setPower(0.0);
            }

//            //Move to hanging positions
//            if (gamepad2.dpad_up) {
//                viperSlide.setTargetPosition(-5447);
//                wormGearMotor.setTargetPosition(-1916);
//                strongArmMotor.setTargetPosition(-3636);
//            }

            // StrongArm Code
            if (gamepad2.right_stick_y>0.2){
                strongArmMotor.setPower(gamepad2.right_stick_y);
            } else if (gamepad2.right_stick_y < 0.2) {
                strongArmMotor.setPower(gamepad2.right_stick_y);
            } else strongArmMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

//           //StrongArm2 Code
//            if (gamepad2.left_stick_y > 0.2){
//                strongArm2Motor.setPower(gamepad2.right_stick_y);
//            } else if (gamepad2.left_stick_y < 0.2) {
//                strongArm2Motor.setPower(gamepad2.left_stick_y);
//            } else strongArm2Motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


            //Viper Slide Code
            if (gamepad1.right_stick_y>0.2 && !(viperSlide.getCurrentPosition()<-1500 && wormGearMotor.getCurrentPosition()>15000)){
                viperSlide.setPower(gamepad1.right_stick_y);
            } else if (gamepad1.right_stick_y<0.2) {
                viperSlide.setPower(gamepad1.right_stick_y);
            }
            else {
                viperSlide.setPower(0.0);
            }

//            if (viperSlide.getCurrentPosition() > -1416 && wormGearMotor.getCurrentPosition() > 6153) {
//                viperSlide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//            }

            //Claw
            if (gamepad1.x){
                claw.setPosition(1.00);
            }
            if (gamepad1.y){
                claw.setPosition(0.74);
            }

            telemetry.addData("X", currentPosition.getX());
            telemetry.addData("Y", currentPosition.getY());
            telemetry.addData("Rotation", heading);
            telemetry.addData("odometryPodLeft", tracker.leftOdometry.getInchesTravelled());
            telemetry.addData("odometryPodCenter", tracker.centerOdometry.getInchesTravelled());
            telemetry.addData("odometryPodRight", tracker.rightOdometry.getInchesTravelled());
            telemetry.addData("wormGearMotor", wormGearMotor.getCurrentPosition());
            telemetry.addData("StrongArm", strongArmMotor.getCurrentPosition());
//            telemetry.addData("strongArm2", strongArm2Motor.getCurrentPosition());
            telemetry.addData("ViperSlide", viperSlide.getCurrentPosition());
            telemetry.addData("Claw", claw.getPosition());
            telemetry.update();

            if (gamepad1.b) {
                tracker.reset();
                teleOpController.resetIMU();
            }

        }
    }
}

//12/7 Comp Code