package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What class do you desire to be?: warrior, bard, rogue, or mage (please write it as shown)");
        String input = s.nextLine().toLowerCase();
        Player player;
        Intro intro;
        switch (input) {
            case "warrior":
                player = new Player(input);
                intro = new Intro();
                player.listStats();
                player.displayInventory();
                System.out.println("Welcome to the maze! I am the guide of this challenge. Do you wish to talk to me to learn the maze, or would you rather enter.(talk or enter)");
                intro.letsBegin(s, player);
                break;
            case "bard":
                player = new Player(input);
                intro = new Intro();
                player.listStats();
                player.displayInventory();
                System.out.println("Welcome to the maze! I am the guide of this challenge. Do you wish to talk to me to learn the maze, or would you rather enter.(talk or enter)");
                intro.letsBegin(s, player);
                break;
            case "rogue":
                player = new Player(input);
                intro = new Intro();
                player.listStats();
                player.displayInventory();
                System.out.println("Welcome to the maze! I am the guide of this challenge. Do you wish to talk to me to learn the maze, or would you rather enter.(talk or enter)");
                intro.letsBegin(s, player);
                break;
            case "mage":
                player = new Player(input);
                intro = new Intro();
                player.listStats();
                player.displayInventory();
                System.out.println("Welcome to the maze! I am the guide of this challenge. Do you wish to talk to me to learn the maze, or would you rather enter.(talk or enter)");
                intro.letsBegin(s, player);
                break;
            default:
                System.out.println("Not a valid class.");
                Main.main(args);
        }
        
    }
}