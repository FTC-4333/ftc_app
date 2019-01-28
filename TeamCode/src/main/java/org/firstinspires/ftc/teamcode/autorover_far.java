/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="autorover_far", group="Autonomous")
public class autorover_far extends LinearOpMode
{

    /* Declare OpMode members. */
    Hardware         robot   = new Hardware();
    private ElapsedTime     runtime = new ElapsedTime();

    static final double     FORWARD = 0.5;
    static final double     REVERSE = -0.5;

    @Override
    public void runOpMode()
    {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        //Step 1: Lower lifter
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 5.0))
        {
            robot.l.setPower(FORWARD);
        }
        robot.l.setPower(0);

        //drive forwards slightly
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0))
        {
            robot.leftFrontWheel.setPower(FORWARD);
            robot.leftBackWheel.setPower(FORWARD);
            robot.rightFrontWheel.setPower(FORWARD);
            robot.rightBackWheel.setPower(FORWARD);
        }
        robot.leftFrontWheel.setPower(0);
        robot.leftBackWheel.setPower(0);
        robot.rightFrontWheel.setPower(0);
        robot.rightBackWheel.setPower(0);

        //rotate right to face crater
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 2.0))
        {
            robot.leftFrontWheel.setPower(FORWARD);
            robot.leftBackWheel.setPower(FORWARD);
            robot.rightFrontWheel.setPower(REVERSE);
            robot.rightBackWheel.setPower(REVERSE);
        }
        robot.leftFrontWheel.setPower(0);
        robot.leftBackWheel.setPower(0);
        robot.rightFrontWheel.setPower(0);
        robot.rightBackWheel.setPower(0);

        //drive forwards into crater
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 4.0))
        {
            robot.leftFrontWheel.setPower(FORWARD);
            robot.leftBackWheel.setPower(FORWARD);
            robot.rightFrontWheel.setPower(FORWARD);
            robot.rightBackWheel.setPower(FORWARD);
        }
        robot.leftFrontWheel.setPower(0);
        robot.leftBackWheel.setPower(0);
        robot.rightFrontWheel.setPower(0);
        robot.rightBackWheel.setPower(0);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}