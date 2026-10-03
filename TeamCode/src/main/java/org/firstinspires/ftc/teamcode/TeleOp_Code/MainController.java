package org.firstinspires.ftc.teamcode.TeleOp_Code;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcontroller.external.samples.ConceptTelemetry;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.TeleOp_Code.MecanumDriveTeleOp;

@TeleOp
public class MainController extends LinearOpMode {

    public DcMotorEx frontLeftMotor;
    public DcMotorEx backLeftMotor;
    public DcMotorEx frontRightMotor;
    public DcMotorEx backRightMotor;



    @Override
    public void runOpMode() throws InterruptedException {
        frontLeftMotor = (DcMotorEx) hardwareMap.dcMotor.get("frontLeftMotor");
        backLeftMotor = (DcMotorEx) hardwareMap.dcMotor.get("backLeftMotor");
        frontRightMotor = (DcMotorEx) hardwareMap.dcMotor.get("frontRightMotor");
        backRightMotor = (DcMotorEx) hardwareMap.dcMotor.get("backRightMotor");

        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        MecanumDriveTeleOp mecanumDriveTeleOp = new MecanumDriveTeleOp(backLeftMotor, frontLeftMotor, backRightMotor, frontRightMotor);


                waitForStart();

        while (opModeIsActive()) {

            mecanumDriveTeleOp.controllerInputs((double) gamepad1.left_stick_y, (double) gamepad1.left_stick_x, (double) gamepad1.right_stick_x);


             telemetry.addData("Front Right Velocity", frontRightMotor.getVelocity());
             telemetry.addData("Back Right Velocity", backRightMotor.getVelocity());
             telemetry.addData("Front Left Velocity", frontLeftMotor.getVelocity());
             telemetry.addData("Back Left Velocity", backLeftMotor.getVelocity());;
             telemetry.update();





        }
    }


}

