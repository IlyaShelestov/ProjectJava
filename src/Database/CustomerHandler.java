package Database;

import Persons.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerHandler extends DBhandler {

    public void updateCustomers(ArrayList<Customer> customers) throws SQLException {
        customers.clear();
        Connection connection = getConnection();
        String updateCustomers = "SELECT * FROM " + customersTable + ";";
        PreparedStatement preparedStatement = connection.prepareStatement(updateCustomers);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            customers.add(new Customer(resultSet.getString(3), resultSet.getString(4), resultSet.getString(1), resultSet.getString(2), resultSet.getDouble(5)));
        }
        connection.close();
    }

    public void addCustomer(String login, String password, String firstName, String secondName, double balance) throws SQLException {
        Connection connection = getConnection();
        String addCustomer = "INSERT INTO " + customersTable + " (login, password, first_name, second_name, balance) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(addCustomer);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, firstName);
        preparedStatement.setString(4, secondName);
        preparedStatement.setDouble(5, balance);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void deleteCustomer(String login) throws SQLException {
        Connection connection = getConnection();
        String deleteCustomer = "DELETE FROM " + customersTable + " WHERE login = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteCustomer);
        preparedStatement.setString(1, login);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void changeFirstName(String login, String newName) throws SQLException {
        Connection connection = getConnection();
        String changeFirstName = "UPDATE " + customersTable + " SET first_name = ? WHERE login = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(changeFirstName);
        preparedStatement.setString(1, newName);
        preparedStatement.setString(2, login);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void changeSecondName(String login, String newSurname) throws SQLException {
        Connection connection = getConnection();
        String changeFirstName = "UPDATE " + customersTable + " SET second_name = ? WHERE login = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(changeFirstName);
        preparedStatement.setString(1, newSurname);
        preparedStatement.setString(2, login);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void changeLogin(String oldLogin, String newLogin) throws SQLException {
        Connection connection = getConnection();
        String changeFirstName = "UPDATE " + customersTable + " SET login = ? WHERE login = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(changeFirstName);
        preparedStatement.setString(1, newLogin);
        preparedStatement.setString(2, oldLogin);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void changePassword(String login, String newPassword) throws SQLException {
        Connection connection = getConnection();
        String changeFirstName = "UPDATE " + customersTable + " SET password = ? WHERE login = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(changeFirstName);
        preparedStatement.setString(1, newPassword);
        preparedStatement.setString(2, login);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void changeBalance(String login, double newBalance) throws SQLException {
        Connection connection = getConnection();
        String changeFirstName = "UPDATE " + customersTable + " SET balance = ? WHERE login = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(changeFirstName);
        preparedStatement.setDouble(1, newBalance);
        preparedStatement.setString(2, login);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public boolean loginIsExist(String login) throws SQLException {
        Connection connection = getConnection();
        String isExist = "SELECT * FROM " + customersTable + " WHERE login = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(isExist);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean returnValue = resultSet.next();
        connection.close();
        return returnValue;
    }
}
