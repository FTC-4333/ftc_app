package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//--------------------------------------------------------------------------------------------------

@Autonomous(name="autorover_test2", group="Autonomous")
public class autorover_test2 extends LinearOpMode
{
    //l1 = left front wheel
    //l2 = left back wheel
    //r1 = right front wheel
    //r2 = right back wheel
    //l = left front wheel
    //a1 = lower arm motor
    //a2 = upper arm motor
    //lc = left collector
    //rc = right collector

    DcMotor l1;
    DcMotor l2;
    DcMotor r1;
    DcMotor r2;

    DcMotor l;

    // DcMotor a1;
    // DcMotor a2;

    // Servo lc;
    // Servo rc;

    ColorSensor c;

    static final double     COUNTS_PER_MOTOR_REV    = 288 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 2.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 6.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.6;
    static final double     TURN_SPEED              = 0.5;

//--------------------------------------------------------------------------------------------------

    @Override
    public void runOpMode() throws InterruptedException
    {
        l1 = hardwareMap.dcMotor.get("l1");
        l2 = hardwareMap.dcMotor.get("l2");
        r1 = hardwareMap.dcMotor.get("r1");
        r2 = hardwareMap.dcMotor.get("r2");

        l = hardwareMap.dcMotor.get("l");

        //lc = hardwareMap.servo.get("lc");
        //rc = hardwareMap.servo.get("rc");

        c = hardwareMap.colorSensor.get("c");

//--------------------------------------------------------------------------------------------------

        waitForStart();


    }
//--------------------------------------------------------------------------------------------------
    //methods

    //drive forwards method
    public void forward (double power)
    {
        l1.setPower(power);
        l2.setPower(power);
        r1.setPower(power);
        r2.setPower(power);
    }

    //drive backwards method
    public void backward (double power)
    {
        l1.setPower(-power);
        l2.setPower(-power);
        r1.setPower(-power);
        r2.setPower(-power);
    }

    //strafe right method
    public void strafe_right (double power)
    {
        l1.setPower(power);
        l2.setPower(-power);
        r1.setPower(-power);
        r2.setPower(power);
    }

    //strafe left method
    public void strafe_left (double power)
    {
        l1.setPower(-power);
        l2.setPower(power);
        r1.setPower(power);
        r2.setPower(-power);
    }

    //lifter up method
    public void lifter_up (double power)
    {
        l.setPower(power);
    }

    //lifter down method
    public void lifter_down (double power)
    {
        l.setPower(-power);
    }

    //arm

//--------------------------------------------------------------------------------------------------

}