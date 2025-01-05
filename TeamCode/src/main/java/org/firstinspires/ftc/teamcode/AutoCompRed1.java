package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.shprobotics.pestocore.drivebases.MecanumController;
import com.shprobotics.pestocore.drivebases.ThreeWheelOdometryTracker;

//@Autonomous(name = "AutoCompRed1", group = "Autonomous") public class AutoCompRed1 extends LinearOpMode {

@Autonomous
public class AutoCompRed1 extends LinearOpMode {

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private Servo spinner;
    private DistanceSensor DistanceSensor;

    @Override
    public void runOpMode() {
        MecanumController mecanumController = PestoFTCConfig.getMecanumController(hardwareMap);
        ThreeWheelOdometryTracker threeWheelOdometryTracker = PestoFTCConfig.getTracker(hardwareMap);

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        spinner = hardwareMap.get(Servo.class, "Spinner");
        DistanceSensor = hardwareMap.get(DistanceSensor.class, "Distance Sensor");

//        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
//        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
//        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        //Strafe Right
//        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
//        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
//       spinner.setDirection(Servo.Direction.REVERSE);

        //Strafe left
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        spinner.setDirection(Servo.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive())  {

            //Strafe Right
//            frontLeft.setPower(0.5);
//            frontRight.setPower(-0.5);
//            backLeft.setPower(-0.5);
//            backRight.setPower(0.5);

            //Strafe left
            frontLeft.setPower(0.5);
            frontRight.setPower(-0.5);
            backLeft.setPower(-0.5);
            backRight.setPower(0.5);



            sleep(1000);

            //STRAFE Right: 0.5 power for 1 second goes ~15in (~width of the bot itself)

            //Drive Forward
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.6);
            backRight.setPower(0.5);

            sleep(1000);

            //DRIVE FORWARD: 0.5 power for 1 second goes 32in

            //ALL STOP FOR TESTING
            frontLeft.setPower(0.0);
            frontRight.setPower(0.0);
            backLeft.setPower(0.0);
            backRight.setPower(0.0);
            sleep(1000);

            requestOpModeStop();

//            //Strafe Right
//            frontLeft.setPower(0.1);
//            frontRight.setPower(-0.1);
//            backLeft.setPower(-0.1);
//            backRight.setPower(0.1);
//
//            sleep(1200);

            //STRAFE RIGHT: 0.5 power for 1 second goes ~15in (~width of the bot itself)

//            //Turn Right
//            frontLeft.setPower(0.3);
//            frontRight.setPower(-0.3);
//            backLeft.setPower(0.3);
//            backRight.setPower(-0.3);
//
//            sleep(1000);

//            //Drive Forward
//            frontLeft.setPower(0.7);
//            frontRight.setPower(0.7);
//            backLeft.setPower(0.7);
//            backRight.setPower(0.7);
//
//            sleep(1000);

            //DRIVE FORWARD: 0.5 power for 1 second goes 32in

            //SET PARAMETERS FOR THE BOT TO STOP WHEN DISTANCE SENSOR DETECTS WALL NEAR OBSERVATION ZONE

//            //Strafe Left
//            frontLeft.setPower(-0.5);
//            frontRight.setPower(0.5);
//            backLeft.setPower(0.5);
//            backRight.setPower(-0.5);
//
//            sleep(1000);
        }
    }
}