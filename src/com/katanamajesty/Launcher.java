package com.katanamajesty;

import javax.swing.*;

public class Launcher {

    static PerlinNoise noise;
    static Vector3[] coordinates;
    static Tile[] tiles;

    static int mapLength = 128;

    public static void main(String[] args) {
        noise = new PerlinNoise(mapLength);
        coordinates = noise.generateCoordinates(1, .2f, 4);

        new UI(coordinates);
    }
}

class UI extends JFrame {

    final int LENGTH;
    int TILE_SIZE = 5;

    JPanel background;
    Tile[] tiles;

    public UI(Vector3[] coordinates) {

        tiles = new Tile[coordinates.length];
        LENGTH = (int) Math.sqrt(tiles.length);

        setSize(LENGTH * TILE_SIZE, LENGTH * TILE_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Шум Перлина");

        background = new JPanel();
        background.setLayout(null);
        background.setBounds(0, 0, LENGTH * TILE_SIZE, LENGTH * TILE_SIZE);

        int c = 0;
        for (int x = 0; x < LENGTH; x++) {
            for (int y = 0; y < LENGTH; y++) {
                tiles[c] = new Tile(x, y, coordinates[c].y, TILE_SIZE);
                background.add(tiles[c]);
                c++;
            }
        }

        add(background);
        setVisible(true);
    }

}

class Vector3 {
    int x, z;
    float y;

    public Vector3(int x, float y, int z) {
        this.x = x;
        this.z = z;
        this.y = y;
    }

}
