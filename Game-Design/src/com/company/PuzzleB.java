package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PuzzleB {

	private static Scanner s = new Scanner(System.in);
	private static int num = 0;
	private static ArrayList<String> pickupItems = new ArrayList<String>();
	
	public static void main(String[] args, Player p) {
		System.out.println("You have entered a room where you have noticed that there are multiple traps blocking your path to the key.");
		System.out.println("You come across your first obstacle which is spikes on a pit below you.");
		System.out.println("You see a wooden board above that could support you weight if you swing with vines.");
		System.out.println("But there's a big statue that you can probably move to make a bridge across.");
		System.out.println("This gap shouldn't be too far to jump either.");
		System.out.println("Will you use the vines, grab the statue, or try to jump?");
		obstacleOne(p);
	}
	
	public static void obstacleOne(Player p) {
		String ans = s.nextLine().toLowerCase();
		if (ans.equals("use the vines") || ans.equals("use vines") || ans.equals("vines")) {
			p.addItemToInventory("vines");
			System.out.println("You use the vines and hook them onto the wooden board above and swing across the gap.");
			System.out.println("You have passed the first trap and make your way to the second trap.");
			System.out.println();
			System.out.println("There are many items in this room that are on the floor but ahead you see a fairy.");
			System.out.println("She looks at you, 'I have lost something amongst this clutter. Will you find it for me?'");
			System.out.println("Do you wish to intimidate the fairy, sneak up to fairy, convince the fairy to let you pass, find the lost item, or try to leave?");
			obstacleTwo(p);
		} else if (ans.equals("grab the statue") || ans.equals("grab statue") || ans.equals("statue")) {
			if (p.stats[0] > 10) {
				System.out.println("You move the statue to create this bridge and you carefully make your wasy across it.");
				System.out.println("You have passed the first trap and make your way to the second trap.");
				System.out.println();
				System.out.println("There are many items in this room that are on the floor but ahead you see a fairy.");
				System.out.println("She looks at you, 'I have lost something amongst this clutter. Will you find it for me?'");
				System.out.println("Do you wish to intimidate the fairy, sneak up to fairy, convince the fairy to let you pass, find the lost item, or try to leave?");
				obstacleTwo(p);
			} else {
				System.out.println("You tried to move the statue but noticed that you weren't strong enough.");
				System.out.println("You threw your back out trying to move the statue and notice you can't move anymore.");
				System.out.println();
				main(null, p);
			}
		} else if (ans.equals("try to jump") || ans.equals("jump")) {
			if(p.stats[1] > 10) {
				System.out.println("You get a running start and jump across the entire gap of spikes.");
				System.out.println("You have passed the first trap and make your way to the second trap.");
				System.out.println();
				System.out.println("There are many items in this room that are on the floor but ahead you see a fairy.");
				System.out.println("She looks at you, 'I have lost something amongst this clutter. Will you find it for me?'");
				System.out.println("Do you wish to intimidate the fairy, sneak up to fairy, convince the fairy to let you pass, find the lost item, or try to leave?");
				obstacleTwo(p);
			} else {
				System.out.println("With your running start, you end up tripping and falling into the gap with spikes.");
				System.out.println();
				main(null, p);
			}
		} else {
			System.out.println("Invalid input. Try again?");
			obstacleOne(p);
		}
	}

	public static void obstacleTwo(Player p) {
        pickupItems.add("rope");
        pickupItems.add("axe");
        pickupItems.add("potion_of_levitation");
        pickupItems.add("potion_of_flight");
        pickupItems.add("rusty_butterknife");
        pickupItems.add("apple");
		String ans;
		if (num == 0) {
			ans = s.nextLine().toLowerCase();
		} else {
			ans = "find";
		} if (ans.equals("find") || ans.equals("find item") || ans.equals("find lost item") || ans.equals("find the lost item")) {
            System.out.println("You begin to rummage through the clutter.");
            boolean apple = false;
            while (apple == false) {
                int x = (int)(pickupItems.size() * Math.random());
                System.out.println("You rummage around and pick up a " + pickupItems.get(x) + ".");
                System.out.println("Do you want to show this item to the fairy? Or do you wish to hold onto it. (Show, hold, neither)");
                String ok = s.nextLine().toLowerCase();
                if (ok.equals("show item") || ok.equals("show fairy") || ok.equals("show fairy the item") || ok.equals("show the item to the fairy") || ok.equals("show item fairy") || ok.equals("show") || ok.equals("yes")) {
                    if (pickupItems.get(x).equals("apple")) {
                        System.out.println("An apple! That is exactly what I was looking for!");
                        apple = true;
                    } else {
                        System.out.println("The fairy looks at the item. 'This is not the item I want!");
                    }
                } else if (ok.equals("hold") || ok.equals("hold onto") || ok.equals("take") || ok.equals("take item") || ok.equals("keep") || ok.equals("keep item")) {
                    if (pickupItems.get(x).equals("apple")) {
                        System.out.println("The fairy notices what you're putting in your backpack. 'That is it! That is my item' they come over and take it from you.");
                        apple = true;
                    } else {
                        p.addItemToInventory(pickupItems.get(x));
                        pickupItems.remove(x);
                    }
                } else if (ok.equals("no") || ok.equals("none") || ok.equals("neither")) {
                    System.out.println("You leave it on the ground.");
                } else {
                    System.out.println("Invalid.");
                }
            }
            System.err.println();
            System.out.println("'Go on ahead!' exclaims the fairy.");
            obstacleThree(p);
		} else if (ans.equals("intimidate") || ans.equals("intimidate fairy") || ans.equals("intimidate the fairy")) {
			if (p.stats[0] > 10) {
				System.out.println("'Let me through or you will die,' you say to the fairy.");
				System.out.println("This scares the fairy and you gain entrance to the next obstacle.");
                obstacleThree(p);
			} else {
                num = 1;
                System.out.println("'Let me through or you will die,' you say to the fairy.");
                System.out.println("'You are not scary in the bit.' The fairy then demands you to retrieve an item for them.");
                obstacleTwo(p);
            }
		} else if (ans.equals("sneak") || ans.equals("sneak to fairy") || ans.equals("sneak up to fairy")) {
            if (p.stats[1] > 10) {
                System.out.println("You sneak up to the fairy and hear its stomach growling. You decide to help look for food for the fairy.");
                num = 1;
                obstacleTwo(p);
            } else {
                System.out.println("The fairy spots you and yells towards you. 'I demand for you to find me my lost item amoung this clutter.");
                num = 1;
                obstacleTwo(p);
            }
		} else if (ans.equals("convince") || ans.equals("convince fairy") || ans.equals("convince the fairy") || ans.equals("convince the fairy to let you pass")) {
			if (p.stats[2] > 10) {
                System.out.println("You talk to the fairy, to convince them to tell you the item that they want.");
                System.out.println("'I would am looking to get an apple from this clutter.' says the fairy.");
                num = 1;
                obstacleTwo(p);
            } else {
                System.out.println("'Not too good with words I see.' says the fairy, 'Not going to work.'");
                num = 1;
                obstacleTwo(p);
            }
		} else if (ans.equals("leave") || ans.equals("try to leave")) {
			System.out.println("You refuse to play along with the fairy, and leave. Despite leaving, every turn you take brings you back to them.");
            if (p.stats[3] > 10) {
                System.out.println("You realize you are within an illusion, and break the spell. You continue onward.");
                obstacleThree(p);
            } else {
                System.out.println("You sense a faint trace of mana coming from the axe and the apple. Maybe one is the item the fairy desires.");
                num = 1;
                obstacleTwo(p);
            }
		} else {
			System.out.println("Invalid input. Try again?");
			obstacleTwo(p);
		}
	}

	public static void noItems (Player p) {
		System.out.println("You go back into the fairy room, there are less items than before and the fairy is gone.");
		System.out.println("You see a rusty butter knife. Do you want to take it?");
		String x = s.nextLine().toLowerCase();
		if (x.equals("yes")) {
			p.addItemToInventory("rusty_butterknife");
			pickupItems.remove("rusty_butterknife");
			obstacleThree(p);
		} else if (x.equals("no")) {
			System.out.println("You decide to not take the item... for some reason.");
			obstacleThree(p);
		} else {
			System.out.println("Invalid response.");
			noItems(p);
		}
	}

	// pickupItems.add("rope");
    //     pickupItems.add("axe");
    //     pickupItems.add("potion_of_levitation");
    //     pickupItems.add("potion_of_flight");
    //     pickupItems.add("rusty_butterknife");
    //     pickupItems.add("apple");
	
	public static void obstacleThree(Player p) {
		boolean rope = false;
		boolean vine = false;
		for (int i = 0; i < p.inventory.length; i++) {
			if (p.inventory[i] == (null)) {
				break;
			}
			if (p.inventory[i].equals("vine") ) {
				vine = true;
			} else if (p.inventory[i].equals("rope")) {
				rope = true;
			} else {}
		}
		System.out.println("You see a key at the top of a spire.");
		if (pickupItems.size() == 6) {
			System.out.println("You are unable to reach the key.. Maybe there was something before that could help.");
			System.out.println("Do you want to go back?");
			String x = s.nextLine().toLowerCase();
			if (x.equals("yes")) {
				noItems(p);
			} else if (x.equals("no")) {
			} else {
				System.out.println("Invalid.");
				obstacleThree(p);
			}
		}
		if (p.stats[0] >= 10) {
			System.out.println("You take your body weight, and slam into the spire. The key falls off the top, and you pick it up.");
			p.addItemToInventory("green_key");
		} else if (p.stats[1] >= 10) {
			System.out.println("You scale the spire, and grab the key.");
			p.addItemToInventory("green_key");
		} else if (!pickupItems.contains("potion_of_levitation") && p.stats[3] >= 10) {
			System.out.println("You remember that you had a potion of levitation. Using your high intelligence, you use a levitation spell and aquire the key.");
			p.addItemToInventory("green_key");
		} else if (rope == true) {
			System.out.println("You see an anchor point at the top of the spire, and throw your rope onto it. Allowing you to climb up and get the key.");
			p.addItemToInventory("green_key");
		} else if (vine == true) {
			System.out.println("You see an anchor point at the top of the spire, and throw your vine onto it. Allowing you to climb up and get the key.");
			p.addItemToInventory("green_key");
		} else if (!pickupItems.contains("potion_of_flight")) {
			System.out.println("You use your potion of flight and fly up to get the key.");
			p.addItemToInventory("green_key");
		} else if (!pickupItems.contains("rusty_butterknife")) {
			System.out.println("You take the butter knife it and throw it at the spire! The key falls down, but you lost the item to the void.");
			p.removeItemFromInventory("rusty_butterknife");
			p.addItemToInventory("green_key");
		}
	}
}