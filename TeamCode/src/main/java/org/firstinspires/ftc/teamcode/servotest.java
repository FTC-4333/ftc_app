package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="4333 servotest", group="Pushbot")

public class servotest extends OpMode{

    /* Declare OpMode members. */
    HardwarePushbotV4 robot       = new HardwarePushbotV4(); // use the class created to define a Pushbot's hardware

    double          clawOffset  = 0.0 ;                  // Servo mid position
    final double    CLAW_SPEED  = 0.04 ;
    //double endTime = 0;
    double leftendTime = 0;
    double rightendTime = 0;
    double endTime180 = 0;
    boolean turnRight = false;
    boolean turnLeft = false;
    boolean turn180 = false;

    private ElapsedTime runtime = new ElapsedTime();

    // sets rate to move servo
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
        telemetry.addData("Say", "Hello Driver");    //
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
    public void loop() {
        //variables
        //claws
        //open & close claws
        if (gamepad1.a)
            clawOffset += CLAW_SPEED;
        else if (gamepad1.b)
            clawOffset -= CLAW_SPEED;

        clawOffset = Range.clip(clawOffset, -0.5, 0.5);
        robot.servotest.setPosition(robot.MID_SERVO + clawOffset);



        /*
        telemetry.addData("Blue", robot.colorSensor.blue() );
        telemetry.addData("Red", robot.colorSensor.red() );
        */
    }

    @Override
    public void stop() {
    }

}
