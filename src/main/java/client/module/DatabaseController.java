package client.module;

import java.sql.*;

public class DatabaseController {

    CommandController commandController;

    public DatabaseController() throws SQLException {

        CommandController commandController = new CommandController();

        Connection connection = connectDatabase();

        //testDatabase();
        //User newUser = commandController.createUser(1003, "peter2", "zeleZele111.");
        //insertUser(connection, newUser);
        executeTransaction(connection);

    }

    public Connection connectDatabase() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concept-storage","root", "zelkaZELKA111.");

        return connection;

    }

    public void executeTransaction(Connection connection) throws SQLException {

        //retrieve table
        System.out.println("Before insertion: ");
        retrieveTable(connection, "user");
        System.out.println("Inserting new user...");

        //create new user
        CommandController comm = new CommandController();
        User newUser = comm.createUser(1008, "peter4", "ololo2");

        //insert into table
        insertUser(connection, newUser);

        //retrieve new table
        System.out.println("After insertion: ");
        retrieveTable(connection, "user");

    }

    public void testDatabase() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concept-storage","root", "zelkaZELKA111.");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

        while (resultSet.next()){
            System.out.println(resultSet.getString("user_id"));
            System.out.println(resultSet.getString("user_name"));
            System.out.println(resultSet.getString("user_password"));
        }

    }

    public void retrieveTable(Connection connection, String table) throws SQLException {

        String sqlQuery = "SELECT * FROM ";
        String sqlCommand = sqlQuery + table;

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sqlCommand);

        while (resultSet.next()){
            System.out.println(resultSet.getString("user_id"));
            System.out.println(resultSet.getString("user_name"));
            System.out.println(resultSet.getString("user_password"));
        }

    }

    public void retrieveAllTables() {


    }

    public void insertUser(Connection connection, User user) throws SQLException {

        String sqlQuery = "INSERT INTO user VALUES ";
        String user_id = user.getUser_id().toString();
        String user_name = user.getUser_name();
        String user_password = user.getUser_password();
        String leftBracket = "(";
        String rightBracket = ")";
        String par = "'";

        String sqlCommand = sqlQuery + leftBracket +  user_id + ", " + par + user_name + par + ", " + par + user_password + par + rightBracket;

        System.out.println(sqlCommand);

        Statement statement = connection.createStatement();

        statement.executeUpdate(sqlCommand);

    }

}
