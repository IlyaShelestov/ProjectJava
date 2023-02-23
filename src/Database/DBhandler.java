package Database;

import java.sql.*;

public class DBhandler implements Configs {
    protected final String customersTable = "\"Customers\"";
    protected final String itemsTable = "\"ItemsList\"";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static boolean isExist(String login, String password, String tableName) throws SQLException {
        Connection connection = getConnection();
        String isExist = "SELECT * FROM " + tableName + " WHERE login = ? AND password = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(isExist);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean returnValue = resultSet.next();
        connection.close();
        return returnValue;
    }
}