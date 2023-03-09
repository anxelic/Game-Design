package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What class do you desire to be?: warrior, bard, rogue, or mage (please write it as shown)");
        String input = s.nextLine().toLowerCase();
        Player player = new Player(input);
        player.listStats();
        player.displayInventory();

        player.command(s);

        // System.out.println("What stat do you wish to increase? (strength, agility, charisma, intelligence):");
        // input = s.nextLine().toLowerCase();
        // player.upgradeStat(input);
        // player.listStats();

        // player.xpGain(250, s);
        // player.listStats();

        
    }
}