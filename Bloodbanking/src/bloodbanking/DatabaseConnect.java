package bloodbanking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseConnect {
    private final String url = "jdbc:mysql://localhost:3306/bloodbank";
    private final String username = "root";
    private final String password = "";

    public Connection con;
    public ResultSet result;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected Successfully");
        } catch (Exception e) {
            System.err.println("Failed to Connect");
            e.printStackTrace();
        }
    }
}
