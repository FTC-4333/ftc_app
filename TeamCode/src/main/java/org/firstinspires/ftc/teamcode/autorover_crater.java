package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//--------------------------------------------------------------------------------------------------

@Autonomous(name="autorover_crater", group="Autonomous")
public class autorover_crater extends LinearOpMode
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

      //lc = hardwareMap.Servo.get("lc");
      //rc = hardwareMap.Servo.get("rc");

        r1.setDirection(DcMotor.Direction.REVERSE);

        l = hardwareMap.dcMotor.get("l");

        c = hardwareMap.colorSensor.get("c");

//--------------------------------------------------------------------------------------------------

        waitForStart();

        //path
        //descend from lander
        //unhook
        //drive forwards to center mineral for sampling
        //get color reading
        //if center mineral is gold, push
        //if center mineral is not gold, strafe right to rightmost mineral
        //get color reading
        //if rightmost mineral is gold, push
        //if rightmost mineral is not gold, strafe left to leftmost mineral
        //push because we know that it is gold
        //drive into crater
        //lift arm out of center of bot

        //descend from lander for 7 seconds
        lifter_down(1);
        sleep(7000);
        lifter_down(0);

        //strafe right for 0.1 seconds to clear hook from lander
        strafe_right(1);
        sleep(100);
        strafe_right(0);

        //drive to forward 0.7 seconds to center mineral
        forward(1);
        sleep(700);
        forward(0);

        //sleep for 1.5 seconds to get color reading
        sleep(1500);

        //if center mineral is gold, drive forwards to push it
        if  (c.red() >= c.green() && c.blue() < 400)
        {
            forward(1);
            sleep(200);
            forward(0);
        }

        //if center mineral is not gold, strafe right to rightmost mineral
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

//--------------------------------------------------------------------------------------------------

        //set all motors to 0 power when path is done
        l1.setPower(0);
        l2.setPower(0);
        r1.setPower(0);
        r2.setPower(0);
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
        r1.setPower(power);
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
    public void arm_release (double power)
    {
    //    a1.setPower(0.7);
    //    a2.setPower(0.7);
    }
//--------------------------------------------------------------------------------------------------

}