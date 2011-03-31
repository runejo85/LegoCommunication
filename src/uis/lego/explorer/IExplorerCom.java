package uis.lego.explorer;



public interface IExplorerCom {

    public int[] sweep();
     public java.awt.Color travel(int dist, boolean checkColor);
    public boolean turn(int degrees);
    public boolean disconnect();
}
