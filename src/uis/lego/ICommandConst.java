package uis.lego;

public interface ICommandConst {
        final int COMMAND_BATTERY_VOLTAGE = 0;
        final int COMMAND_TRAVEL = 1;
        final int COMMAND_TURN = 2;
        final int COMMAND_READ_COLOR = 3;
        final int COMMAND_DISCONNECT = 4;
        final int COMMAND_SWEEP = 5;
        final int COMMAND_READ_VALUE = 6;
}

/*
Description:  The user requests the battery voltage
Command          0, 0, 0
Reply   millivoltage, 0, 0, 0, 0, 0, 0, 0


Description:  The user asks for the ultrasonic sensor to ping and report back
Command          1,0,0
Reply   A series of 8 integers being the echo values


Description:  The user requests that the robot move forward/backward
Command          2,distance,speed
Reply     A series of 8 integers being the echo values


Description  The user requests that the robot turn left/right
Command          3,angle,speed
Reply   A series of 8 integers being the echo values


Description  The user requests that the Bluetooth connection be terminated
Command          4,0,0
Reply   255,255,255,255,255,255,255,255
 */
