/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.consts;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * hu.billcity.sql.DbConst
 * A connector for PostgreSQL
 * <References>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 3/1/2016
 * @since 1.8
 */

public final class DbConst {
    private static final Logger LOGGER = LogManager.getLogger(DbConst.class);

    private static final String DB_USER = "postgres";
    private static final String LOCAL_PASS = "P0lym0rph1sm";
    private static final String REMOTE_PASS = "deceit4u";

    private static final String CONNECTION_FMT = "jdbc:postgresql://%s:%s/%s";
    private static final String DB_POSTGRES_DRIVER = "org.postgresql.Driver";
    private static final String DB_PORT = "5432";
    private static final String DB_NAME = "billcity-test-20160301";

    private static final String LOCAL_HOST = "localhost";
    private static final String REMOTE_HOST = "dev.zeus-online.hu";


    private static boolean hasEnoughDbDriverRequirement() {
        boolean result = false;
        try {
            Class.forName(DB_POSTGRES_DRIVER);
            result = true;
        } catch (ClassNotFoundException e) {
            LOGGER.debug("No suitable driver found for: " + DB_POSTGRES_DRIVER);
        }
        return result;

    }


    public static Connection getConnection(String hostUrl, String dbUser, String dbPassword, boolean isAutoCommit) {
        Connection connection = null;
        if (!hasEnoughDbDriverRequirement()) {
            try {
                    connection = DriverManager.getConnection(hostUrl, dbUser, dbPassword);
                    connection.setAutoCommit(isAutoCommit);
                }
             catch (SQLException e) {
                LOGGER.error("Unable to get a connection from => " + hostUrl);
            } catch(Exception e) {
                LOGGER.error("There was An error while getting a database connection ...");
            }
        } else
            LOGGER.error("Unable to to get a compatible database driver for => " + hostUrl);

        return connection;
    }

    public static Connection getLocalConnection() {
        String hostUrl = String.format(CONNECTION_FMT, LOCAL_HOST, DB_PORT, DB_NAME);
        return DbConst.getConnection(hostUrl, DB_USER, LOCAL_PASS, false);

    }

    public static Connection getRemoteConnection() {
        String hostUrl = String.format(CONNECTION_FMT, REMOTE_HOST, DB_PORT, DB_NAME);
        return DbConst.getConnection(hostUrl, DB_USER, REMOTE_PASS, false);
    }

    // duplicate method for the global connection
    public static Connection getBillcityConnection() {
        // either you want to share the local or remote
        return DbConst.getRemoteConnection();
    }
}
