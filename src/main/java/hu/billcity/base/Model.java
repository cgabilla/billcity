/*
 * Billcity is an online accounting system owned by Taylorsoft Magyarország Kft. since February 2016.
 */

package hu.billcity.base;

import clover.org.apache.log4j.Logger;
import hu.billcity.consts.DbConst;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * hu.billcity.rest.Model
 * <p/>
 * Basic operations of RESTful domain.
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 9:49PM  2/28/2016
 * @see <a href="http://docs.oracle.com/cd/E41633_01/pt853pbh1/eng/pt/tibr/concept_UnderstandingRESTServiceOperations.html>Understanding REST Service</a>"
 * @since 1.8
 */
public abstract class Model {
    public static Logger logger;
    protected static Connection connection;
    protected String name;


    public Model(String name) {

        this.name = name;
        connection = DbConst.getRemoteConnection();
        logger = Logger.getLogger(this.getClass().getName());
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected Connection getConnection() {
        try {
            if (connection.isClosed())
                return DbConst.getRemoteConnection();
            else
                return connection;
        } catch (SQLException e) {
            logger.debug("Invalid host connection properties...");
        } catch (NullPointerException e) {
            logger.debug("Could not establish DbConst connection...");

        } catch (Exception e) {
            logger.debug("Unexpected error on establishing DbConst connection...");

        }
        return DbConst.getRemoteConnection();
    }
}
