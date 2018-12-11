package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="4333 test2", group="test")

public class test2 extends OpMode{

    /* Declare OpMode members. */
    HardwareTest robot = new HardwareTest();

    double          clawOffset  = 0.0 ;                  // Servo mid position
    final double    CLAW_SPEED  = 0.04 ;

    double leftendTime = 0;
    double rightendTime = 0;
    double endTime180 = 0;
    boolean turnRight = false;
    boolean turnLeft = false;
    boolean turn180 = false;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
     //   telemetry.addData("READY TO RUN");    //
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop()
    {
    }
    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start()
    {
    }
    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop()
    {


        //code starts here
        if (gamepad1.a)
        {
            robot.testMotor.setPower(0.5);
        }
        robot.testMotor.setPower(0);

        if (gamepad1.x)
            clawOffset += CLAW_SPEED;
        else if (gamepad2.left_bumper)
            clawOffset -= CLAW_SPEED;

        clawOffset = Range.clip(clawOffset, -0.5, 0.5);
        robot.testServo.setPosition(robot.MID_SERVO + clawOffset);






























    }
    @Override
    public void stop()
    {
    }

}
