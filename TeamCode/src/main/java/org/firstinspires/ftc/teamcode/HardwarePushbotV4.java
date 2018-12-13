package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.hardware.ColorSensor;

public class HardwarePushbotV4 {

    //color sensor code
   // public ColorSensor colorSensor  = null;

//    public DcMotor  dropArm         = null;
//   public DcMotor  leftDriveMotor  = null;
//    public DcMotor  rightDriveMotor = null;
//    public DcMotor  frontDriveMotor = null;
//    public DcMotor  rearDriveMotor  = null;

 //   public Servo leftClaw  = null;
  //  public Servo rightClaw = null;
    public Servo servotest = null;

 //   public DcMotor rightArmMotor = null;
 //   public DcMotor  leftArmMotor = null;

    //servos
    public static final double MID_SERVO  = 0.5;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwarePushbotV4(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        int temp = 0;

        //color sensor
      //  colorSensor = hwMap.colorSensor.get("color_sensor");

        // Define and Initialize Motors
      //  leftDriveMotor     = hwMap.dcMotor.get("left_drive");
       // rightDriveMotor    = hwMap.dcMotor.get("right_drive");
        //frontDriveMotor    = hwMap.dcMotor.get("front_drive");
        //rearDriveMotor     = hwMap.dcMotor.get("rear_drive");
        //dropArm            = hwMap.dcMotor.get("drop_arm");
        //rightArmMotor      = hwMap.dcMotor.get("right_arm");
        //leftArmMotor       = hwMap.dcMotor.get("left_arm") ;

        //initialize servos
        //rightClaw = hwMap.servo.get("right_claw");
        //rightClaw.setPosition(MID_SERVO);
        //leftClaw = hwMap.servo.get("left_claw");
        //leftClaw.setPosition(MID_SERVO);

        //test servo
        servotest = hwMap.servo.get("servo_test");
        servotest.setPosition(MID_SERVO);




        //reverse certain motors
      //  rightDriveMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
      //  rearDriveMotor.setDirection(DcMotor.Direction.REVERSE);
      //  rightArmMotor.setDirection(DcMotor.Direction.REVERSE);


        // Set all motors & servos to zero power
    //    leftDriveMotor.setPower(0);
     //   rightDriveMotor.setPower(0);
     //   frontDriveMotor.setPower(0);
     //   rearDriveMotor.setPower(0);
    //    dropArm.setPower(0);
     //   rightArmMotor.setPower(0);
       // leftArmMotor.setPower(0);


        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
       // leftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    //    rightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //frontDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       // rearDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //dropArm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //rightArmMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



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

