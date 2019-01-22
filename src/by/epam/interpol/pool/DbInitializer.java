package by.epam.interpol.pool;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * The type Db initializer.
 */
class DbInitializer {
    private static Logger LOGGER = LogManager.getLogger(DbInitializer.class);
    /**
     * The Db url.
     */
    final String DB_URL;
    /**
     * The Db user.
     */
    final String DB_USER;
    /**
     * The Db password.
     */
    final String DB_PASSWORD;
    /**
     * The Db driver.
     */
    final String DB_DRIVER;
    /**
     * The Db initial capacity.
     */
    final int DB_INITIAL_CAPACITY;

    /**
     * Instantiates a new Db initializer.
     */
    DbInitializer() {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.properties.poolConnection");
            DB_URL = resourceBundle.getString("url");
            DB_USER = resourceBundle.getString("user");
            DB_PASSWORD = resourceBundle.getString("password");
            DB_DRIVER = resourceBundle.getString("driver");
            DB_INITIAL_CAPACITY = Integer.valueOf(resourceBundle.getString("init.capacity"));
        } catch (NumberFormatException | MissingResourceException e) {
            LOGGER.log(Level.FATAL, "Properties file error", e);
            throw new RuntimeException("Properties file error", e);
        }
    }
}
