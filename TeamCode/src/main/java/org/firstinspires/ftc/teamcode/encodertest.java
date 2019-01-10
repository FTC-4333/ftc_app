package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="encodertest", group="Autonomous")
public class encodertest extends LinearOpMode
{

    /* Declare OpMode members. */
    Hardware         robot   = new Hardware();
    private ElapsedTime     runtime = new ElapsedTime();

    static final double     FORWARD = 0.5;
    static final double     REVERSE = -0.5;

    @Override
    public void runOpMode()
    {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);



        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 5.0))
        {
            robot.leftFrontWheel.setPower(-1);
            robot.leftBackWheel.setPower(-1);
            robot.rightFrontWheel.setPower(1);
            robot.rightBackWheel.setPower(-1);
        }
        robot.leftFrontWheel.setPower(0);
        robot.leftBackWheel.setPower(0);
        robot.rightFrontWheel.setPower(0);
        robot.rightBackWheel.setPower(0);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
