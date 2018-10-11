package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="4333 TeleOp V4", group="Pushbot")

public class TeleOpV4 extends OpMode{

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
        double frontMotorPower;
        double rearMotorPower;
        double rightMotorPower;
        double leftMotorPower;


        //move forwards and backwards
        rightMotorPower=gamepad1.left_stick_y + gamepad1.right_stick_x;
        leftMotorPower=gamepad1.left_stick_y - gamepad1.right_stick_x;

        //move left and right
        frontMotorPower=gamepad1.left_stick_x - gamepad1.right_stick_x;
        rearMotorPower=gamepad1.left_stick_x + gamepad1.right_stick_x;

        //arm
        robot.rightArmMotor.setPower(0.4 * gamepad2.right_stick_y);
        robot.leftArmMotor.setPower(0.4 * gamepad2.right_stick_y);


        //claws
        //open & close claws
        if (gamepad2.right_bumper)
            clawOffset += CLAW_SPEED;
        else if (gamepad2.left_bumper)
            clawOffset -= CLAW_SPEED;

        clawOffset = Range.clip(clawOffset, -0.5, 0.5);
        robot.leftClaw.setPosition(robot.MID_SERVO + clawOffset);
        robot.rightClaw.setPosition(robot.MID_SERVO - clawOffset);

        //raise and lower drop arm using X and B buttons
        if (gamepad1.x)
        {
            robot.dropArm.setPower(.45);
        }

        else if(gamepad1.b)
        {
            robot.dropArm.setPower(-.45);
        }

        else
            {
            robot.dropArm.setPower(0);
            }


        //establishes motor power variables
        robot.frontDriveMotor.setPower(frontMotorPower);
        robot.rearDriveMotor.setPower(rearMotorPower);
        robot.rightDriveMotor.setPower(rightMotorPower);
        robot.leftDriveMotor.setPower(leftMotorPower);

        /*
        telemetry.addData("Blue", robot.colorSensor.blue() );
        telemetry.addData("Red", robot.colorSensor.red() );
        */
    }

    @Override
    public void stop() {
    }

}
