package com.milman.dataSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class CustomDataSource {

    private static CustomDataSource datasource;
    private BoneCP connectionPool;

    public CustomDataSource() {
        try {
            // load the database driver (make sure this is in your classpath!)
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            // setup the connection pool using BoneCP Configuration
            BoneCPConfig config = new BoneCPConfig();
            // jdbc url specific to your database, eg jdbc:mysql://127.0.0.1/yourdb
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/APPLE-SELL-BUY");
            config.setUsername("postgres");
            config.setPassword("admin");
            config.setMinConnectionsPerPartition(5);
            config.setMaxConnectionsPerPartition(10);
            config.setPartitionCount(1);
            // setup the connection pool
            connectionPool = new BoneCP(config);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static CustomDataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new CustomDataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.connectionPool.getConnection();
    }

}