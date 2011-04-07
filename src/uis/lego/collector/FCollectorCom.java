package uis.lego.collector;

import uis.beans.IMap;
import uis.beans.Point;
import uis.lego.FLegoCon;
import uis.lego.ICommandConst;


public class FCollectorCom extends FLegoCon implements ICollectorCom, ICommandConst {

    public FCollectorCom(String name, String address) {
        super(name, address, new Point(0, 0));
    }

    public boolean grab() {
        return true;
    }

    public boolean release() {
        return true;
    }

    public int sweep() {
        switch (heading) {
            case NORTH:
                if (map.containsLine(currentPos, new Point(currentPos.getX() + 5, currentPos.getY()))) {
                    return 1;
                } else if (map.containsLine(currentPos, new Point(currentPos.getX() - 5, currentPos.getY()))) {
                    return 3;
                } else if(map.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() - 5))) {
                    return 2;
                }  else if(map.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() + 5))) {
                    return 0;
                }
                else {
                    System.out.println("FUCKUP IN FCollectorCom.java SWEEP");
                }

                break;
            case EAST:
                if (map.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() + 5))) {
                    return 1;
                } else if (map.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() - 5))) {
                    return 3;
                } else if(map.containsLine(currentPos, new Point(currentPos.getX() + 5, currentPos.getY()))) {
                    return 2;
                }  else if(map.containsLine(currentPos, new Point(currentPos.getX() - 5, currentPos.getY()))) {
                    return 0;
                }else {
                    System.out.println("FUCKUP IN FCollectorCom.java SWEEP");
                }
                break;
            case WEST:
                if (map.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() - 5))) {
                    return 1;
                } else if (map.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() + 5))) {
                    return 3;
                } else if(map.containsLine(currentPos, new Point(currentPos.getX() - 5, currentPos.getY()))) {
                    return 2;
                }  else if(map.containsLine(currentPos, new Point(currentPos.getX() + 5, currentPos.getY()))) {
                    return 0;
                } else {
                    System.out.println("FUCKUP IN FCollectorCom.java SWEEP");
                }
                break;
            case SOUTH:
                if (map.containsLine(currentPos, new Point(currentPos.getX() + 5, currentPos.getY()))) {
                    return 3;
                } else if (map.containsLine(currentPos, new Point(currentPos.getX() - 5, currentPos.getY()))) {
                    return 1;
                }  else if(map.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() + 5))) {
                    return 2;
                }  else if(map.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY() - 5))) {
                    return 0;
                }  else {
                    System.out.println("FUCKUP IN FCollectorCom.java SWEEP");
                }
                break;
            default: return -1;
        }
        return -1;
    }
}
