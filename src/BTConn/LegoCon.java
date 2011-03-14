package BTConn;

import lejos.pc.comm.*;
import lejos.nxt.remote.*;
import lejos.pc.comm.NXTComm;

import java.io.*;


/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 1/25/11
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class LegoCon{

    private NXTCommand command;
    private final int protocol = NXTCommFactory.BLUETOOTH;
    private NXTConnector conn;
    private String name;
    NXTComm nxtComm;
    NXTInfo nxtInfo;
    private DataOutputStream dos;
    private DataInputStream dis;


    protected LegoCon(String name, String address) {
        checkConstructorVariables(name, address);
        establishConnection(name, address);
        dos = new DataOutputStream(nxtComm.getOutputStream());
        dis = new DataInputStream(nxtComm.getInputStream());
    }

    private void checkConstructorVariables(String name, String address) {
        if (name.equals("")) {
            System.out.println("Invalid Bluetooth Name");
        }
        else if(address.equals("")) {
            System.out.println("Invalid Bluetooth Address");
        }
    }

    private void establishConnection(String name, String address) {
        try {
            nxtComm = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
        } catch (NXTCommException e) {
            System.out.println("No Bluetooth Drive");
        }

        nxtInfo = new NXTInfo(NXTCommFactory.BLUETOOTH, name, address);
        try {
            nxtComm.open(nxtInfo);
        } catch (NXTCommException e) {
            e.printStackTrace();
        }
    }

    protected int[] sendCommand(int cmd,int arg0,int arg1) {

        if (dos == null) {
            System.out.println("dos is null");
        }
        int[] command = new int[]{cmd, arg0, arg1};
        sendC(command);
        return replyResult();

    }

    private int[] replyResult() {
        int[] reply = new int[8];
        for (int i = 0; i < reply.length; i++) {
            try {
                reply[i] = dis.readInt();
                //System.out.println(reply[i]);
            } catch (IOException ioe) {
                break;
            }
        }
        return reply;
    }

    private void sendC(int[] command) {
        //System.out.println(command.length);
        for (int k : command) {
            try {
                dos.writeInt(k);
                dos.flush();
            } catch (IOException ioe) {
                break;
            }
        }
    }
}

