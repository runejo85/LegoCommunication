package uis.lego.sorter;

import java.awt.*;
import java.util.Random;

public class FSorterCom implements ISorterCom {
    private String name;
    private String address;

    public FSorterCom(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public boolean moveToTray(int tray) {
        return false;
    }

    public boolean turnToInitPos() {
        return false;
    }

    public boolean release() {
        return false;
    }

    public boolean grab() {
        return false;
    }

    public Color checkColor() {
        return getRandomColor();
    }


    private Color getRandomColor() {
        Random rnd = new Random();
        int a = rnd.nextInt() % 6;
        switch (a) {
            case 0: return Color.green;
            case 1: return Color.yellow;
            case 2: return Color.red;
            case 3: return Color.blue;
            case 4: return Color.white;
            case 5: return Color.magenta;
            default: return Color.blue;
        }
    }
}
