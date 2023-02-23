package Database;

import Items.Device;
import Items.PCandLaptops.Laptops.Acer.Extensa15;
import Items.PCandLaptops.Laptops.Acer.Nitro5;
import Items.PCandLaptops.Laptops.Acer.Swift3;
import Items.PCandLaptops.Laptops.Apple.MacBook14;
import Items.PCandLaptops.Laptops.Apple.MacBookAir;
import Items.PCandLaptops.Laptops.HP.Pavilion;
import Items.PCandLaptops.Laptops.HP.VictusGaming15;
import Items.PCandLaptops.Laptops.Lenovo.IdeaPadGaming3i;
import Items.PCandLaptops.Laptops.Lenovo.YogaC940;
import Items.PCandLaptops.PC.HyperPC.Cyber;
import Items.PCandLaptops.PC.HyperPC.Genesis;
import Items.PCandLaptops.PC.LightFlightPC.Newbie;
import Items.PCandLaptops.PC.LightFlightPC.Ultimate;
import Items.PhonesAndGadgets.Gadgets.FitnessBracelet.AmazonGadgets.M3;
import Items.PhonesAndGadgets.Gadgets.FitnessBracelet.AmazonGadgets.M4;
import Items.PhonesAndGadgets.Gadgets.FitnessBracelet.HuaweiGudgets.Band4;
import Items.PhonesAndGadgets.Gadgets.FitnessBracelet.HuaweiGudgets.Band7;
import Items.PhonesAndGadgets.Gadgets.SmartWatch.AppleGadgets.Series7;
import Items.PhonesAndGadgets.Gadgets.SmartWatch.AppleGadgets.Series8;
import Items.PhonesAndGadgets.Gadgets.SmartWatch.SamsungGadgets.GalaxyWatch4;
import Items.PhonesAndGadgets.Gadgets.SmartWatch.SamsungGadgets.GalaxyWatch5;
import Items.PhonesAndGadgets.Phones.MobilePhones.Nokia.n3310;
import Items.PhonesAndGadgets.Phones.MobilePhones.Nokia.n8210;
import Items.PhonesAndGadgets.Phones.MobilePhones.Panasonic.EB_A102;
import Items.PhonesAndGadgets.Phones.MobilePhones.Panasonic.GD55;
import Items.PhonesAndGadgets.Phones.SmartPhones.ApplePhones.iPhone13;
import Items.PhonesAndGadgets.Phones.SmartPhones.ApplePhones.iPhoneX;
import Items.PhonesAndGadgets.Phones.SmartPhones.SamsungPhones.GalaxyOne;
import Items.PhonesAndGadgets.Phones.SmartPhones.SamsungPhones.GalaxyS22;
import Items.PhonesAndGadgets.Tablets.AppleTablets.iPadMini;
import Items.PhonesAndGadgets.Tablets.AppleTablets.iPadPro;
import Items.PhonesAndGadgets.Tablets.SamsungTablets.GalaxyTabA8;
import Items.PhonesAndGadgets.Tablets.SamsungTablets.GalaxyTabS7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemHandler extends DBhandler {
    public void updateItems(ArrayList<Device> items) throws SQLException {
        items.clear();
        Connection connection = getConnection();
        String updateItems = "SELECT * FROM " + itemsTable + ";";
        PreparedStatement preparedStatement = connection.prepareStatement(updateItems);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Device device;
            String model = resultSet.getString(5);
            double price = resultSet.getInt(6);
            String brand = resultSet.getString(4);
            switch (resultSet.getString("model")) {
                case "Watch Series 8" -> device = new Series8(model, price, brand);
                case "Watch Series 7" -> device = new Series7(model, price, brand);
                case "Genesis" -> device = new Genesis(model, price, brand);
                case "Cyber" -> device = new Cyber(model, price, brand);
                case "Newbie" -> device = new Newbie(model, price, brand);
                case "Ultimate" -> device = new Ultimate(model, price, brand);
                case "Nitro 5" -> device = new Nitro5(model, price, brand);
                case "Extensa 15" -> device = new Extensa15(model, price, brand);
                case "Swift 3" -> device = new Swift3(model, price, brand);
                case "Pavilion" -> device = new Pavilion(model, price, brand);
                case "Victus Gaming 15" -> device = new VictusGaming15(model, price, brand);
                case "Yoga C940" -> device = new YogaC940(model, price, brand);
                case "IdeaPad Gaming 3i" -> device = new IdeaPadGaming3i(model, price, brand);
                case "Macbook 14" -> device = new MacBook14(model, price, brand);
                case "Macbook Air" -> device = new MacBookAir(model, price, brand);
                case "GalaxyTab S7" -> device = new GalaxyTabS7(model, price, brand);
                case "GalaxyTab A8" -> device = new GalaxyTabA8(model, price, brand);
                case "iPad Mini" -> device = new iPadMini(model, price, brand);
                case "iPad Pro" -> device = new iPadPro(model, price, brand);
                case "EB-A102" -> device = new EB_A102(model, price, brand);
                case "GD55" -> device = new GD55(model, price, brand);
                case "3310" -> device = new n3310(model, price, brand);
                case "8210" -> device = new n8210(model, price, brand);
                case "iPhone 13" -> device = new iPhone13(model, price, brand);
                case "iPhone X" -> device = new iPhoneX(model, price, brand);
                case "Galaxy S22" -> device = new GalaxyS22(model, price, brand);
                case "Galaxy One" -> device = new GalaxyOne(model, price, brand);
                case "Band 7" -> device = new Band7(model, price, brand);
                case "Band 4" -> device = new Band4(model, price, brand);
                case "M3" -> device = new M3(model, price, brand);
                case "M4" -> device = new M4(model, price, brand);
                case "Galaxy Watch 4" -> device = new GalaxyWatch4(model, price, brand);
                case "Galaxy Watch 5" -> device = new GalaxyWatch5(model, price, brand);
                default -> throw new IllegalStateException("Unexpected value at id: " + resultSet.getInt(1));
            }
            items.add(device);
        }
        connection.close();
    }

    public void deleteItem(int id) throws SQLException {
        Connection connection = getConnection();
        String deleteItem = "DELETE FROM " + itemsTable + " WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteItem);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        connection.close();
    }


    public void addItem(String generalCategory, String category, String subcategory, String brand, String model, double price) throws SQLException {
        Connection connection = getConnection();
        String addItem = "INSERT INTO " + itemsTable + " (general_category, category, subcategory, brand, model, price) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(addItem);
        preparedStatement.setString(1, generalCategory);
        preparedStatement.setString(2, category);
        preparedStatement.setString(3, subcategory);
        preparedStatement.setString(4, brand);
        preparedStatement.setString(5, model);
        preparedStatement.setDouble(6, price);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void listOfItems() throws SQLException {
        Connection connection = getConnection();
        String listOfItems = "SELECT * FROM " + itemsTable + "WHERE belongs_to is null ORDER BY id;";
        PreparedStatement preparedStatement = connection.prepareStatement(listOfItems);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String generalCategory = resultSet.getString("general_category");
            String category = resultSet.getString("category");
            String subcategory = resultSet.getString("subcategory");
            String brand = resultSet.getString("brand");
            String model = resultSet.getString("model");
            double price = resultSet.getDouble("price");
            System.out.println("Id: " + id + "; General category: " + generalCategory + "; Category: " + category + "; Subcategory: " + subcategory + "; Brand: " + brand + "; Model: " + model + "; Price: " + price);
        }
        connection.close();
    }

    public boolean idIsExist(int id) throws SQLException {
        Connection connection = getConnection();
        String idIsExist = "SELECT * FROM " + itemsTable + " WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(idIsExist);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean returnValue = resultSet.next();
        connection.close();
        return returnValue;
    }

    public void searchItem(String category) throws SQLException {
        Connection connection = getConnection();
        String searchItem = "SELECT * FROM " + itemsTable + " WHERE category = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(searchItem);
        preparedStatement.setString(1, category);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String generalCategory = resultSet.getString("general_category");
            String category2 = resultSet.getString("category");
            String subcategory = resultSet.getString("subcategory");
            String model = resultSet.getString("model");
            double price = resultSet.getDouble("price");
            String brand = resultSet.getString("brand");
            System.out.println("Id: " + id + "; General category: " + generalCategory + "; Category: " + category2 + "; Subcategory: " + subcategory + "; Brand: " + brand + "; Model: " + model + "; Price: " + price);
        }
        connection.close();
    }

    public void addToCart(int id, String login) throws SQLException {
        Connection connection = getConnection();
        String addToCart = "UPDATE " + itemsTable + " SET belongs_to = ? WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(addToCart);
        preparedStatement.setString(1, login);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void deleteFromCart(int id) throws SQLException {
        Connection connection = getConnection();
        String deleteFromCart = "UPDATE " + itemsTable + " SET belongs_to = NULL WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteFromCart);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void buyItems(String login) throws SQLException {
        Connection connection = getConnection();
        String buyItems = "DELETE FROM " + itemsTable + " WHERE belongs_to = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(buyItems);
        preparedStatement.setString(1, login);
        preparedStatement.executeUpdate();
        connection.close();
    }

    public double checkPriceOfItemsInCart(String login) throws SQLException {
        Connection connection = getConnection();
        String checkPriceOfItemsInCart = "SELECT price FROM " + itemsTable + " WHERE belongs_to = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(checkPriceOfItemsInCart);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        double sum = 0;
        while (resultSet.next()) {
            sum += resultSet.getDouble("price");
        }
        connection.close();
        return sum;
    }

    public void listOfCart(String login) throws SQLException {
        Connection connection = getConnection();
        String listOfItems = "SELECT * FROM " + itemsTable + "WHERE belongs_to = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(listOfItems);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String generalCategory = resultSet.getString("general_category");
            String category = resultSet.getString("category");
            String subcategory = resultSet.getString("subcategory");
            String model = resultSet.getString("model");
            double price = resultSet.getDouble("price");
            String brand = resultSet.getString("brand");
            System.out.println("Id: " + id + "; General category: " + generalCategory + "; Category: " + category + "; Subcategory: " + subcategory + "; Brand: " + brand + "; Model: " + model + "; Price: " + price);
        }
        connection.close();
    }

    public void updateCart(ArrayList<Device> cart, String login) throws SQLException {
        cart.clear();
        Connection connection = getConnection();
        String updateCart = "SELECT * FROM " + itemsTable + " WHERE belongs_to = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(updateCart);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Device device;
            String model = resultSet.getString(5);
            double price = resultSet.getInt(6);
            String brand = resultSet.getString(4);
            switch (resultSet.getString("model")) {
                case "Watch Series 8" -> device = new Series8(model, price, brand);
                case "Watch Series 7" -> device = new Series7(model, price, brand);
                case "Genesis" -> device = new Genesis(model, price, brand);
                case "Cyber" -> device = new Cyber(model, price, brand);
                case "Newbie" -> device = new Newbie(model, price, brand);
                case "Ultimate" -> device = new Ultimate(model, price, brand);
                case "Nitro 5" -> device = new Nitro5(model, price, brand);
                case "Extensa 15" -> device = new Extensa15(model, price, brand);
                case "Swift 3" -> device = new Swift3(model, price, brand);
                case "Pavilion" -> device = new Pavilion(model, price, brand);
                case "Victus Gaming 15" -> device = new VictusGaming15(model, price, brand);
                case "Yoga C940" -> device = new YogaC940(model, price, brand);
                case "IdeaPad Gaming 3i" -> device = new IdeaPadGaming3i(model, price, brand);
                case "Macbook 14" -> device = new MacBook14(model, price, brand);
                case "Macbook Air" -> device = new MacBookAir(model, price, brand);
                case "GalaxyTab S7" -> device = new GalaxyTabS7(model, price, brand);
                case "GalaxyTab A8" -> device = new GalaxyTabA8(model, price, brand);
                case "iPad Mini" -> device = new iPadMini(model, price, brand);
                case "iPad Pro" -> device = new iPadPro(model, price, brand);
                case "EB-A102" -> device = new EB_A102(model, price, brand);
                case "GD55" -> device = new GD55(model, price, brand);
                case "3310" -> device = new n3310(model, price, brand);
                case "8210" -> device = new n8210(model, price, brand);
                case "iPhone 13" -> device = new iPhone13(model, price, brand);
                case "iPhone X" -> device = new iPhoneX(model, price, brand);
                case "Galaxy S22" -> device = new GalaxyS22(model, price, brand);
                case "Galaxy One" -> device = new GalaxyOne(model, price, brand);
                case "Band 7" -> device = new Band7(model, price, brand);
                case "Band 4" -> device = new Band4(model, price, brand);
                case "M3" -> device = new M3(model, price, brand);
                case "M4" -> device = new M4(model, price, brand);
                case "Galaxy Watch 4" -> device = new GalaxyWatch4(model, price, brand);
                case "Galaxy Watch 5" -> device = new GalaxyWatch5(model, price, brand);
                default -> throw new IllegalStateException("Unexpected value at id: " + resultSet.getInt(1));
            }
            cart.add(device);
        }
        connection.close();
    }
}
