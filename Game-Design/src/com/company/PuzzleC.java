package com.company;

import java.util.Scanner;

public class PuzzleC {

	private static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("You enter a room with a long hallway, filled with traps. In front of the hallway is a pannel.");
		System.out.println("Would you like to go through hallway or look at pannel?");
		decision();
	}
	
	public static void decision() {
		String ans = s.nextLine().toLowerCase();
		if(ans.equals("go through hallway") || ans.equals("hallway") || ans.equals("go to hallway") || ans.equals("to hallway") || ans.equals("enter hallway") || ans.equals("go through the hallway")) {
			hallway();
		} else if(ans.equals("look at pannel") || ans.equals("pannel") || ans.equals("go to pannel") || ans.equals("look at the pannel")) {
			System.out.println("You move over to this pannel that reads: '1m44803pdefg'. Each space has the letters 'a-z' and numbers '0-9' The hint to solving this panel is as followed:");
			System.out.println("'This password is a password that everyone would use plus the first 4 numbers after 0.'");
			System.out.println("Would you like to try to solve or go through the hallway?");
			decision2();
		} else {
			System.out.println("Invalid input. Try again.");
			decision();
		}
	}
	
	public static void hallway() {
		System.out.println("You decide to go through this hallway where there are many traps. Being careful you go past all of the traps and make your way to a switch to power down the traps.");
		System.out.println("You have acquired the Blue Key.");
	}
	
	public static void decision2() {
		String ans = s.nextLine().toLowerCase();
		if(ans.equals("go through hallway") || ans.equals("hallway") || ans.equals("go to hallway") || ans.equals("to hallway") || ans.equals("enter hallway") || ans.equals("go through the hallway")) {
			hallway();
		} else if(ans.equals("try to solve") || ans.equals("solve") || ans.equals("solve pannel")) {
			System.out.println("You proceed to solve the riddle. Answer carefully as you are not to leave until it is correct.");
			lockCombination();
		} else {
			System.out.println("Invalid input. Try again.");
			decision2();
		}
	}
	
	public static void lockCombination() {
		String[] comb = {"", "", "", "", "", "", "", "", "", "", "", ""};
		String combCode = "";
		for(int i = 0; i < 12; i++) {
			System.out.println("What is the letter/number in spot number " + (i + 1) + "?");
			String ans = s.nextLine().toLowerCase();
			if(ans.length() > 1) {
				System.out.println("Sorry, only 1 input per lock combination, try again.");
				i--;
			} else if(ans.length() < 1) {
				System.out.println("You need at least 1 combination, try again.");
				i--;
			} else {
				comb[i] = ans;
				combCode = combCode + ans;
			}
		} if(combCode.equals("password1234")) {
			System.out.println("You tried to unlock the pannel, and it has stopped all of the traps down the hall. " + combCode + " was the correct password.");
			System.out.println("Going down the hallway, you noticed that all of the traps are down and you made your way down the hall.");
			System.out.println("You have acquired the Blue Key.");
		} else {
			System.out.println("You tried to unlock the pannel, but you have failed and given the wrong password. You can't leave, so you attempt to solve the password again.");
			combCode = "";
			lockCombination();
		}
	}
}