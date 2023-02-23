package Persons;

import Items.Device;

import java.util.ArrayList;

public class Customer extends Person {
    private final double balance;
    private final ArrayList<Device> cart = new ArrayList<>();

    public Customer(String firstName, String secondName, String login, String password, double balance) {
        super(firstName, secondName, login, password);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String toString() {
        return String.format("Name: %-10s Second Name: %-10s Login: %-15s Password: %-10s Balance %-10s", getFirstName(), getSecondName(), getLogin(), getPassword(), getBalance());
    }

    public ArrayList<Device> getCart() {
        return cart;
    }
}
