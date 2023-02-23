package Actions;

import Database.CustomerHandler;
import Persons.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ActionsWithCustomers {
    Scanner scanner = new Scanner(System.in);
    CustomerHandler customerHandler = new CustomerHandler();
    ArrayList<Customer> customers;


    public ActionsWithCustomers(ArrayList<Customer> customers) throws SQLException {
        this.customers = customers;
        customerHandler.updateCustomers(customers);
    }

    public void deleteCustomer() throws SQLException {
        System.out.println("Enter customer's login:");
        String login = scanner.next().trim();
        if (customerHandler.loginIsExist(login)) {
            customerHandler.deleteCustomer(login);
            customerHandler.updateCustomers(customers);
            System.out.println("Customer deleted!");
        } else {
            System.out.println("Login does not exist!");
        }
    }

    public void listOfCustomers() throws SQLException {
        customerHandler.updateCustomers(customers);
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(customers.get(i).toString());
        }
    }

    public void addCustomer() throws SQLException {
        System.out.println("Enter new customer's login:");
        String login = scanner.next().trim();
        if (!customerHandler.loginIsExist(login)) {
            System.out.println("Enter name:");
            String firstName = scanner.next().trim();
            System.out.println("Enter surname:");
            String secondName = scanner.next().trim();
            System.out.println("Enter password:");
            String password = scanner.next().trim();
            System.out.println("Enter balance:");
            double balance = scanner.nextDouble();
            customerHandler.addCustomer(login, password, firstName, secondName, balance);
            customerHandler.updateCustomers(customers);
        } else {
            System.out.println("Login already exist!");
        }
    }

    public void changeLogin() throws SQLException {
        System.out.println("Enter customer's login");
        String login = scanner.next().trim();
        System.out.println("Enter customer's new login");
        String newLogin = scanner.next().trim();
        if (customerHandler.loginIsExist(login)) {
            if (!customerHandler.loginIsExist(newLogin)) {
                customerHandler.changeLogin(login, newLogin);
                customerHandler.updateCustomers(customers);
                System.out.println("Login changed!");
            } else {
                System.out.println("Login already exist!");
            }
        } else {
            System.out.println("Login does not exist!");
        }
    }

    public void changePassword() throws SQLException {
        System.out.println("Enter customer's login");
        String login = scanner.next().trim();
        if (customerHandler.loginIsExist(login)) {
            System.out.println("Enter new password:");
            String password = scanner.next().trim();
            customerHandler.changePassword(login, password);
            customerHandler.updateCustomers(customers);
            System.out.println("Password changed!");
        } else {
            System.out.println("Login does not exist!");
        }
    }

    public void changeBalance() throws SQLException {
        System.out.println("Enter customer's login");
        String login = scanner.next().trim();
        if (customerHandler.loginIsExist(login)) {
            System.out.println("Enter new balance:");
            double balance = scanner.nextDouble();
            customerHandler.changeBalance(login, balance);
            customerHandler.updateCustomers(customers);
            System.out.println("Balance changed!");

        } else {
            System.out.println("Login does not exist!");
        }
    }

    public void changeFirstName() throws SQLException {
        System.out.println("Enter customer's login:");
        String login = scanner.next().trim();
        if (customerHandler.loginIsExist(login)) {
            System.out.println("Enter new first name:");
            String firstName = scanner.next().trim();
            customerHandler.changeFirstName(login, firstName);
            customerHandler.updateCustomers(customers);
            System.out.println("First name changed!");

        } else {
            System.out.println("Login does not exist!");
        }

    }

    public void changeSecondName() throws SQLException {
        System.out.println("Enter customer's login:");
        String login = scanner.next().trim();
        if (customerHandler.loginIsExist(login)) {
            System.out.println("Enter new second name:");
            String secondName = scanner.next().trim();
            customerHandler.changeSecondName(login, secondName);
            customerHandler.updateCustomers(customers);
            System.out.println("Second name changed!");

        } else {
            System.out.println("Login does not exist!");
        }

    }


}
