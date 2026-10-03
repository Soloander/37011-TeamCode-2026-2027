package org.firstinspires.ftc.teamcode.TeleOp_Code;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class MecanumDriveTeleOp {

    public DcMotorEx LeftbackMotor;
    public DcMotorEx LeftfrontMotor;

    public DcMotorEx RightfrontMotor;

    public DcMotorEx RightbackMotor;

    public double COUNTS_PER_MOTOR_REV = 537.7;

    public double DRIVE_GEAR_REDUCTION = 19.2;

    public double WHEEL_CIRCUMFERENCE_MM = 104*Math.PI;


    public double TPS = (300/60) * COUNTS_PER_MOTOR_REV;

    public MecanumDriveTeleOp(DcMotorEx bL, DcMotorEx fL, DcMotorEx bR, DcMotorEx fR){
        LeftbackMotor = bL;
        LeftfrontMotor = fL;
        RightfrontMotor = fR;
        RightbackMotor = bR;
    }



    public void controllerInputs(Double yDrive, Double xDrive, Double rxDrive) {
        double y = -yDrive;
        double x = xDrive;
        double rx = rxDrive;
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

        double leftFrontPower = (y+x+rx) / denominator;
        double leftBackPower = (y-x+rx) / denominator;
        double rightFrontPower = (y-x-rx) / denominator;
        double rightBackPower = (y+x-rx) / denominator;





        LeftfrontMotor.setVelocity(leftFrontPower*TPS);
        LeftbackMotor.setVelocity(leftBackPower*TPS);
        RightfrontMotor.setVelocity(rightFrontPower*TPS);
        RightbackMotor.setVelocity(rightBackPower*TPS);

// RPM 312/60, Encoder Resolution, Gear Reduction 19.2, Wheel Diameter 104mm*3.14


    }



}
