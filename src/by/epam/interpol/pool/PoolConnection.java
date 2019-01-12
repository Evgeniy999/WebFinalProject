package by.epam.interpol.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class PoolConnection {
    private static Logger LOGGER = LogManager.getLogger(PoolConnection.class);
    DbInitializer dbInitializer;

    private ArrayBlockingQueue<Connection> freeConnections;
    private ArrayBlockingQueue<Connection> releaseConnections;

    private static ReentrantLock lock = new ReentrantLock();
    private static PoolConnection poolConnection;

    public static PoolConnection getInstance() {
        if (poolConnection != null) {
            return poolConnection;
        }

        try {
            lock.lock();
            if (poolConnection == null) {
                try {
                    poolConnection = new PoolConnection();
                } catch (SQLException e) {
                    LOGGER.error("Can not get Instance", e);
                    throw new RuntimeException("Can not get Instance", e);
                }
            }
        } finally {
            lock.unlock();
        }

        return poolConnection;
    }

    private PoolConnection() throws SQLException {
        try {
            dbInitializer = new DbInitializer();
            freeConnections = new ArrayBlockingQueue<>(dbInitializer.DB_MAX_POOL_CAPACITY);
            releaseConnections =  new ArrayBlockingQueue<>(dbInitializer.DB_MAX_POOL_CAPACITY);
            Class.forName(dbInitializer.DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        init();
    }

    private void init() {

        for (int i = 0; i < dbInitializer.DB_INITIAL_CAPACITY; i++) {
            try {
                Connection connection = DriverManager.getConnection(dbInitializer.DB_URL, dbInitializer.DB_USER, dbInitializer.DB_PASSWORD);
                //freeConnections.put(new ProxyConnection(pool));
                freeConnections.add(new ProxyConnection(connection));
            } catch (SQLException e) {
                LOGGER.error("Pool can not initialize", e);
                throw new RuntimeException("Pool can not initialize", e);
            }
        }

    }

    public Connection getConnection() {

        Connection connection = null;
        try {

            if (freeConnections.size() < dbInitializer.DB_MIN_POOL_CAPACITY && (freeConnections.size() +
                    releaseConnections.size()) < dbInitializer.DB_MAX_POOL_CAPACITY) {
                connection = DriverManager.getConnection(dbInitializer.DB_URL, dbInitializer.DB_USER, dbInitializer.DB_PASSWORD);
                releaseConnections.offer(connection);
            } else {
                connection = freeConnections.take();
            }

        } catch (InterruptedException | SQLException e) {
            LOGGER.error("Can not get pool", e);
        }
        return connection;
    }

    void releaseConnection(Connection connection) {

        try {
            if (freeConnections.size() > dbInitializer.DB_MIN_POOL_CAPACITY + dbInitializer.DB_INITIAL_CAPACITY) {
                ((ProxyConnection) connection).realClose();
                for (int i = 0; i < dbInitializer.DB_MIN_POOL_CAPACITY - 1; i++) {
                    ((ProxyConnection) freeConnections.take()).realClose();
                }
            } else {
                freeConnections.offer(connection);
            }
        } catch (InterruptedException e) {
            LOGGER.error("pool take fell down", e);
        }

    }

    public void destroy() {

        for (int i = 0; i < freeConnections.size(); i++) {
            try {
                ProxyConnection connection = (ProxyConnection) freeConnections.take();
                connection.realClose();
            } catch (InterruptedException e) {
                LOGGER.error("Connection close exception", e);
            }
        }
//        try {
//            Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();
//            while (drivers.hasMoreElements()) {
//                java.sql.Driver driver = drivers.nextElement();
//                DriverManager.deregisterDriver(driver);
//
//            }
//        }
//        catch (SQLException e) {
//            LOGGER.error("Drivers were not deregistrated", e);
//        }
        DriverManager.drivers().forEach(x -> {
            try {
                DriverManager.deregisterDriver(x);
            } catch (SQLException e) {
                LOGGER.error("Can't deregister driver", e);
            }
        });
        poolConnection = null;
    }


}
