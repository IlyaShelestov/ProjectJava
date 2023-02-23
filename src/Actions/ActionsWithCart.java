package Actions;

import Database.CustomerHandler;
import Database.ItemHandler;
import Items.Device;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ActionsWithCart {
    ItemHandler itemHandler = new ItemHandler();
    Scanner scanner = new Scanner(System.in);

    public void addToCart(String login, ArrayList<Device> cart) throws SQLException {
        System.out.println("Enter ID of Device:");
        int id = scanner.nextInt();
        if (itemHandler.idIsExist(id)) {
            itemHandler.addToCart(id, login);
            itemHandler.updateCart(cart, login);
            System.out.println("Device added!");
        } else {
            System.out.println("Device with that ID does not exist!");
        }
    }

    public void removeFromCart(String login, ArrayList<Device> cart) throws SQLException {
        System.out.println("Enter ID of Device:");
        int id = scanner.nextInt();
        if (itemHandler.idIsExist(id)) {
            itemHandler.deleteFromCart(id);
            itemHandler.updateCart(cart, login);
            System.out.println("Device removed!");
        } else {
            System.out.println("Device with that ID does not exist!");
        }
    }

    public void buyItems(String login, ArrayList<Device> cart, double balance) throws SQLException {
        System.out.println("Are you sure ? 1 - Yes, 2 - No");
        int answer = scanner.nextInt();
        if (answer == 1) {
            double priceOfItems = itemHandler.checkPriceOfItemsInCart(login);
            if (priceOfItems <= balance) {
                CustomerHandler customerHandler = new CustomerHandler();
                customerHandler.changeBalance(login, balance - priceOfItems);
                itemHandler.buyItems(login);
                itemHandler.updateCart(cart, login);
            } else {
                System.out.println("You do not have enough money for that.");
            }
        } else if (answer == 2) {
            System.out.println("Declined.");
        } else {
            System.out.println("Unknown command!");
        }
    }

    public void listOfCart(String login) throws SQLException {
        itemHandler.listOfCart(login);
    }
}
