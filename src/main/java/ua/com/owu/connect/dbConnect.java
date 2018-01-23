package ua.com.owu.connect;

import sun.rmi.transport.Connection;

import javax.xml.transform.Result;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
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

    public void save(String username) {
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("INSERT into USER (NAME )VALUE ('" + username + "')");
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

    public List<String> findAll() {
        List<String> users = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM USER");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String user = id + " " + name;

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}

