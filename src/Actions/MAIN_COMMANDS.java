package Actions;

import Database.DBhandler;
import Items.Device;
import Persons.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MAIN_COMMANDS {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Device> items = new ArrayList<>();
    ActionsWithCustomers actionsWithCustomers = new ActionsWithCustomers(customers);
    ActionsWithItems actionsWithItems = new ActionsWithItems(items);
    ActionsWithCart actionsWithCart = new ActionsWithCart();
    private String login;

    public MAIN_COMMANDS() throws SQLException {
    }

    public void application() throws SQLException {
        Scanner input = new Scanner(System.in);
        int menu;
        while (true) {
            System.out.println("1 -> Administrator");
            System.out.println("2 -> Customer");
            System.out.println("0 -> Exit");
            menu = input.nextInt();
            switch (menu) {
                case 1 -> verificationForAdministrator();
                case 2 -> verificationForCustomer();
                case 0 -> toExit();
            }
        }
    }

    public void verificationForAdministrator() throws SQLException {
        System.out.println("Enter login:");
        String login = scanner.next().trim();
        System.out.println("Enter password:");
        String password = scanner.next().trim();
        if (DBhandler.isExist(login, password, "\"Administrators\"")) {
            System.out.println("Accessed!");
            adminCommands();
        } else {
            System.out.println("Access failed. Incorrect login or password.");
        }
    }

    public void verificationForCustomer() throws SQLException {
        System.out.println("Enter login:");
        String login = scanner.next().trim();
        System.out.println("Enter password:");
        String password = scanner.next().trim();
        if (DBhandler.isExist(login, password, "\"Customers\"")) {
            System.out.println("Accessed!");
            this.login = login;
            customerCommands();
        } else {
            System.out.println("Access failed. Incorrect login or password.");
        }
    }

    public void toExit() {
        System.out.println("Goodbye.");
        System.exit(0);
    }

    public void adminCommands() throws SQLException {
        boolean working = true;
        while (working) {
            System.out.println("Choose command:");
            System.out.println("1 -> Delete a Customer");
            System.out.println("2 -> Add a Customer");
            System.out.println("3 -> List of Customers");
            System.out.println("4 -> Change the Customer");
            System.out.println("5 -> Delete an Item");
            System.out.println("6 -> Add an Item");
            System.out.println("7 -> List of all Items");
            System.out.println("8 -> Log out");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> actionsWithCustomers.deleteCustomer();
                case 2 -> actionsWithCustomers.addCustomer();
                case 3 -> actionsWithCustomers.listOfCustomers();
                case 4 -> changeCostumer();
                case 5 -> actionsWithItems.deleteItem();
                case 6 -> actionsWithItems.addItem();
                case 7 -> actionsWithItems.listOfItems();
                case 8 -> working = false;
                default -> System.out.println("Unknown command! Try again!");
            }
        }
    }

    public void changeCostumer() throws SQLException {
        System.out.println("What to change?");
        System.out.println("1 -> First Name");
        System.out.println("2 -> Second Name");
        System.out.println("3 -> Login");
        System.out.println("4 -> Password");
        System.out.println("5 -> Balance");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> actionsWithCustomers.changeFirstName();
            case 2 -> actionsWithCustomers.changeSecondName();
            case 3 -> actionsWithCustomers.changeLogin();
            case 4 -> actionsWithCustomers.changePassword();
            case 5 -> actionsWithCustomers.changeBalance();
            default -> System.out.println("Unknown command!");
        }

    }

    public void customerCommands() throws SQLException {
        boolean working = true;
        while (working) {
            System.out.println("Choose command:");
            System.out.println("1 -> View list of available items");
            System.out.println("2 -> Search item by category");
            System.out.println("3 -> Add item to cart");
            System.out.println("4 -> Delete item from cart");
            System.out.println("5 -> Buy items from cart");
            System.out.println("6 -> View list of cart");
            System.out.println("7 -> Log out");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1 -> actionsWithItems.listOfItems();
                case 2 -> actionsWithItems.searchItem();
                case 3 -> actionsWithCart.addToCart(login, customers.get(findCustomer()).getCart());
                case 4 -> actionsWithCart.removeFromCart(login, customers.get(findCustomer()).getCart());
                case 5 -> actionsWithCart.buyItems(login, customers.get(findCustomer()).getCart(), customers.get(findCustomer()).getBalance());
                case 6 -> actionsWithCart.listOfCart(login);
                case 7 -> working = false;
                default -> System.out.println("Unknown command! Try again!");
            }
        }
    }

    public int findCustomer() {
        int index = 0;
        for (Customer c : customers) {
            if (login.equals(c.getLogin())) {
                index = customers.indexOf(c);
            }
        }
        return index;
    }
}