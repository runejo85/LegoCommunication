package uis.lego.explorer;

import uis.beans.*;
import uis.lego.FLegoCon;

public class FExplorerCom extends FLegoCon implements IExplorerCom {
    IMap fMap;

    public FExplorerCom(String name, String address) {
        super(name, address, new Point(0,0));
        fMap = FMap.getInstance();
    }

    public int[] sweep() {
        int hlp;
        switch (heading) {
            case 0: hlp = 4; break;
            case 1: hlp = 3; break;
            case 2: hlp = 2; break;
            case 3: hlp = 1; break;
            default: hlp = 1;
        }
        int[] result = new int[4];
        if (fMap.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() + 1))) {
            result[(hlp) % 4] = 1;
        }
        if (fMap.containsLine(currentPos, new Point(currentPos.getX() + 1, currentPos.getY()))) {
            result[(1 + hlp) % 4] = 1;
        }
        if (fMap.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() - 1))) {
            result[(2 + hlp) % 4] = 1;
        }
        if (fMap.containsLine(currentPos, new Point(currentPos.getX() - 1, currentPos.getY()))) {
            result[(3 + hlp) % 4] = 1;
        }

        return result;
    }

    public static void main(String[] args) {


    }
}


