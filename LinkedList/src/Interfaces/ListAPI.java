package Interfaces;

public interface ListAPI<KeyedItemAPI> {
	/**
	 * Inserts item into list.
	 * @param toInsert The item to insert.
	 */
	public void insert(KeyedItemAPI toInsert);
	/**
	 * Removes item from list.
	 * @return Deleted Item.
	 */
	public KeyedItemAPI remove(String key);
	/**
	 * Searches for the item with the given key and displays it on the screen.
	 * @param key The key to search for.
	 */
	public void find(String key);
	/**
	 * Calls the update method in item associated with the given key
	 * @param key The given key
	 */
	public void update(String key);
	/**
	 * Displays the items in order from least to greatest
	 */
	public void display();
}
