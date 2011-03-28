package uis.Beans;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Rune
 * Date: 17.03.11
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
public class Point implements Serializable {
    private int x,y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;

    }


    public void setY(int y){
        this.y = y;

    }


    public void setPoint(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX(){
        return this.x;

    }

    public int getY(){
        return this.y;

    }

    public boolean equals(Point p) {
        if (this.x == p.getX() && this.y == p.getY()) {
            return true;
        }
        return false;
    }

}
