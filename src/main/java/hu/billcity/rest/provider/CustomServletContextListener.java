package hu.billcity.rest.provider;

import clover.org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * hu.billcity.rest.provider
 * <p>
 * <Class Description>
 * <p>
 * <Reference source if any><a href=""></a>
 *
 * @author Cyrus G. Gabilla <a href="mailto:cgabilla@gmail.com">cgabilla@gmail.com</a>
 * @version 10:06 AM; 3/15/2016
 * @since 1.8
 */


@WebListener
public class CustomServletContextListener
        implements ServletContextListener {
    static final Logger LOGGER = Logger.getLogger(CustomServletContextListener.class.getName());

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // This manually de-registers JDBC driver, which prevents Tomcat 7 from complaining about memory leaks to this class
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                LOGGER.info(String.format("Removing registered jdbc driver: %s", driver));
            } catch (SQLException e) {
                LOGGER.debug(String.format("Encountered an error during removing jdbc driver: %s", driver));
            }

        }
    }

    //Run this before web application is started
    @Override
    public void contextInitialized(ServletContextEvent event) {
        LOGGER.info("ServletContextListener is now listening ...");
    }
}
