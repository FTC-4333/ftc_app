package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//--------------------------------------------------------------------------------------------------

@Autonomous(name="autorover_test3", group="Autonomous")
public class autorover_test3 extends LinearOpMode
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

        l.setPower(1);
        sleep(3000);
        l.setPower(0);

        sleep(3000);

        l.setPower(-1);
        sleep(3000);
        l.setPower(0);

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