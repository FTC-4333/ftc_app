package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="4333 Succ TeleOp", group="Pushbot")

public class TeleOpSucc extends OpMode{



    /* Declare OpMode members. */
    HardwarePushbotSucc robot   = new HardwarePushbotSucc(); // use the class created to define a Pushbot's hardware
    double          clawOffset    = 0.0 ;                  // Servo mid position
    final double    CLAW_SPEED    = 0.02 ;
    //double endTime    = 0;
    double leftendTime  = 0;
    double rightendTime = 0;
    double endTime180   = 0;
    boolean turnRight   = false;
    boolean turnLeft    = false;
    boolean turn180     = false;

    private ElapsedTime runtime = new ElapsedTime();

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init()
    {
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


        //using tank drive with button functions for dump arm and stopping succ motors

        //tank drive using left and right analog stick y values on gamepad1
        robot.rightDriveMotor.setPower(gamepad1.left_stick_y);
        robot.leftDriveMotor.setPower(gamepad1.right_stick_y);


        //robot.dumpArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      /*

      //This should allow the dump mechanism to be toggled with the a button

       boolean dumpDown = TRUE; //true if the dump mechanism is in the down, or horizontal position
        if (gamepad2.a && dumpDown == FALSE)
            robot.dumpArm.setTargetPosition(0);
             dumpDown = TRUE;

        }

        if (gamepad2.a && dumpDown == TRUE) {
            robot.dumpArm.setTargetPosition(1050);
             dumpDown = FALSE

        }
        */

       /*

       //This should allow the driver to use the y button to toggle the suck motors on and off so
       //they do not have to be on for the entire game.

       boolean suckOn = FALSE;
        if (gamepad2.y && suckOn == FALSE) {
            robot.leftSuccMotor.setPower(1);
            robot.rightSuccMotor.setPower(1);
            suckon = TRUE;

        }

        if (gamepad2.y && suckOn == TRUE) {
            robot.leftSuccMotor.setPower(0);
            robot.rightSuccMotor.setPower(0);
            suckon = FALSE;

        }
        */

        //succ motors always on
        robot.rightSuccMotor.setPower(-1);
        robot.leftSuccMotor.setPower(1);

        //dump arm toggle using analog stick on gamepad2
        robot.dumpArm.setPower(gamepad2.right_stick_y);

    }

    @Override
    public void stop() {
    }

}
