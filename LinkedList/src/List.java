import Interfaces.KeyedItemAPI;
import Interfaces.ListAPI;


public class List implements ListAPI<KeyedItemAPI> {
	/**
	 * The head node
	 */
	private Node<KeyedItemAPI> head;
	/**
	 * Used primarily for remove
	 */
	private Node<KeyedItemAPI> parent;
	
	public List(){
		head = null;
		parent = null;
	}
	
	@Override
	public void insert(KeyedItemAPI toInsert) {
		if(head == null){
			head = new Node<KeyedItemAPI>(toInsert, null);
			return;
		}
		if(head.getItem().compareTo(toInsert) > 0){
			Node<KeyedItemAPI> temp = head;
			head = new Node<KeyedItemAPI>(toInsert, temp);
			return;
		}
		else{
			Node<KeyedItemAPI> place = new Node<KeyedItemAPI>(null, null);
			for(Node<KeyedItemAPI> current = head; current.getNext() != null; current = current.getNext()){
				KeyedItemAPI item = current.getNext().getItem();
				if(item.compareTo(toInsert) == 0 || head.getItem().compareTo(toInsert) == 0){
					System.out.println("Item already exists!");
					return;
				}
				//need to insert item before current
				if(item.compareTo(toInsert) > 0 && current.getNext() != null){
					current.setNext(new Node<KeyedItemAPI>(toInsert, current.getNext()));
					return;
				}		
				//at the end of the list
				if(current.getNext().getNext() == null)
					place = current.getNext();
			}
			place.setNext(new Node<KeyedItemAPI>(toInsert, null));
		}
	}
	@Override
	public KeyedItemAPI remove(String key) {
		if(head == null)
			return null;
		Node<KeyedItemAPI> toRemove = findHelper(key);
		//need to remove the head node
		if(parent == head){
			head = head.getNext();
			parent = head;
			toRemove.setNext(null);
			return toRemove.getItem();
		}
		else{
			//the item wasn't found
			if(toRemove == null)
				return null;
			parent.setNext(toRemove.getNext());
			toRemove.setNext(null);
			return toRemove.getItem();
		}
	}
	@Override
	public void find(String key){
		Node<KeyedItemAPI> found = findHelper(key);
		if(found != null)
			found.getItem().display();
	}

	public Node<KeyedItemAPI> findHelper(String key) {
		parent = head;
		for(Node<KeyedItemAPI> current = head; current != null; current = current.getNext())
			if(key.compareTo(current.getItem().getKey()) == 0)
				return current;
			else
				parent = current;
		System.out.println("Item not found");
		return null;
	}

	@Override
	public void update(String key) {
		Node<KeyedItemAPI> update = findHelper(key);
		if(update == null)
			return;
		update.getItem().update();
	}

	@Override
	public void display() {
		for(Node<KeyedItemAPI> current = head; current != null; current = current.getNext())
			current.getItem().display();
	}
	
	private class Node<KeyedItemAPI> {
		
		private KeyedItemAPI item;
		
		private Node<KeyedItemAPI> next;
		
		public Node(KeyedItemAPI item, Node<KeyedItemAPI> next){
			this.item = item;
			this.next = next;
		}
		
		public KeyedItemAPI getItem(){
			return item;
		}
		public Node<KeyedItemAPI> getNext(){
			return next;
		}
		public void setNext(Node<KeyedItemAPI> next){
			this.next = next;
		}
	}

}
