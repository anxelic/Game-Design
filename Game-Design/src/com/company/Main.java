package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("What class do you desire to be?: warrior, face, rogue, or mage (please write it as shown)");
        String input = s.nextLine().toLowerCase();
        s.close();

        Player player = new Player(input);
        player.listStats();
    }
}