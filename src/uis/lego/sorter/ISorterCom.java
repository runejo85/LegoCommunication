package uis.lego.sorter;

import java.awt.*;

public interface ISorterCom {

    public boolean moveToTray(int tray);
    public boolean turnToInitPos();
    public boolean release();
    public boolean grab();
    public Color checkColor();
}
