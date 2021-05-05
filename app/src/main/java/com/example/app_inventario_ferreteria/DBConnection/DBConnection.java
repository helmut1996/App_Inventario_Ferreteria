package com.example.app_inventario_ferreteria.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    private static String ip = "161.0.62.5";
    private static String port = "1440";
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    private static String database = "BDMARNOR";
    private static String username = "sa";
    private static String password = "System32";
    private Connection connection = null;
    private static String url = "jdbc:jtds:sqlserver://" + ip + ":" + port + "/" + database;
    private static com.example.app_inventario_ferreteria.DBConnection.DBConnection dbConnection;

    public DBConnection(){}

    public void conectar()
    {
        try
        {
            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized com.example.app_inventario_ferreteria.DBConnection.DBConnection getDbConnection()
    {
        if(dbConnection == null)
        {
            dbConnection = new com.example.app_inventario_ferreteria.DBConnection.DBConnection();
            dbConnection.conectar();
        }
        return dbConnection;
    }

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) {
        connection = this.connection;
    }

}
