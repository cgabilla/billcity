package hu.billcity.sql;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hu.billcity.sql
 * <p>
 * <Class Description>
 * <p>
 * <Reference source if any><a href=""></a>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 11:34 AM; 3/14/2016
 * @since 1.8
 */

public class QueryHelper {
    final static Logger LOGGER = LogManager.getLogger(QueryHelper.class);

    public static final String QUERY_DELETE_ROW_BY_ID_FMT = "DELETE %s WHERE id = ?";
    public static final String QUERY_SELECT_ROW_BY_ID_FMT = "SELECT * FROM %s WHERE id = %d LIMIT 1";
    public static final String QUERY_SELECT_ID_FMT = "SELECT id FROM %s WHERE %s";

    public static Boolean execDeleteAsPreparedStatement(String tableName, int id, Connection aConnection) {
        int nRowsAffected = 0;

        try {
            PreparedStatement preparedStatement = aConnection.prepareStatement(String.format(QUERY_DELETE_ROW_BY_ID_FMT, tableName));
            preparedStatement.setInt(1, id);

            // execute delete SQL statement
            nRowsAffected = preparedStatement.executeUpdate();

        } catch (Exception e) {
            LOGGER.debug(e.getMessage());
        } finally {
            try {
                if (aConnection != null && !aConnection.isClosed())
                    aConnection.close();
            } catch (SQLException e) {
                LOGGER.debug(e.getMessage());
            }
        }

        return (nRowsAffected == 1);
    }

    public static Map<String, String> execSelectAllSingleResultById(String modelName, int id, Connection connection) {
        Map<String, String> rowResult = null;
        String query = String.format(QUERY_SELECT_ROW_BY_ID_FMT, modelName, id);
        LOGGER.info("Query constructed: " + query);
        try {
            Statement statement = connection.createStatement();

            // execute delete SQL statement
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.wasNull())
                return null;

            // only initialized if we have something to add
            rowResult = new HashMap<>();
            // We only expect a single result, use if instead than while
            while (resultSet.next()) {
                ResultSetMetaData metadata = resultSet.getMetaData();
                int columnCount = metadata.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    rowResult.put(metadata.getColumnName(i), resultSet.getString(i));
                }
            }

        } catch (SQLException e) {
            LOGGER.debug("Encountered a problem during executing the query => " + query);
        } catch (NullPointerException e) {
            LOGGER.debug("The connection was not established.");
        } finally {
            closeConnection(connection);
        }

        return rowResult;
    }

    public static List<Map<String, String>> executeSelectAllMultipleResult(String aQuery, Connection aConnection) {
        return null;
    }


    public static int executeQueryFetchIdOnly(String query, Connection connection) {
        int id = -1;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // execute delete SQL statement
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.wasNull())
                return -1;

            id = resultSet.getInt("id");
        } catch (Exception e) {
            LOGGER.debug("Encountered a problem during executing the query => " + query);
        } finally {
            closeConnection(connection);
        }

        return id;
    }

    public static int executeQuery(String query, Connection connection) {
        int nRowsAffected = 0;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // execute delete SQL statement
            nRowsAffected = preparedStatement.executeUpdate();

        } catch (Exception e) {
            LOGGER.debug("Encountered a problem during executing the query => " + query);
        } finally {
            closeConnection(connection);
        }

        return nRowsAffected;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            LOGGER.debug("The connection refused to close.");
        }

    }
}
