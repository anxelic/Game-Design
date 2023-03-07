package com.company;

public abstract class Player 
{
	
	private Player _classes;
	
	protected Player(Player classes)
	{
		_classes = classes;
	}
	
	public abstract boolean strength();
	{}
	
	public abstract boolean agility();
	{}
	
	public abstract boolean charisma();
	{}
	
	public abstract boolean intelligence();
	{}
	
}
