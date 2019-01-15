/*
ADB guide can be found at:
https://ftcprogramming.wordpress.com/2015/11/30/building-ftc_app-wirelessly/
*/
package org.firstinspires.ftc.teamcode                ;
import com.qualcomm.robotcore.eventloop.opmode.OpMode ;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.hardware.DcMotorSimple  ;
import com.qualcomm.robotcore.hardware.Servo          ;
import java.util.Arrays;
import com.qualcomm.robotcore.hardware.ColorSensor;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="rover_v2", group="TeleOp")
public class rover_v2 extends OpMode
{
    private static final double TRIGGERTHRESHOLD = .2     ;
    private static final double ACCEPTINPUTTHRESHOLD = .15;
    private static final double SCALEDPOWER = 1; //Emphasis on current controller reading (vs current motor power) on the drive train

    private static DcMotor leftFrontWheel, leftBackWheel, rightFrontWheel, rightBackWheel, arm0, arm1, l;
    private static Servo leftCollector, rightCollector;

    @Override
    public void init()
    //this is where the lines for init-ing and reversing goes
    {
        leftFrontWheel  = hardwareMap.dcMotor.get(UniversalConstants.LEFT1NAME) ;
        leftBackWheel   = hardwareMap.dcMotor.get(UniversalConstants.LEFT2NAME) ;
        rightFrontWheel = hardwareMap.dcMotor.get(UniversalConstants.RIGHT1NAME);
        rightBackWheel  = hardwareMap.dcMotor.get(UniversalConstants.RIGHT2NAME);

       // arm0   = hardwareMap.dcMotor.get(UniversalConstants.ARM0);
       // arm1   = hardwareMap.dcMotor.get(UniversalConstants.ARM1);
        l = hardwareMap.dcMotor.get(UniversalConstants.LIFTER);
     //   c = hardwareMap.colorSensor.get(UniversalConstants.COLORSENSOR);

       // leftCollector  = hardwareMap.servo.get(UniversalConstants.LEFTCOLLECTOR) ;
       // rightCollector = hardwareMap.servo.get(UniversalConstants.RIGHTCOLLECTOR);

        //reverse all but rightFrontWheel, because of the way that the REV motors are oriented
        leftFrontWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackWheel.setDirection(DcMotorSimple.Direction.REVERSE) ;
        rightBackWheel.setDirection(DcMotorSimple.Direction.REVERSE);
        //rightFrontWheel.setDirection(DcMotorSimple.Direction.REVERSE);

        double volts = hardwareMap.voltageSensor.get("Expansion Hub 1").getVoltage();
    }

    @Override

    public void loop()
    //this is where the code for moving things goes
    {
        //use A button and B button to control the intake servos
        //A sucks, B spits
        //servos accept values from 0 to 1, 0.5 makes the servo "stop"
        /*if (gamepad2.a)
        {
            //this makes the intake servos "suck" when a button is presses
            leftCollector.setPosition(1);
            rightCollector.setPosition(-1);
        }
        else if (gamepad2.b)
        {
            //this makes the intake servos "spit" when b button is pressed
            leftCollector.setPosition(-1);
            rightCollector.setPosition(1);
        }

        else
        {
            //this "stops" the servos, but they actually drift a bit
            leftCollector.setPosition(0.5);
            rightCollector.setPosition(0.5);
        }
        */
        if (gamepad1.y)
        {
            l.setPower(-1);
        }


        if (gamepad1.a)
        {
            l.setPower(1);
        }

        if (gamepad1.b)
        {
            l.setPower(0);
        }

      //  telemetry.addData("Red",  colorSensor.red() );
      //  telemetry.addData("Blue", colorSensor.blue() );
      //  telemetry.addData("Blue", colorSensor.green() );


        //control arm using left and right stick y values
        //left stick controls arm0, the "shoulder" or bottom part
        //right stick controls arm1, the "forearm" or top part
       // arm0.setPower(gamepad2.left_stick_y);
       // arm1.setPower(gamepad2.right_stick_y);

        //moves mecanum wheel motors based on absolute values from the sticks that take into account rotation
        //strafing works
        double inputY = Math.abs(gamepad1.left_stick_y) > ACCEPTINPUTTHRESHOLD ? gamepad1.left_stick_y : 0 ;
        double inputX = Math.abs(gamepad1.left_stick_x) > ACCEPTINPUTTHRESHOLD ? -gamepad1.left_stick_x : 0;
        double inputC = Math.abs(gamepad1.right_stick_x)> ACCEPTINPUTTHRESHOLD ? -gamepad1.right_stick_x: 0;

        arcadeMecanum(inputY, inputX, inputC, leftFrontWheel, rightFrontWheel, leftBackWheel, rightBackWheel);
    }

    // y - forwards
    // x - side
    // c - rotation
    public static void arcadeMecanum(double y, double x, double c, DcMotor leftFront, DcMotor rightFront, DcMotor leftBack, DcMotor rightBack)
    {
        double leftFrontVal  = y + x + c;       /*r2*/
        double rightFrontVal = y - x - c;       /*r1*/
        double leftBackVal   = y - x + c;       /*l2*/
        double rightBackVal  = y + x - c;       /*l1*/

        //Move range to between 0 and +1, if not already
        double[] wheelPowers = {rightFrontVal, leftFrontVal, leftBackVal, rightBackVal};
        Arrays.sort(wheelPowers);
        if (wheelPowers[3] > 1)
        {
            leftFrontVal  /= wheelPowers[3];
            rightFrontVal /= wheelPowers[3];
            leftBackVal   /= wheelPowers[3];
            rightBackVal  /= wheelPowers[3];
        }

        double scaledPower = SCALEDPOWER;

        leftFront.setPower(leftFrontVal*scaledPower+leftFront.getPower()*(1-scaledPower))    ;
        rightFront.setPower(rightFrontVal*scaledPower+rightFront.getPower()*(1-scaledPower)) ;
        leftBack.setPower(leftBackVal*scaledPower+leftBack.getPower()*(1-scaledPower))       ;
        rightBack.setPower(rightBackVal*scaledPower+rightBack.getPower()*(1-scaledPower))    ;
    }
}
