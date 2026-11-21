package DAOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DaoBase {

    protected static String user = "root";
    protected static String pass = "12345678";
    protected static String url = "jdbc:mysql://localhost:3306/lab10_telecom";

    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            throw new SQLException(e);

        }
        return DriverManager.getConnection(url, user, pass);

    }
}
