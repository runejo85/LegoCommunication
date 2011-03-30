package uis.lego;

import java.awt.*;

public class ExplorerCom extends LegoCon implements ICommandConst, ILegoCon, IExplorerCom {

    public ExplorerCom(String name, String adress) {
        super(name, adress);
    }

    public int[] sweep() {
        int[] ret = sendCommand(COMMAND_SWEEP, 0, 0);
        int[] res = new int[4];

        for (int i = 0; i < ret.length; i++) {
            if (ret[i] > -20 && ret[i] < 45) {
                res[0] = 1;
            } else if (ret[i] < 125) {
                res[1] = 1;
            } else if (ret[i] < 225) {
                res[2] = 1;
            } else if (ret[i] < 315) {
                ret[3] = 1;
            } else if (ret[i] < 405) {
                ret[0] = 1;
            }
        }


        return res;
    }

    public boolean disconnect() {
        boolean res = true;
        int ret[] = sendCommand(COMMAND_DISCONNECT, 0, 0);
        for (int a : ret) {
            if (a != 255) {
                res = false;
            }
        }
        return res;
    }

    public Color travel(int dist, boolean checkColor) {
        Color colorAtStop = Color.black;
        int ck = 0;

        if (checkColor) {
            ck = 1;
        }

        int[] ret = sendCommand(COMMAND_TRAVEL, dist, ck);

        colorAtStop = getColor(ret[0]);

        return colorAtStop;
    }

    public boolean turn(int degrees) {
        sendCommand(COMMAND_TURN, degrees, 0);
        return true;
    }

    private Color getColor(int i) {
        switch (i) {
            case 0:
                return null;
            case 1:
                return Color.black;
            case 2:
                return Color.blue;
            case 3:
                return Color.green;
            case 4:
                return Color.yellow;
            case 5:
                return Color.red;
            case 6:
                return Color.white;
            default:
                return Color.white;
        }
    }


}
