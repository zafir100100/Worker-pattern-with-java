package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnectionRepository
{

    private final String DB_HOST = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_NAME = "worker_test";
    private final String DB_CONNECTION_STRING = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "";

    public Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = (Connection) DriverManager.getConnection(DB_CONNECTION_STRING, DB_USERNAME, DB_PASSWORD);
            return connection;
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}
