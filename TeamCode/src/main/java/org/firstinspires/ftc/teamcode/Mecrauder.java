package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode  ;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp  ;



@TeleOp(name="4333 Mecrauder", group="Mecanum")

public class Mecrauder extends OpMode{

    /* Declare OpMode members. */
    HardwareMecanum robot = new HardwareMecanum();

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
    public void loop()
    {

      //variables
      double frontRight;
      double frontLeft ;
      double rearRight ;
      double rearLeft  ;

      //use right trigger give amount of power to motors
      //use left stick to set x and y position that moves all 4 mecanum accordingly
      //use right stick to rotate



































    }
    @Override
    public void stop()
    {
    }

}
