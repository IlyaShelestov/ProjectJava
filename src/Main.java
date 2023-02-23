import Actions.MAIN_COMMANDS;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MAIN_COMMANDS main_commands = new MAIN_COMMANDS();
        main_commands.application();
    }
}