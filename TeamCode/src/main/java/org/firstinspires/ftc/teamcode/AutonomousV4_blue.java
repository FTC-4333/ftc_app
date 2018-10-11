package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/*intended path
    -drop color sensor arm
    -use color sensor to determine color of ball facing color sensor, and knock opposing team's color off by tilting
    -bring color sensor arm back up
    -if robot drives forwards to knock ball forwards, then ****
    */

@Autonomous(name="Autonomous V4 Blue", group="Pushbot")
//@Disabled
public class AutonomousV4_blue extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbotV4 robot = new HardwarePushbotV4();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    boolean forward;
    static final double     FORWARD_SPEED = 0.4;
    static final double     TURN_SPEED    = 0.36;

    @Override
    public void runOpMode() {

        //right and rear are reversed

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

        //drop color sensor arm
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            robot.dropArm.setPower(-0.3);
        }
        robot.dropArm.setPower(0);


        //revised autonomous that twists instead of drives in a direction, and compensates for holes in ball

        //if sensor gets no values, bot will do nothing
        if  (robot.colorSensor.blue() == 0 && robot.colorSensor.red() == 0)
        {
            robot.leftDriveMotor.setPower(0);
            robot.rightDriveMotor.setPower(0);
            robot.frontDriveMotor.setPower(0);
            robot.rearDriveMotor.setPower(0);
        }

        //if ball facing the sensor is red, robot twists forwards
        else if (robot.colorSensor.red() > robot.colorSensor.blue())
        {
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 0.6))
            {
                robot.rightDriveMotor.setPower(-1);
                robot.leftDriveMotor.setPower(1);
                robot.frontDriveMotor.setPower(-1);
                robot.rearDriveMotor.setPower(1);
            }
            robot.leftDriveMotor.setPower(0);
            robot.rightDriveMotor.setPower(0);
            robot.frontDriveMotor.setPower(0);
            robot.rearDriveMotor.setPower(0);
        }
        //if ball facing the color sensor is blue, the robot twists backwards
        else
        {
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() < 0.6)) {


                //get actual values for turning
                robot.rightDriveMotor.setPower(1);
                robot.leftDriveMotor.setPower(-1);
                robot.frontDriveMotor.setPower(1);
                robot.rearDriveMotor.setPower(-1);
            }
            robot.leftDriveMotor.setPower(0);
            robot.rightDriveMotor.setPower(0);
            robot.frontDriveMotor.setPower(0);
            robot.rearDriveMotor.setPower(0);
        }



        //raise dropArm back up
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.3)) {
            robot.dropArm.setPower(0.3);
        }
        robot.dropArm.setPower(0);


        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
