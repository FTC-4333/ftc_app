/*
ADB guide can be found at:
https://ftcprogramming.wordpress.com/2015/11/30/building-ftc_app-wirelessly/
*/
package org.firstinspires.ftc.teamcode                ;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode ;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.hardware.DcMotorSimple  ;
import com.qualcomm.robotcore.hardware.Servo          ;
import java.util.Arrays;

@Autonomous(name="autorover_v1", group="Autonomous")
public class autorover_v1 extends OpMode
{
    private static DcMotor leftFrontWheel, leftBackWheel, rightFrontWheel, rightBackWheel, arm0, arm1, lifter;
    private static Servo leftCollector, rightCollector;

    @Override
    public void init()
    //this is where the code for init-ing and reversing goes
    {
        leftFrontWheel  = hardwareMap.dcMotor.get(UniversalConstants.LEFT1NAME) ;
        leftBackWheel   = hardwareMap.dcMotor.get(UniversalConstants.LEFT2NAME) ;
        rightFrontWheel = hardwareMap.dcMotor.get(UniversalConstants.RIGHT1NAME);
        rightBackWheel  = hardwareMap.dcMotor.get(UniversalConstants.RIGHT2NAME);

        arm0   = hardwareMap.dcMotor.get(UniversalConstants.ARM0);
        arm1   = hardwareMap.dcMotor.get(UniversalConstants.ARM1);
        //lifter = hardwareMap.dcMotor.get(UniversalConstants.LIFTER);

        leftCollector  = hardwareMap.servo.get(UniversalConstants.LEFTCOLLECTOR) ;
        rightCollector = hardwareMap.servo.get(UniversalConstants.RIGHTCOLLECTOR);

        //reverse all but rightFrontWheel, because of the way that the REV motors are oriented
        leftFrontWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackWheel.setDirection(DcMotorSimple.Direction.REVERSE) ;
        rightBackWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        //rightFrontWheel.setDirection(DcMotorSimple.Direction.REVERSE);

        double volts = hardwareMap.voltageSensor.get("Expansion Hub 2").getVoltage();
    }

    @Override

    public void loop()
    //this is where the code for moving things goes
    {






        
    }
}
