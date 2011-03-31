package uis.lego.collector;

import uis.beans.Point;
import uis.lego.FLegoCon;


public class FCollectorCom extends FLegoCon implements ICollectorCom {

    public FCollectorCom(String name, String address) {
        super(name, address, new Point(0, 0));
    }

    public boolean grab() {
        return true;
    }

    public boolean release() {
        return true;
    }
}
