package com.katanamajesty;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {

    public Tile(int x, int y, float scale, int size) {
        setLayout(null);
        int rgb = (int) (scale * 10); rgb = 255 - rgb;
        if (rgb > 255) rgb = 255;
        else if (rgb < 0) rgb = 0;
        setBackground(new Color(rgb, rgb, rgb));
        setBounds(x*size, y*size, size, size);
    }

}
