package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

//--------------------------------------------------------------------------------------------------

@Autonomous(name="autorover_crater", group="Autonomous")
public class autorover_crater extends LinearOpMode
{
    DcMotor l1;
    DcMotor l2;
    DcMotor r1;
    DcMotor r2;
    DcMotor l;

    ColorSensor c;

//--------------------------------------------------------------------------------------------------

    @Override
    public void runOpMode() throws InterruptedException
    {
        l1 = hardwareMap.dcMotor.get("l1");
        l2 = hardwareMap.dcMotor.get("l2");
        r1 = hardwareMap.dcMotor.get("r1");
        r2 = hardwareMap.dcMotor.get("r2");

        l2.setDirection(DcMotor.Direction.REVERSE);

        l = hardwareMap.dcMotor.get("l");

        c = hardwareMap.colorSensor.get("c");

//--------------------------------------------------------------------------------------------------

        waitForStart();

        //descend from lander for 7 seconds
        l.setPower(0.7);

        sleep(7000);

        l.setPower(0);

        forward(1);

        //strafe right for 0.1 seconds to clear hook from lander
        strafe_right(1);
        sleep(100);

        //drive to center mineral


        //if center mineral is gold, drive forwards to push it
        if  (c.red() >= c.green() && c.blue() < 400)
        {
            l1.setPower(1);
            l2.setPower(1);
            r1.setPower(1);
            r2.setPower(1);

            sleep(500);

            l1.setPower(0);
            l2.setPower(0);
            r1.setPower(0);
            r2.setPower(0);
        }

        //if center mineral is not gold, strafe right to rightmost mineral
        else
        {
            l1.setPower(1);
            l2.setPower(-1);
            r1.setPower(-1);
            r2.setPower(1);
        }

//--------------------------------------------------------------------------------------------------

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
    public void backwards (double power)
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
    public void lift_up (double power)
    {
        l.setPower(power);
    }

    //lifter down method
    public void lifter_down (double power)
    {
        l.setPower(-power);
    }

//--------------------------------------------------------------------------------------------------

}