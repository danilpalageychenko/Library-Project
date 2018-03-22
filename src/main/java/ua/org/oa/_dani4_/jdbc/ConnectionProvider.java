package ua.org.oa._dani4_.jdbc;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static ua.org.oa._dani4_.properties.PropertyUtils.getProperties;

/**
 * Created by _dani on 30.03.2016.
 */
public class ConnectionProvider {
    private static DataSource dataSource;

    public static Connection getConnection() {
        return getContextConnection();
    }

    public static Connection getContextConnection(){
        if(dataSource == null)
        {
            try {
                Context ctx = new InitialContext();
                dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyDB");
            } catch (NamingException e) {
                e.printStackTrace();
            }

//            MysqlDataSource mysqlDataSource = new MysqlDataSource();
//            mysqlDataSource.setUrl(getProperties().getProperty("JDBC_URL") + "/" + getProperties().getProperty("JDBC_SCHEMA"));
//            mysqlDataSource.setUser(getProperties().getProperty("JDBC_LOGIN"));
//            mysqlDataSource.setPassword(getProperties().getProperty("JDBC_PASSWORD"));
//            dataSource = mysqlDataSource;
        }
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static Connection getAlternateConnection() {

        if (dataSource == null) {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setURL(getProperties().getProperty("JDBC_URL") + getProperties().getProperty("JDBC_SCHEMA"));
            mysqlDataSource.setUser(getProperties().getProperty("JDBC_LOGIN"));
            mysqlDataSource.setPassword(getProperties().getProperty("JDBC_PASSWORD"));
            dataSource = mysqlDataSource;
        }
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
