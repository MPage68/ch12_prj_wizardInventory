import java.util.HashMap;
import java.util.Map;

public class WizardInvertoryApp {

	private static HashMap<Integer, String> inventory = new HashMap<>();

	public static void main(String[] args) {
		System.out.println("The Wizard Invetroy game");
		populateInitialInventory();		

		String command = "";
		while (!command.equalsIgnoreCase("exit")) {
			displayMenuItems();
		}
			command = Console.getString("Command:  ");
			if (command.equalsIgnoreCase("show")) {
				showInventoryItems();
			} else if (command.equalsIgnoreCase("grab")) {
				String newItem = Console.getString("new item");
				System.out.println(addInventoryItem(newItem));

			} else if (command.equalsIgnoreCase("edit")) {
				int itemNumber = Console.getInt("Item Number");
				System.out.println(editInventoryItem(itemNumber));

			} else if (command.equalsIgnoreCase("drop")) {

			} else if (command.equalsIgnoreCase("menu")) {

			} else if (command.equalsIgnoreCase("exit")) {
				System.out.println("Invalid command!  Try again.");
			}

		}
	}

	public static void displayMenuItems() {
		System.out.println("COMMAND MENU");
		System.out.println("show - Show all item\r" + "grab - grab an item" + "drop - drop an item" + "nenu");
	}

	public static void populateInitialInventory() {
		inventory.put(1, "wooden staff");
		inventory.put(2, "wizard hat");
		inventory.put(3, "cloth shoes");
	}

	public static void showInventoryItems() {
		for (Map.Entry item : inventory.entrySet()) {
			System.out.println(item.getKey() + "." + item.getValue());
		}

	}

	public static String addInventoryItem(String Item) {
		int itemNumber = inventory.size() + 1;
		inventory.put(itemNumber, Item);
		if (itemNumber > 4) {
			msg = "You can't carry any more items. Drop something first.";
		} 
		else {
			msg = Item + "was added.";
		}
		return msg;
	}
	public static String editInventoryItem(int nbr) {
		String value = inventory.get(nbr);
		System.out.println("Item selected: " + value);
		String newValue = Console.getString("Updated Item Name?");
		inventory.put(nbr, newValue);
		
		return "Item number" + nbr + "was updated.";
	}	
	
	public static String deleteInventoryItem(int, nbr) {
		String removedItemValue = inventory.remove(nbr);
		return removedItemValue + " was dropped.";
}
