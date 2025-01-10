package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.shprobotics.pestocore.drivebases.MecanumController;
import com.shprobotics.pestocore.drivebases.ThreeWheelOdometryTracker;

//@Autonomous(name = "AutoCompRed1", group = "Autonomous") public class AutoCompRed1 extends LinearOpMode {

@Autonomous
public class AutoCompRed1 extends LinearOpMode {

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor wormGearMotor;
    private DcMotor viperslide;
    private DistanceSensor DistanceSensor;

    @Override
    public void runOpMode() {
        MecanumController mecanumController = PestoFTCConfig.getMecanumController(hardwareMap);
        ThreeWheelOdometryTracker threeWheelOdometryTracker = PestoFTCConfig.getTracker(hardwareMap);

        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        wormGearMotor = hardwareMap.get(DcMotor.class, "wormGear");
        viperslide = hardwareMap.get(DcMotor.class, "viperSlide");
        DistanceSensor = hardwareMap.get(DistanceSensor.class, "Distance Sensor");

//        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
//        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
//        backRight.setDirection(DcMotorSimple.Direction.FORWARD);

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.FORWARD);
        wormGearMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        viperslide.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {

            //Drive Forward: PRELOAD PHASE 1
            frontLeft.setPower(0.3);
            frontRight.setPower(0.3);
            backLeft.setPower(0.3);
            backRight.setPower(0.3);

            sleep(1300);

            //Intake Positioning: PRELOAD PHASE 2
//            wormGearMotor.setTargetPosition(0);
//            viperslide.setTargetPosition();


            //Strafe Right
//          frontLeft.setPower(0.5);
//          frontRight.setPower(-0.5);
//          backLeft.setPower(-0.5);
//          backRight.setPower(0.5);

            //Strafe left: PHASE 1
            frontLeft.setPower(-0.9);
            frontRight.setPower(0.9);
            backLeft.setPower(0.9);
            backRight.setPower(-0.9);

            sleep(1000);

            //STRAFE Right: 0.5 power for 1 second goes ~15in (~width of the bot itself)
            //STRAFE Left: 0.5 power for 1 second goes ~15in (~width of the bot itself)

//          //Drive Forward
//          frontLeft.setPower(0.5);
//          frontRight.setPower(0.5);
//          backLeft.setPower(0.6);
//          backRight.setPower(0.5);

            //Drive Backward: PHASE 2
            frontLeft.setPower(-0.5);
            frontRight.setPower(-0.5);
            backLeft.setPower(-0.62);
            backRight.setPower(-0.5);

            sleep(1500);

            //Strafe left: PHASE 3
            frontLeft.setPower(-0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(-0.5);

            sleep(750);

            //Drive left: 750ms goes 12"

            //Drive Forward: PHASE 4
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(0.5);

            sleep(1300);

            //DRIVE FORWARD: 0.5 power for 1.2 second goes 50in

            //ALL STOP
            frontLeft.setPower(0.0);
            frontRight.setPower(0.0);
            backLeft.setPower(0.0);
            backRight.setPower(0.0);

            sleep(1000);


            //Drive Backward: PHASE 5
            frontLeft.setPower(-0.5);
            frontRight.setPower(-0.5);
            backLeft.setPower(-0.4);
            backRight.setPower(-0.5);

            sleep(1500);

            //Strafe left: PHASE 6
            frontLeft.setPower(-0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.5);
            backRight.setPower(-0.5);

            sleep(650);

            //Drive Forward: PHASE 7
            frontLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backLeft.setPower(0.6);
            backRight.setPower(0.5);

            sleep(1200);

                //ALL STOP
                frontLeft.setPower(0.0);
                frontRight.setPower(0.0);
                backLeft.setPower(0.0);
                backRight.setPower(0.0);

                sleep(1000);

                //Drive Backward: PHASE 8
                frontLeft.setPower(-0.2);
                frontRight.setPower(-0.2);
                backLeft.setPower(-0.2);
                backRight.setPower(-0.2);

                sleep(500);

                //ALL STOP FOR TESTING
                frontLeft.setPower(0.0);
                frontRight.setPower(0.0);
                backLeft.setPower(0.0);
                backRight.setPower(0.0);

                sleep(1000);

                requestOpModeStop();

                //SET PARAMETERS FOR SPECIMEN COLLECTION

//
                //Strafe left: PHASE 9
//            frontLeft.setPower(-0.5);
//            frontRight.setPower(0.5);
//            backLeft.setPower(0.5);
//            backRight.setPower(-0.5);
//
//            sleep(500);
//
//            //Drive Forward: PHASE 10
//            frontLeft.setPower(0.5);
//            frontRight.setPower(0.6);
//            backLeft.setPower(0.4);
//            backRight.setPower(0.5);
//
//            sleep(900);

//            //ALL STOP
//            frontLeft.setPower(0.0);
//            frontRight.setPower(0.0);
//            backLeft.setPower(0.0);
//            backRight.setPower(0.0);
//
//            sleep(1000);
//


//          sleep(1000);

                //DRIVE FORWARD: 0.5 power for 1 second goes 32in
                //DRIVE BACKWARD: 0.5 power for 1 second goes 32in


//          //Strafe Right
//          frontLeft.setPower(0.1);
//          frontRight.setPower(-0.1);
//          backLeft.setPower(-0.1);
//          backRight.setPower(0.1);

//            //Strafe Left: PHASE 3
//            frontLeft.setPower(-0.1);
//            frontRight.setPower(0.1);
//            backLeft.setPower(0.1);
//            backRight.setPower(-0.1);
//
//            sleep(1200);

                //STRAFE RIGHT: 0.5 power for 1 second goes ~15in (~width of the bot itself)

////          //Drive Forward: PHASE 4
//            frontLeft.setPower(0.7);
//            frontRight.setPower(0.7);
//            backLeft.setPower(0.7);
//            backRight.setPower(0.7);
////
////            sleep(1000);

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