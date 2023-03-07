package com.company;

public class Mage extends Player 
{
	
	private int strength;
	private int agility;
	private int charisma;
	private int intelligence;
	
	protected Mage(Player classes)
	{
		super(classes);
		strength = 0;
		agility = 8;
		charisma = 5;
		intelligence = 25;
	}
	
	@Override
	public final boolean strength()
	{
		if (strength >= 25)
		{
			System.out.println("You are a Warrior");
			return true;
		}
		return false;
	}
	
	@Override
	public final boolean agility()
	{
		if (agility >= 25)
		{
			System.out.println("You are a Rogue");
			return true;
		}
		return false;
	}
	
	@Override
	public final boolean charisma()
	{
		if (charisma >= 25)
		{
			System.out.println("You are a Face");
			return true;
		}
		return false;
	}
	
	@Override
	public final boolean intelligence()
	{
		if (intelligence >= 25)
		{
			System.out.println("You are a Mage");
			return true;
		}
		return false;
	}

}
