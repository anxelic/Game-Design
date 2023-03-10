package com.company;

import java.util.*;

public class LocationTracker {
    // define different spaces
    private static final int SPACE = 0;
    
    // map dim
    private static final int MAP_WIDTH = 10;
    private static final int MAP_HEIGHT = 10;
    
    // players start position
    private static final int START_X = 0;
    private static final int START_Y = 0;
    
    // map creation
    private int[][] map = new int[MAP_WIDTH][MAP_HEIGHT];
    
    // current position
    private int playerX = START_X;
    private int playerY = START_Y;
    
    public LocationTracker() {
    }
    
    public void play(String s) {
        displayWorld();
        switch (s) {
            case "north":
                if (playerY > 0) {
                    playerY--;
                }
                break;
            case "south":
                if (playerY < MAP_HEIGHT - 1) {
                    playerY++;
                }
                break;
            case "west":
                if (playerX > 0) {
                    playerX--;
                }
                break;
            case "east":
                if (playerX < MAP_WIDTH - 1) {
                    playerX++;
                }
                break;
        }
        displayWorld();
    }
    
    private void displayWorld() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                if (x == playerX && y == playerY) {
                    System.out.print("@");
                } else {
                    switch (map[x][y]) {
                        case SPACE:
                            System.out.print(".");
                            break;
                    }
                }
            }
            System.out.println();
        }
    }
}