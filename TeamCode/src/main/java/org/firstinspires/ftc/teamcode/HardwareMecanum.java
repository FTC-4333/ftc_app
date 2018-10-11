package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareMecanum
{

    //establish hardware
  //public DcMotor frontRight = null;
  //public DcMotor frontLeft  = null;
  //public DcMotor rearRight  = null;
 // public DcMotor rearLeft   = null;
  public DcMotor testMotor  = null;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwareMecanum()
    {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        int temp = 0;


        // Define and Initialize Motors
       // frontRight = hwMap.dcMotor.get("front_right");
       // frontLeft  = hwMap.dcMotor.get("front_left");
     //   rearRight  = hwMap.dcMotor.get("rear_right");
      //  rearLeft   = hwMap.dcMotor.get("rear_left");
        testMotor  = hwMap.dcMotor.get("test_motor");

        // Set all motors & servos to zero power
      //  frontRight.setPower(0);
      //  frontLeft.setPower(0) ;
      //  rearRight.setPower(0) ;
     //   rearLeft.setPower(0)  ;
        testMotor.setPower(0) ;


        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.


    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */
    public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}
