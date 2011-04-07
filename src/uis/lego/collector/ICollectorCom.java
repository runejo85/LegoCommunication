package uis.lego.collector;

import java.awt.Color;

/**
 * Created by IntelliJ IDEA.
 * User: eirik
 * Date: 3/31/11
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ICollectorCom {
    public Color travel(int dist, boolean checkColor);

    public boolean turn(int degrees);

    public boolean grab();

    public boolean release();

    int sweep();

}
