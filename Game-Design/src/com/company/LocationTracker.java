package com.company;

public class LocationTracker {
    // define different spaces
    private static final int SPACE = 0;
    private static final int WALL = 1;
    private static final int HORWALL = 2;
    
    // map dim
    private static final int MAP_WIDTH = 17;
    private static final int MAP_HEIGHT = 17;
    
    // players start position
    private static final int START_X = 9;
    private static final int START_Y = 0;
    
    // map creation
    private int[][] map = new int[MAP_WIDTH][MAP_HEIGHT];
    
    // current position
    private int playerX = START_X;
    private int playerY = START_Y;
    
    public LocationTracker() {
        //left wall
        for (int i = 0; i < MAP_HEIGHT; i++) {
            map[0][i] = WALL;
        }
        //right wall
        for (int i = 0; i < MAP_HEIGHT; i++) {
            map[MAP_WIDTH - 1][i] = WALL;
        }

        //top wall
        for (int i = 1; i < MAP_WIDTH - 1; i++) {
            if (i == 9) {
                map[i][0] = SPACE; // entrance
            } else {
                map[i][0] = HORWALL;
            }
        }

        //bot wall
        for (int i = 1; i < MAP_WIDTH - 1; i++) {
            if (i == 7) {
                map[i][MAP_HEIGHT -1] = SPACE; //exit
            } else {
                map[i][MAP_HEIGHT -1] = HORWALL;
            }
        }

        //room walls
        // map[8][1] = WALL;
        // map[10][1] = WALL;
        // map[14][1] = WALL;
        // map[8][2] = WALL;
        // map[10][2] = WALL;
        // map[14][2] = WALL;
        // map[2][2] = HORWALL;
        // map[3][2] = HORWALL;
        // map[4][2] = HORWALL;
        // map[6][2] = HORWALL;
        // map[7][2] = HORWALL;
        // map[8][2] = WALL;
        // map[10][2] = WALL;
        // map[11][2] = HORWALL;
        // map[12][2] = HORWALL;
        // map[4][3] = WALL;
        // map[4][4] = WALL;

        map[1][6] = HORWALL;
        map[1][8] = HORWALL;
        map[2][2] = HORWALL;
        map[2][6] = HORWALL;
        map[2][8] = HORWALL;
        map[3][2] = HORWALL;
        map[3][6] = HORWALL;
        map[3][8] = HORWALL;
        map[4][2] = WALL;
        map[4][3] = WALL;
        map[4][4] = WALL;
        map[4][5] = WALL;
        map[4][6] = WALL;
        map[4][8] = WALL;
        map[4][9] = WALL;
        map[4][10] = WALL;
        map[4][11] = WALL;
        map[4][12] = WALL;
        map[4][13] = WALL;
        map[4][14] = WALL;
        map[5][4] = HORWALL;
        map[6][2] = HORWALL;
        map[6][4] = HORWALL;
        map[6][6] = WALL;
        map[6][7] = WALL;
        map[6][8] = WALL;
        map[6][10] = WALL;
        map[6][11] = WALL;
        map[6][12] = WALL;
        map[6][13] = WALL;
        map[6][14] = WALL;
        map[6][15] = WALL;
        map[7][2] = HORWALL;
        map[7][4] = HORWALL;
        map[7][8] = HORWALL;
        map[7][10] = HORWALL;
        map[7][14] = HORWALL;
        map[8][1] = WALL;
        map[8][2] = WALL;
        map[8][4] = WALL;
        map[8][5] = WALL;
        map[8][6] = WALL;
        map[8][7] = WALL;
        map[8][8] = WALL;
        map[8][10] = WALL;
        map[8][11] = WALL;
        map[8][12] = WALL;
        map[8][14] = HORWALL;
        map[9][14] = HORWALL;
        map[10][1] = WALL;
        map[10][2] = WALL;
        map[10][4] = WALL;
        map[10][5] = WALL;
        map[10][6] = WALL;
        map[10][7] = WALL;
        map[10][8] = WALL;
        map[10][9] = WALL;
        map[10][10] = WALL;
        map[10][11] = WALL;
        map[10][12] = WALL;
        map[10][13] = WALL;
        map[10][14] = WALL;
        map[11][2] = HORWALL;
        map[11][4] = HORWALL;
        map[11][10] = HORWALL;
        map[12][2] = HORWALL;
        map[12][4] = HORWALL;
        map[12][10] = HORWALL;
        map[12][12] = WALL;
        map[12][13] = WALL;
        map[12][14] = WALL;
        map[13][4] = HORWALL;
        map[13][10] = HORWALL;
        map[13][14] = HORWALL;
        map[14][1] = WALL;
        map[14][2] = WALL;
        map[14][4] = WALL;
        map[14][5] = WALL;
        map[14][6] = WALL;
        map[14][7] = WALL;
        map[14][8] = WALL;
        map[14][10] = HORWALL;
        map[14][12] = WALL;
        map[14][13] = WALL;
        map[14][14] = WALL;
        map[15][14] = HORWALL;
    }
    
    public void play(String s) {
        // displayWorld();
        switch (s) {
            case "north":
                if (playerY > 0 && map[playerX][playerY - 1] != WALL && map[playerX][playerY - 1] != HORWALL) {
                    playerY--;
                }
                break;
            case "south":
                if (playerY < MAP_HEIGHT - 1 && map[playerX][playerY + 1] != WALL && map[playerX][playerY + 1] != HORWALL) {
                    playerY++;
                }
                break;
            case "west":
                if (playerX > 0 && map[playerX - 1][playerY] != WALL && map[playerX - 1][playerY] != HORWALL) {
                    playerX--;
                }
                break;
            case "east":
                if (playerX < MAP_WIDTH - 1 && map[playerX + 1][playerY] != WALL && map[playerX + 1][playerY] != HORWALL) {
                    playerX++;
                }
                break;
        }
        // System.out.println("-------------------------------------");
        displayWorld();
    }
    
    private void displayWorld() {
        
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                if (x == playerX && y == playerY) {
                    System.out.print(" @ ");
                } else {
                    switch (map[x][y]) {
                        case SPACE:
                            System.out.print("   ");
                            break;
                        case WALL:
                            System.out.print(" | ");
                            break;
                        case HORWALL:
                            System.out.print("---");
                    }
                }
            }
            System.out.println();
        }
    }
}