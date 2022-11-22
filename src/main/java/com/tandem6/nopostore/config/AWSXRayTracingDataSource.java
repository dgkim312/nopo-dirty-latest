package com.tandem6.nopostore.config;

import com.amazonaws.xray.sql.TracingDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class AWSXRayTracingDataSource extends TracingDataSource {

    public AWSXRayTracingDataSource(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return AWSXRayTracingConnection.decorate(delegate.getConnection());
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return AWSXRayTracingConnection.decorate(delegate.getConnection(username, password));
    }

}
