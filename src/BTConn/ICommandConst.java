package BTConn;

/**
 * Created by IntelliJ IDEA.
 * User: Rune
 * Date: 25.01.11
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
public interface ICommandConst {

	public static final int BATTERY_VOLTAGE = 0;

	public static final int PING = 1;

	public static final int TRAVEL = 2;

	public static final int TURN = 3;

	public static final int DISCONNECT = 4;

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
