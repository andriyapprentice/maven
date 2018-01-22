package ua.com.owu.connect;

import sun.rmi.transport.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
//import java.sql.Connection;

public class dbConnect {
    private String url = "jdbc:mysql://localhost/db2030";
    private String username = "root";
    private String pass = "root";

    java.sql.Connection connection;

    public dbConnect() {
        try {
            this.connection = DriverManager.getConnection(url, username, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(String username){
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("INSERT into USER (NAME )VALUE ('"+username+"')");
        preparedStatement.executeUpdate();
        } catch (SQLException e) {
//            connection.rollback();
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
