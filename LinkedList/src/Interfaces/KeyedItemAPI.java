package Interfaces;

public interface KeyedItemAPI {
	/**
	 * Get the key of the keyed item.
	 * @return The Key
	 */
	public String getKey();
	/**
	 * Displays current information of the item and allows user to 
	 * change fields if so desired.
	 */
	public void update();
	/**
	 * Compares items based on the keys
	 */
	public int compareTo(KeyedItemAPI other);
	/**
	 * Displays information on the screen about the item
	 */
	public void display();
	
	
}
