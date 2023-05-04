package com.company;

import java.util.Scanner;

public class PuzzleA2 {

	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args, Player p) {
		System.out.println("Going through the wall, you see an old man facing the door. He must be waiting for you.");
		System.out.println("Do you want to Talk or Sneak?");
		secretEntrance(p);
	}
	
	public static void secretEntrance(Player p) {
		String ans = s.nextLine().toLowerCase();
		if(ans.equals("talk")) {
			PuzzleA.main(null, p);
		} else if(ans.equals("sneak")) {
			if (p.stats[1] >= 10) {
				System.out.println("A quietly as you could, you sneak behind the old man and rip the key out of his hand.");
				sneaky(p);
			} else {
				System.out.println("You failed to grab the key, and he has noticed you.");
				PuzzleA.main(null, p);
			}
		} else {
			System.out.println("Invaild input. Try again?");
			secretEntrance(p);
		}
	}
	
	public static void sneaky(Player p) {
		System.out.println("You scared the man so much that he fainted while you stole the key. 'It's nothing personal old man.'");
		//System.out.println("You acquired the Rey Key.");
		p.addItemToInventory("red_key");
		p.xpGain(100, s);
        p.red_key = true;
	}
}