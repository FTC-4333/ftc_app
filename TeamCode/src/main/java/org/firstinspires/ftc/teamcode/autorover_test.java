package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//--------------------------------------------------------------------------------------------------

@Autonomous(name="autorover_test", group="Autonomous")
public class autorover_test extends LinearOpMode
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

        l1.setDirection(DcMotor.Direction.REVERSE);
        l2.setDirection(DcMotor.Direction.REVERSE);
        r1.setDirection(DcMotor.Direction.REVERSE);
        r2.setDirection(DcMotor.Direction.REVERSE);

        sleep(3000);

        forward(1);
        sleep(1500);
        forward(0);

        sleep(2000);

        backward(1);
        sleep(1500);
        backward(0);

        sleep(2000);

        strafe_right(1);
        sleep(1500);
        strafe_right(0);

        sleep(2000);

        strafe_left(1);
        sleep(1500);
        strafe_left(0);

        sleep(10000);
        
        if  (c.red() >= c.green() && c.blue() < 400)
        {
            forward(1);
            sleep(200);
            forward(0);
        }

        else
        {
            strafe_right(1);
            sleep(400);
            strafe_right(0);
        }

        //sleep for 2 seconds to get color reading
        sleep(2000);

        //if rightmost mineral is gold, drive forwards to push it
        if  (c.red() >= c.green() && c.blue() < 400)
        {
            forward(1);
            sleep(200);
            forward(0);
        }

        //if rightmost mineral is not gold, strafe left to leftmost mineral, and push it since we know that it is gold
        else
        {
            strafe_right(1);
            sleep(800);
            strafe_right(0);

            sleep(1000);

            forward(1);
            sleep(200);
            forward(0);
        }
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