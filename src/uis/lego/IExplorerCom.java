package uis.lego;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 3/25/11
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IExplorerCom {

    public int[] sweep();
     public String travel(int dist, boolean checkColor);
    public boolean turn(int degrees);
    public boolean disconnect();
}
