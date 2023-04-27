package com.company;

import java.util.Scanner;

public class Player {
	String spec;
	int[] stats = new int[4];
	//strength 			 0
	//agility  			 1
	//charisma 			 2
	//intelligence		 3
	int health;
	int level = 1;
	int experience = 0;
	int xpCap = 200;
	String[] inventory = new String[10];
	LocationTracker map = new LocationTracker();
	boolean game = true;
	boolean red_key = false;
	boolean blue_key = false;
	boolean green_key = false;

	public Player(String s) {
		spec = s;
		stats = statDetermine();
		initInventory(s);
	}

	private void initInventory (String s) {
		switch (s) {
			case "warrior":
				addItemToInventory("sword");
				addItemToInventory("bread");
				break;
			case "bard":
				addItemToInventory("flute");
				addItemToInventory("bread");
				break;
			case "rogue":
				addItemToInventory("dagger");
				addItemToInventory("bread");
				break;
			case "mage":
				addItemToInventory("wand");
				addItemToInventory("bread");
				break;
		}
	}

	private int[] statDetermine() {
		int[] stats = new int[4];
		switch (spec) {
			case "warrior":
				stats[0] = 25;
				stats[1] = 7;
				stats[2] = 9;
				stats[3] = 1;
				health = 100;
				break;
			case "bard":
				stats[0] = 5;
				stats[1] = 3;
				stats[2] = 25;
				stats[3] = 9;
				health = 30;
				break;
			case "rogue":
				stats[0] = 9;
				stats[1] = 25;
				stats[2] = 3;
				stats[3] = 5;
				health = 70;
				break;
			case "mage":
				stats[0] = 2;
				stats[1] = 8;
				stats[2] = 7;
				stats[3] = 25;
				health = 50;
				break;
		}
		return stats;
	}

	public void listStats () {
		System.out.println("Strength: " + stats[0]);
		System.out.println("Agility: " + stats[1]);
		System.out.println("Charisma: " + stats[2]);
		System.out.println("Intelligence: " + stats[3]);
		System.out.println("Health: " + health);
		System.out.println("Current XP: " + experience + "/" + xpCap);
		System.out.println("Level: " + level);
	}

	public void upgradeStat (String s) {
		switch (s) {
			case "strength":
				stats[0] = stats[0] + 1;
				break;
			case "agility":
				stats[1] = stats[1] + 1;
				break;
			case "charisma":
				stats[2] = stats[2] + 1;
				break;
			case "intelligence":
				stats[3] = stats[3] + 1;
				break;
		}
	}

	public void levelUp (Scanner s) {
		System.out.println("You leveled up! Which stat would you like to increase?");
		if (s.hasNextLine()) {
			String x = s.nextLine();
			upgradeStat(x);
		}
	}

	public void xpGain (int x, Scanner s) {
		experience += x;
		while (experience > xpCap) {
			experience -= xpCap;
			level++;
			levelUp(s);
		}
	}

	public boolean keyCheck () {
		int count = 0;

		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				if (inventory[i].equals("red_key") || inventory[i].equals("blue_key") || inventory[i].equals("green_key")) {
					count++;
				} 
			}
		}

		if (count == 3) {
			return true;
		} else {
			return false;
		}
	}

	public boolean mapCheck () {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null) {
				if (inventory[i].equals("map")) {
					return true;
				} 
			}
		}
		return false;
	}

	public void command (Scanner s) {
		if (map.gameEnd() == true) {
			System.out.println("ajhwvdghjvwawadhjwadjh");
		} else {
			System.out.println("What do you wish to do next? (help for list of cmds): ");
		String input = s.nextLine().toLowerCase();
		if (input.equals("help")) {
			System.out.println("The list of commands are: ");
			System.out.println("- help (brings you here!)");
			System.out.println("- inv (displays current inventory)");
			System.out.println("- drop (drops an item from your inventory)");
			System.out.println("- ls (lists your current stats)");
			System.out.println("- grab (grabs an item)");
			System.out.println("- north (moves north)");
			System.out.println("- west (moves west)");
			System.out.println("- east (moves east)");
			System.out.println("- south (moves south)");
			command(s);
		} else if (input.equals("north")) {
			map.play(input, this, s);
			command(s);
		} else if (input.equals("south")) {
			map.play(input, this, s);
			command(s);
		} else if (input.equals("west")) {
			map.play(input, this, s);
			command(s);
		} else if (input.equals("east")) {
			map.play(input, this, s);
			command(s);
		} else if (input.equals("drop")) {
			System.out.println("What item do you wish to drop?");
			String i = s.nextLine().toLowerCase();
			removeItemFromInventory(i);
			map.dropItem(i);
			command(s);
		} else if (input.equals("grab")) {
			map.pickUpItem(this);
			command(s);
		} else if (input.equals("inv")) {
			displayInventory();
			command(s);
		} else if (input.equals("ls")) {
			listStats();
			command(s);
		} else {
			System.out.println("Invalid command.");
			command(s);
		}
	}
		
	}

	// INVENTORY

	public void addItemToInventory(String item) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null) {
				inventory[i] = item;
				System.out.println(item + " added to inventory.");
				return;
			}
		}
		System.out.println("Inventory is full.");
	}

	public void removeItemFromInventory(String item) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null && inventory[i].equals(item)) {
				inventory[i] = null;
				for (int j = i+1; j < inventory.length; j++) {
					inventory[j-1] = inventory[j];
					inventory[j] = null;
				}
				System.out.println(item + " dropped from inventory.");
				return;
			}
		}
		System.out.println(item + " not found in inventory.");
	}

	public void displayInventory() {
		System.out.println("Inventory:");
		for (String item : inventory) {
			if (item != null) {
				System.out.println("- " + item);
			}
		}
	}

	public void useItem (Scanner s) {

	}
}
