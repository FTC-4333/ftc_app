package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor        ;
import com.qualcomm.robotcore.hardware.DcMotorSimple  ;
import com.qualcomm.robotcore.hardware.Servo          ;
import java.util.Arrays;

@Autonomous(name="autorover_v1", group="Autonomous")
public class autorover_v1 extends Autonomous
{
    private static final double SCALEDPOWER = 1;

    private static DcMotor leftFrontWheel, leftBackWheel, rightFrontWheel, rightBackWheel, arm0, arm1, lifter;
    private static Servo leftCollector, rightCollector;
}