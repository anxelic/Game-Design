package com.company;

import java.util.Scanner;

public class PuzzleC {

	private static Scanner s = new Scanner(System.in);
	private static String[] comb = {"", "", "", "", "", "", "", "", "", "", "", ""};
	private static boolean[] correct = {false, false, false, false, false, false, false, false, false, false, false, false};
	
	public static void main(String[] args, Player p) {
		System.out.println("You enter a room with a long hallway, filled with traps. In front of the hallway is a pannel.");
		System.out.println("Would you like to go through hallway or look at pannel?");
		decision(p);
	}
	
	public static void decision(Player p) {
		String ans = s.nextLine().toLowerCase();
		if(ans.equals("go through hallway") || ans.equals("hallway") || ans.equals("go to hallway") || ans.equals("to hallway") || ans.equals("enter hallway") || ans.equals("go through the hallway")) {
            if (p.stats[1] >= 10) {
                hallway(p);
            } else {
                main(null, p);
            }
		} else if(ans.equals("look at pannel") || ans.equals("pannel") || ans.equals("go to pannel") || ans.equals("look at the pannel")) {
			System.out.println("You move over to this pannel that reads: '1m44803pdefg'. Each space has the letters 'a-z' and numbers '0-9' The hint to solving this panel is as followed:");
			System.out.println("'This password is a password that everyone would use plus the first 4 numbers after 0.'");
			System.out.println("Would you like to try to solve or go through the hallway?");
			decision2(p);
		} else {
			System.out.println("Invalid input. Try again.");
			decision(p);
		}
	}
	
	public static void hallway(Player p) {
		System.out.println("You decide to go through this hallway where there are many traps. Being careful you go past all of the traps and make your way to a switch to power down the traps.");
		System.out.println("You have acquired the Blue Key.");
        p.addItemToInventory("blue_key");
        p.blue_key = true;
	}
	
	public static void decision2(Player p) {
		String ans = s.nextLine().toLowerCase();
		if(ans.equals("go through hallway") || ans.equals("hallway") || ans.equals("go to hallway") || ans.equals("to hallway") || ans.equals("enter hallway") || ans.equals("go through the hallway")) {
            if (p.stats[1] >= 10) {
                hallway(p);
            } else {
                main(null, p);
            }
		} else if(ans.equals("try to solve") || ans.equals("solve") || ans.equals("solve pannel")) {
			System.out.println("You proceed to solve the riddle. Answer carefully as you are not to leave until it is correct.");
			lockCombination(p);
		} else {
			System.out.println("Invalid input. Try again.");
			decision2(p);
		}
	}
	
	public static void lockCombination(Player p) {
		String[] correctComb = {"p", "a", "s", "s", "w", "o", "r", "d", "1", "2", "3", "4"};
        String combCode = "";
        if (p.stats[3] >= 10) {
            System.out.println("With your high intellect, you figure the code out instantly.");
            combCode = "password1234";
        } else {
            for(int i = 0; i < 12; i++) {
				if (correct[i] != true) {
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
				} else {
					combCode = combCode + comb[i];
				}
			}      
        }
		for (int i = 0; i < 12; i++) {
			if (comb[i].equals(correctComb[i])) {
				correct[i] = true;
			} else {
				System.out.println("Combination spot " + (i + 1) + " is incorrect.");
			}
		}
        if(combCode.equals("password1234")) {
			System.out.println("You tried to unlock the pannel, and it has stopped all of the traps down the hall. '" + combCode + "' was the correct password.");
			System.out.println("Going down the hallway, you noticed that all of the traps are down and you made your way down the hall.");
			//System.out.println("You have acquired the Blue Key.");
			for (int i = 0; i < 12; i++) {
				correct[i] = false;
			}
            p.addItemToInventory("blue_key");
            p.blue_key = true;
		} else {
			System.out.println("You tried to unlock the pannel, but you have failed and given the wrong password. You can't leave, so you attempt to solve the password again.");
			combCode = "";
			lockCombination(p);
		}
	}
}