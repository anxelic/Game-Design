package com.company;

import java.util.Scanner;

public class PuzzleA2 {

	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Going through the wall, you see an old man facing the door. He must be waiting for you.");
		System.out.println("Do you want to Talk or Sneak?");
		secretEntrance();
	}
	
	public static void secretEntrance() {
		String ans = s.nextLine().toLowerCase();
		if(ans.equals("talk")) {
			PuzzleA.main(null);
		} else if(ans.equals("sneak")) {
			System.out.println("A quietly as you could, you sneak behind the old man and rip the key out of his hand.");
			sneaky();
		} else {
			System.out.println("Invaild input. Try again?");
			secretEntrance();
		}
	}
	
	public static void sneaky() {
		System.out.println("You scared the man so much that he fainted while you stole the key. 'It's nothing personal old man.'");
		System.out.println("You acquired the Rey Key.");
	}
}