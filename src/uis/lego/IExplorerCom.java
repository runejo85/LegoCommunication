package uis.lego;


public interface IExplorerCom {

    public int[] sweep();
     public String travel(int dist, boolean checkColor);
    public boolean turn(int degrees);
    public boolean disconnect();
}
