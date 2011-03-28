package uis.lego;

import uis.Beans.FMap;
import uis.Beans.IMap;
import uis.Beans.Point;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 3/23/11
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class FExplorerCom implements IExplorerCom{
    Point currentPos;
    int heading = 0;
    IMap fMap;



    public FExplorerCom(String name, String adress){
        currentPos = new Point(0,0);
        fMap = FMap.getInstance();
    }

    public int[] sweep(){
        int hlp;
        switch(heading) {
            case 0: hlp = 4; break;
            case 1: hlp = 3; break;
            case 2: hlp = 2; break;
            case 3: hlp = 1; break;
            default: hlp = 1;
        }


        int[] result = new int[4];
        if(fMap.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY()+1))) {
            result[(hlp) % 4] = 1;
        }
        if(fMap.containsLine(currentPos, new Point(currentPos.getX()+1, currentPos.getY()))) {

            result[(1 + hlp) % 4] = 1;
        }
        if(fMap.containsLine(currentPos, new Point(currentPos.getX(), currentPos.getY()-1))) {
            result[(2 + hlp) % 4] = 1;
        }
        if(fMap.containsLine(currentPos, new Point(currentPos.getX()-1, currentPos.getY()))) {
            result[(3 + hlp) % 4] = 1;
        }


        return result;
    }

    public String travel(int dist, boolean checkColor){

        switch (heading) {
            case 0: currentPos = new Point(currentPos.getX(), currentPos.getY()+1); break;
            case 1: currentPos = new Point(currentPos.getX()+1, currentPos.getY()); break;
            case 2: currentPos = new Point(currentPos.getX(), currentPos.getY()-1); break;
            case 3: currentPos = new Point(currentPos.getX()-1, currentPos.getY()); break;
            default:System.out.println("FUUCKED IN TRAVLE");
        }
        if(checkColor) return "yellow";
        else return "black";
     }

    public boolean turn(int degrees){

            heading = (heading + (degrees / 90)) % 4;
        return false;
    }

    public boolean disconnect() {
        return true;

     }

    public String getPos() {
        return ("X: " + currentPos.getX() + " Y: " + currentPos.getY());
    }

    public static void main(String[] args) {
        FExplorerCom gg = new FExplorerCom("gg", "gg");
        int[] res = gg.sweep();
        for (int a  : res) {
            System.out.println(a);
        }
        gg.turn(90);
        gg.travel(50, true);
        System.out.println(gg.getPos());
        res = gg.sweep();
        for (int a  : res) {
            System.out.println(a);
        }

    }

}
