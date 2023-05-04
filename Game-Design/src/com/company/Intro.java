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
                System.out.println("Invalid response. The guy no longer wishes to talk to you..");
                player.command(s);
            }
        } else if (input.equals("enter")) {
            player.command(s);
        } else {
            System.out.println("I'm sorry, what was that?");
            letsBegin(s, player);
        }
    }

    public void statCheck (Scanner s, Player player) {
        //strength
	    //agility <- > 10
	    //charisma <-  > 10
	    //intelligence
        if (player.stats[1] > 10) { // agi check
            System.out.println("*You sneak up and steal the copy of the map from the guide.");
            player.addItemToInventory("map");
            System.out.println("*You hastly make your way into the maze.");
            player.command(s);

        } else if (player.stats[2] > 10) { //charisma check
            System.out.println("*You convince the guide to give you the layout of the maze.");
            player.addItemToInventory("map");
            System.out.println("*You make your way into the maze...");
            player.command(s);
        }
    }
}
