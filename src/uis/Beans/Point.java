package uis.Beans;

/**
 * Created by IntelliJ IDEA.
 * User: Rune
 * Date: 17.03.11
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
public class Point {
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

}
