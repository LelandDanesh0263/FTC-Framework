package org.firstinspires.ftc.teamcode.autos.experimental;

/*
@Disabled
@Autonomous()
public class PixelSonarOnStacks extends LinearOpMode {
    MecanumController mecanumController;
    VisionSubsystem visionSubsystem;
    Servo claw;

    final double minimumPixelMass = 0.12;

    public void pixelSonar() {
        while (opModeIsActive() && !isStopRequested()) {
            if (visionSubsystem.getPixelMass() > minimumPixelMass) {
                mecanumController.driveParams(0, 0, 0);
                break;
            }
            mecanumController.driveParams(0, 0.2, 0);
        }
    }

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive sampleMecanumDrive = new SampleMecanumDrive(hardwareMap);
        mecanumController = new MecanumController(hardwareMap);
        visionSubsystem = new VisionSubsystem(hardwareMap, "pixel");
        claw = hardwareMap.get(Servo.class, "claw");

        sampleMecanumDrive.setPoseEstimate(new Pose2d(0, 0, 0));

        Trajectory backwards1 = sampleMecanumDrive.trajectoryBuilder(new Pose2d(0,0, 0))
                .back(30)
                .addSpatialMarker(new Vector2d(-10, 0), () -> {
                    claw.setPosition(Constants.CLAW_OPEN);
                })
                .build();

        Trajectory backwards2 = sampleMecanumDrive.trajectoryBuilder(new Pose2d(0, 0, 0))
                .back(3)
                .build();

        Trajectory forwards1 = sampleMecanumDrive.trajectoryBuilder(new Pose2d(0, 0, 0))
                .forward(2)
                .build();

        claw.setPosition(Constants.CLAW_CLOSE);

        while (opModeInInit()) {
            telemetry.addData("total mass", visionSubsystem.getPixelMass());
            telemetry.update();
        }

        waitForStart();

        sampleMecanumDrive.followTrajectory(backwards1);
        pixelSonar();
        sleep(500);
        claw.setPosition(Constants.CLAW_CLOSE);
        sleep(200);
        sampleMecanumDrive.setPoseEstimate(new Pose2d(0, 0, 0));
        sampleMecanumDrive.followTrajectory(backwards2);
    }
}
 */