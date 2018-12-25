package by.epam.interpol.connection;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DbInitializer {
    private static Logger LOGGER = LogManager.getLogger();
    final String DB_URL;
    final String DB_USER;
    final String DB_PASSWORD;
    final String DB_DRIVER;
    final int DB_MIN_POOL_CAPACITY;
    final int DB_MAX_POOL_CAPACITY;
    final int DB_INITIAL_CAPACITY;

    DbInitializer(){
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("properties.poolConnection");//todo dopisat
            DB_URL = resourceBundle.getString("url");
            DB_USER = resourceBundle.getString("user");
            DB_PASSWORD = resourceBundle.getString("password");
            DB_DRIVER = resourceBundle.getString("driver");
            DB_MIN_POOL_CAPACITY = Integer.valueOf(resourceBundle.getString("min.capacity"));
            DB_MAX_POOL_CAPACITY = Integer.valueOf(resourceBundle.getString("max.capacity"));
            DB_INITIAL_CAPACITY = Integer.valueOf(resourceBundle.getString("init.capacity"));
        }catch(NumberFormatException | MissingResourceException e){
            LOGGER.log(Level.FATAL,"Properties file error",e);
            throw new RuntimeException("Properties file error" + e);
        }
    }
}
