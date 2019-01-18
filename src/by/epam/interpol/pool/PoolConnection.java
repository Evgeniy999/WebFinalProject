package by.epam.interpol.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The type Pool connection.
 */
public class PoolConnection {
    private static Logger LOGGER = LogManager.getLogger(PoolConnection.class);
    /**
     * The Db initializer.
     */
    DbInitializer dbInitializer;

    private ArrayBlockingQueue<Connection> freeConnections;
    private ArrayBlockingQueue<Connection> releaseConnections;

    private static ReentrantLock lock = new ReentrantLock();
    private static PoolConnection poolConnection;

    /**
     * Gets instance.
     *
     * @return the instance
     */
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
            freeConnections = new ArrayBlockingQueue<>(dbInitializer.DB_INITIAL_CAPACITY);
            releaseConnections = new ArrayBlockingQueue<>(dbInitializer.DB_INITIAL_CAPACITY);
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
                freeConnections.add(new ProxyConnection(connection));
            } catch (SQLException | IllegalStateException e) {
                LOGGER.error("Pool can not initialize", e);
            }
        }

    }

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public Connection getConnection() {

        Connection connection = null;
        try {
            connection = freeConnections.take();
            releaseConnections.offer(connection);

        } catch (InterruptedException e) {
            LOGGER.error("Can not get pool", e);
        }
        return connection;
    }

    /**
     * Release connection.
     *
     * @param connection the connection
     */
    void releaseConnection(Connection connection) {
        releaseConnections.remove(connection);
        freeConnections.offer(connection);
    }

    /**
     * Destroy.
     */
    public void destroy() {

        for (int i = 0; i < freeConnections.size(); i++) {
            try {
                ProxyConnection connection = (ProxyConnection) freeConnections.take();
                connection.realClose();
            } catch (InterruptedException e) {
                LOGGER.error("Connection close exception", e);
            }
        }

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
