package Actions;

import Database.ItemHandler;
import Items.Device;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ActionsWithItems {
    Scanner scanner = new Scanner(System.in);
    ItemHandler itemHandler = new ItemHandler();
    ArrayList<Device> items;

    public ActionsWithItems(ArrayList<Device> items) throws SQLException {
        this.items = items;
        itemHandler.updateItems(items);
    }

    public void deleteItem() throws SQLException {
        System.out.println("Enter device's id:");
        int id = scanner.nextInt();
        if (itemHandler.idIsExist(id)) {
            itemHandler.deleteItem(id);
            itemHandler.updateItems(items);
            System.out.println("Device deleted!");
        } else {
            System.out.println("Device with that id does not exist!");
        }
    }

    public void listOfItems() throws SQLException {
        itemHandler.listOfItems();
    }

    public void searchItem() throws SQLException {
        System.out.println("Enter category of item: \n 1 - Gadget \n 2 - Laptop \n 3 - PC, \n 4 - Phone, \n 5 - Tablet");
        int command = scanner.nextInt();
        switch (command) {
            case 1 -> itemHandler.searchItem("Gadget");
            case 2 -> itemHandler.searchItem("Laptop");
            case 3 -> itemHandler.searchItem("PC");
            case 4 -> itemHandler.searchItem("Phone");
            case 5 -> itemHandler.searchItem("Tablet");
            default -> System.out.println("Unknown command!");
        }
    }

    public void addItem() throws SQLException {
        int command;
        String generalCategory;
        String category;
        String subcategory;
        String brand;
        String model;
        double price;
        System.out.println("Enter general category of device (1 - PCsAndLaptops, 2 - PhonesAndGadgets):");
        command = scanner.nextInt();
        switch (command) {
            case 1 -> generalCategory = "PCsAndLaptops";
            case 2 -> generalCategory = "PhonesAndGadgets";
            default -> {
                System.out.println("Invalid command!");
                return;
            }
        }
        System.out.println("Enter category of device (1 - PC, 2 - Tablet, 3 - Phone, 4 - Laptop, 5- Gadget): ");
        command = scanner.nextInt();
        switch (command) {
            case 1 -> category = "PC";
            case 2 -> category = "Tablet";
            case 3 -> category = "Phone";
            case 4 -> category = "Laptop";
            case 5 -> category = "Gadget";
            default -> {
                System.out.println("Invalid command!");
                return;
            }
        }
        System.out.println("Enter subcategory of device (1 - Tablet, 2 - SmartPhone, 3 - SmartWatch, 4 - PC, 5 - Mobile Phone, 6 - Laptop, 7 - Fitness Braclet): ");
        command = scanner.nextInt();
        switch (command) {
            case 1 -> subcategory = "Tablet";
            case 2 -> subcategory = "SmartPhone";
            case 3 -> subcategory = "SmartWatch";
            case 4 -> subcategory = "PC";
            case 5 -> subcategory = "MobilePhone";
            case 6 -> subcategory = "Laptop";
            case 7 -> subcategory = "FitnessBraclet";
            default -> {
                System.out.println("Invalid command!");
                return;
            }
        }
        System.out.println("Enter brand of device (Write it correctly): ");
        brand = scanner.next().trim();
        System.out.println("Enter model of device (Write it correctly): ");
        model = scanner.next().trim();
        System.out.println("Enter price of device: ");
        price = scanner.nextDouble();
        itemHandler.addItem(generalCategory, category, subcategory, brand, model, price);
        itemHandler.updateItems(items);
        System.out.println("Device added!");
    }
}
