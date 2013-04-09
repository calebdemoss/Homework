import java.util.Scanner;


public class Driver {

	public static void main(String[] args){
		List list = new List();
		list.insert(new Item("Caleb"));
		list.insert(new Item("Adam"));
		list.insert(new Item("Doug"));
		list.insert(new Item("Zack"));
		list.insert(new Item("Rowland"));
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		int command = 0;
		
		while(!quit){
			System.out.println("1-Insert\t2-Remove\t3-Update\t4-Find\t5-Display\t6-Quit");
			try{
				command = keyboard.nextInt();
			} catch(java.util.InputMismatchException ime){
				System.out.println("Wrong input, please enter 1-6");
			}
			keyboard.nextLine();
			switch(command){
			case 1: 
				System.out.println("Specify key name: ");
				String key = keyboard.nextLine();
				Item toAdd = new Item(key);
				toAdd.changeFields();
				list.insert(toAdd);
				break;
			case 2:
				System.out.println("Specify key of item to remove: ");
				String toRemove = keyboard.nextLine();
				Item removed = (Item) list.remove(toRemove);
				if(removed != null)
					System.out.println("Removed "+removed.getKey());
				break;
			case 3:
				System.out.println("Specify key of item to update: ");
				String update = keyboard.nextLine();
				list.update(update);
				break;
			case 4:
				System.out.println("Specify key of item to find: ");
				String find = keyboard.nextLine();
				list.find(find);
				break;
			case 5:
				list.display();
				break;
			case 6:
				quit = true;
				break;
			}
			System.out.println();
		}
	}
}
