package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwarePushbotSucc
{

    public DcMotor  rightDriveMotor  = null;
    public DcMotor  leftDriveMotor   = null;
    public DcMotor  dumpArm          = null;
    public DcMotor  leftSuccMotor    = null;
    public DcMotor  rightSuccMotor   = null;


    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwarePushbotSucc()
    {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap)
    {
        // Save reference to Hardware map
        hwMap = ahwMap;
        int temp = 0;


        // Define and Initialize Motors
        rightDriveMotor = hwMap.dcMotor.get("right_drive");
        leftDriveMotor  = hwMap.dcMotor.get("left_drive");
        dumpArm         = hwMap.dcMotor.get("dump_arm");
        leftSuccMotor   = hwMap.dcMotor.get("left_succ");
        rightSuccMotor  = hwMap.dcMotor.get("right_succ");


        //reverse certain motors
      //  rightDriveMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
       // rearDriveMotor.setDirection(DcMotor.Direction.REVERSE);
      //  rightArmMotor.setDirection(DcMotor.Direction.REVERSE);


        // Set all motors to zero power
        rightDriveMotor.setPower(0);
        leftDriveMotor.setPower(0);
        dumpArm.setPower(0);
        rightSuccMotor.setPower(0);
        leftSuccMotor.setPower(0);


        // Set all motors to run without encoders.
        // use 'RUN_USING_ENCODERS' if you want to use them
        rightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dumpArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightSuccMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftSuccMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }



    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */

    public void waitForTick(long periodMs)
    {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
        {
            try
            {
                Thread.sleep(remaining);
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}