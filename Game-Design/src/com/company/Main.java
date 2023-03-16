package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What class do you desire to be?: warrior, bard, rogue, or mage (please write it as shown)");
        String input = s.nextLine().toLowerCase();
        Intro intro = new Intro();
        Player player = new Player(input);
        player.listStats();
        player.displayInventory();

        //Intro intro = new Intro(player);
        System.out.println("Welcome to the maze! I am the guide of this challenge. Do you wish to talk to me to learn the maze, or would you rather enter.(talk or enter)");
        intro.letsBegin(s, player);
        //System.out.println("Welcome to the maze! I am the guide of this challenge. Do you wish to talk to me to learn the maze, or would you rather enter.(talk or enter)");

        //player.command(s);
    }
}