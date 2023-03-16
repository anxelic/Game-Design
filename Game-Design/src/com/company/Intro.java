package com.company;

import java.util.Scanner;

public class Intro {

    public Intro () {
    }
    

    public void letsBegin (Scanner s, Player player) {
        String input = s.nextLine().toLowerCase();
        if (input.equals("talk")) {
            System.out.println("Good choice! This maze is a tricky one, with multiple puzzles with items and clues scattered about.");
            System.out.println("Make sure to remember where you are, there is only one copy of of a map and I am the owner.");
            System.out.println("*You see the map. Do you wish to perform a stat check? (Charisma and Agility) Yes or No.");
            input = s.nextLine().toLowerCase();
            if (input.equals("yes")) {
                statCheck(s, player);
            } else if (input.equals("no")) {
                player.command(s);
            } else {
                System.out.println("Invalid. Yes, or no?");
                input = s.nextLine().toLowerCase();
            }
        } else if (input.equals("enter")) {
            player.command(s);
        } else {
            System.out.println("I'm sorry, what was that?");
            letsBegin(s, player);
        }
    }

    public void statCheck (Scanner s, Player player) {

    }
}
