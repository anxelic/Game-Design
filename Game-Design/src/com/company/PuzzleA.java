package com.company;

import java.util.Scanner;
public class PuzzleA {
	
	private static Scanner s = new Scanner(System.in);
	public static void main(String[] args, Player p) {
		System.out.println("You enter a room and someone dressed well is sitting upon a fancy chair. 'I see you have arrived. I am called the RiddleRuler, and in order to gain the red key, you must answer my riddle.'");
		System.out.println("Do you proceed or intimidate?");
		theMan(p);
	}
	
	public static void theMan(Player p) {
		String ans = s.nextLine().toLowerCase();
		if (ans.equals("proceed")) {
			System.out.println("The man looks at you, creepily. 'You are on a plane with 100 people, all but 12 people died in a crash. How many people survived the crash?'");
			riddle(p);
		} else if (ans.equals("intimidate")) {
            if (p.stats[0] >= 10) {
                System.out.println("You can a lot of confidence. 'I'm sorry old man. I don't have time to play games.'");
                intimidate(p);
            } else {
                System.out.println("You do not meet the skill requirement to do this.");
                main(null, p);
            }	
		} else {
			System.out.println("Invalid input. Try again?");
			theMan(p);
		}
	}
	
	public static void riddle(Player p) {
		String ans = s.nextLine().toLowerCase();
		if (ans.equals("12") || ans.equals("twelve")) {
			System.out.println("'That is correct my friend. Here, you've earned this.' The main gives you a red key.");
			//System.out.println("You aquired the Red Key.");
            p.addItemToInventory("red_key");
            p.red_key = true;
		} else if(ans.equals("distract")) {
            if (p.stats[2] >= 10) {
                System.out.println("Finding this very stupid, you yell at the man. 'I don't have time for this old man. Can't you see how angry this makes me?'");
			    distract(p);
            } else {
                System.out.println("You fail this stat requirement..");
                main(null, p);
            }
		} else if(ans.equals(null)) {
			System.out.println("Invalid input. Try again?");
			riddle(p);
		} else {
			System.out.println("'That is incorrect. Please try again my friend.'");
			riddle(p);
		}
	}
	
	public static void intimidate(Player p) {
		System.out.println("You startle the old man who throws the key to you. 'Well you're no fun are you?'");
		//System.out.println("You acquired the Red Key.");
        p.addItemToInventory("red_key");
        p.red_key = true;
	}
	
	public static void distract(Player p) {
		System.out.println("The old man laughs at you. 'Ahahaha, I see this must be super hard for you, but I've had fun doing this. Here you go son.'");
		//System.out.println("You acquired the Red Key.");
        p.addItemToInventory("red_key");
        p.red_key = true;
	}
}