import java.util.Scanner;

import Interfaces.KeyedItemAPI;


public class Item implements KeyedItemAPI {
	/**
	 * The key of the item
	 */
	private String key;
	/**
	 * First field
	 */
	private String field1;
	/**
	 * Second field
	 */
	private String field2;
	/**
	 * Used to parse info from the user
	 */
	private Scanner keyboard;

	public Item(String key){
		this.key = key;
		keyboard = new Scanner(System.in);
	}
	
	
	@Override
	public String getKey() {
		return key;
	}

	@Override
	public void update() {
		display();
		System.out.println("If you want to change the fields type \"yes\" otherwise type \"no\"");
		String command = keyboard.nextLine();
		if(command.equalsIgnoreCase("yes"))
			changeFields();
		else
			return;
	}

	public void changeFields() {
		System.out.println("Enter Field 1: ");
		field1 = keyboard.nextLine();
		System.out.println("Enter Field 2: ");
		field2 = keyboard.nextLine();
	}

	public int compareTo(KeyedItemAPI other) {
		return key.compareTo(other.getKey());
	}

	@Override
	public void display() {
		System.out.println("Key: "+key+"\nField 1: "+field1+"\n Field 2: "+field2);
	}
	
	
}
