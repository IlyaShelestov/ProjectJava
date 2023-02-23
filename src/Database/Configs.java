package Database;

public interface Configs {
    String HOST = "localhost";
    String PORT = "5432";
    String USER = "postgres";
    String PASS = "123321";
    String DBNAME = "postgres";
    String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DBNAME;
}
