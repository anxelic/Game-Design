package cis3710;

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
	
	public boolean strength()
	{
		if (strength >= 25)
		{
			System.out.println("You are a Warrior");
			return true;
		}
		return false;
	}
	
	public boolean agility()
	{
		if (agility >= 25)
		{
			System.out.println("You are a Rogue");
			return true;
		}
		return false;
	}
	
	public boolean charisma()
	{
		if (charisma >= 25)
		{
			System.out.println("You are a Face");
			return true;
		}
		return false;
	}
	
	public boolean intelligence()
	{
		if (intelligence >= 25)
		{
			System.out.println("You are a Mage");
			return true;
		}
		return false;
	}

}
