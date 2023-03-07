package com.company;

import java.io.*;
import java.util.Arrays;

public class Player {
	String spec;
	int[] stats = new int[4];
	//strength
	//agility
	//charisma
	//intelligence

	public Player(String s) {
		spec = s;
		stats = statDetermine();
	}

	private int[] statDetermine() {
		int[] stats = new int[4];
		switch (spec) {
			case "warrior":
				stats[0] = 25;
				stats[1] = 7;
				stats[2] = 9;
				stats[3] = 1;
				break;
			case "face":
				stats[0] = 5;
				stats[1] = 3;
				stats[2] = 25;
				stats[3] = 9;
				break;
			case "rogue":
				stats[0] = 9;
				stats[1] = 25;
				stats[2] = 3;
				stats[3] = 5;
				break;
			case "mage":
				stats[0] = 2;
				stats[1] = 8;
				stats[2] = 7;
				stats[3] = 25;
				break;
		}
		return stats;
	}

	public void listStats () {
		System.out.println("Strength: " + stats[0]);
		System.out.println("Agility: " + stats[1]);
		System.out.println("Charisma: " + stats[2]);
		System.out.println("Intelligence: " + stats[3]);
	}

}
