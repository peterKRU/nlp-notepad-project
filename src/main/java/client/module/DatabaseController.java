package client.module;

import java.sql.*;

public class DatabaseController {

    CommandController commandController;

    public DatabaseController() throws SQLException {

        CommandController commandController = new CommandController();

        Connection connection = connectDatabase();

        //executeTransaction(connection);

        for(int i = 0; i < 2; i++) {

            executeTransaction(connection);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public Connection connectDatabase() throws SQLException {


        String localUrl = "jdbc:mysql://localhost:3306/concept-storage";

        //docker url
        String dockerUrl = "jdbc:mysql://host.docker.internal:3306/concept-storage";

        String user = "root";
        String password = "zelkaZELKA111.";

        Connection connection = DriverManager.getConnection(dockerUrl, user, password);

        return connection;

    }

    public void executeTransaction(Connection connection) throws SQLException {

        //retrieve table
        System.out.println("user table: ");
        System.out.println("----------");

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

            System.out.println("user_id: " + resultSet.getString("user_id"));

            System.out.println("user_name: " +resultSet.getString("user_name"));

            System.out.println("user_password: " +resultSet.getString("user_password"));
            System.out.println("----------");

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
