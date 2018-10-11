package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode  ;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp  ;



@TeleOp(name="4333 test", group="Mecanum")

public class test extends OpMode{

    /* Declare OpMode members. */
    HardwareMecanum robot = new HardwareMecanum();

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
        telemetry.addData("READY TO RUN");    //
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
        //your code here
        if (gamepad1.a)
        {
            testMotorPower = 1
        }




        //establishes motor power variables
        robot.testMotor.setPower(testMotorPower);


































    }
    @Override
    public void stop()
    {
    }

}
