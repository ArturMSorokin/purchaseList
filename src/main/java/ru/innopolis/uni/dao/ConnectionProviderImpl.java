package ru.innopolis.uni.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by MrArtur on 01.12.2016.
 */
public class ConnectionProviderImpl implements ConnectionProvider,AutoCloseable {
    private final String DRIVER="org.postgresql.Driver",
            DBURL = "jdbc:postgresql://localhost:5432/purchaseList",
    USERNAME = "postgres",
    PASSWORD = "12345";
    private Connection connection=null;

    public void close() throws Exception {
        if  (connection!=null)
            connection.close();
    }

    public static ConnectionProviderImpl getProvider() {
        return InstanceHolder.INSTANCE;
    }
    private ConnectionProviderImpl() {}
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection==null) {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        }
        return connection;
    }
    private static class InstanceHolder {
        static final ConnectionProviderImpl  INSTANCE = new ConnectionProviderImpl();
    }
}
//_______________________________________________
