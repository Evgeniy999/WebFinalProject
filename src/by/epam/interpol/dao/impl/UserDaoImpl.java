package by.epam.interpol.dao.impl;

import by.epam.interpol.pool.PoolConnection;
import by.epam.interpol.dao.UserDao;
import by.epam.interpol.entity.User;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.util.UserBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * The type User dao.
 */
public class UserDaoImpl implements UserDao<User> {

    private static Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);
    private static final String SEARCH_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
    private static final String SEARCH_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String INSERT_NEW_USER_COMMON = "INSERT INTO users values(null,?,?,?,?,?,? + INTERVAL 1 DAY,?,?)";
    private static final String REMOVE_USER_DATA = "DELETE FROM users  WHERE user_id = ?";
    private static final String SELECT_USER_ALL = "SELECT * FROM users";
    private static final String CHANGE_PASSWORD = "UPDATE users SET users.password = ? WHERE users.user_id = ?";
    private static final String CHANGE_PROF = "UPDATE users SET users.user_name = ?,users.user_lastName=?,users.user_birthday=?  + INTERVAL 1 DAY," +
            "users.telephone=?,users.address=? WHERE users.user_id = ?";

    @Override
    public Optional<User> searchById(int id) {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = UserBuilder.createUser(resultSet);
            }
            return Optional.of(user);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }


    /**
     * Search user by login optional.
     *
     * @param login the login
     * @return the optional
     */
    public Optional<User> searchUserByLogin(String login) {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = null;
            if (resultSet.next()) {
                user = UserBuilder.createUser(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            return Optional.empty();
        }

    }

    @Override
    public User add(User user) throws DaoException {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER_BY_LOGIN);
            preparedStatement.setString(1, user.getLogin());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                throw new DaoException("User with input login already exist");
            } else {
                PreparedStatement statement = connection.prepareStatement(INSERT_NEW_USER_COMMON);
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getName());
                statement.setString(4, user.getLastName());
                statement.setBoolean(5, user.isType());
                statement.setDate(6, user.getBirthday());
                statement.setLong(7, user.getTelephone());
                statement.setString(8, user.getAddress());

                statement.executeUpdate();
                LOGGER.info("User correctly added");

                return user;
            }
        } catch (SQLException e) {
            throw new DaoException("User not added", e);
        }

    }

    @Override
    public void changePassword(int id, String password) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_PASSWORD);
            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void changeProf(int id, String name, String last, Date birth, long telephone, String address) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_PROF);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, last);
            preparedStatement.setDate(3, birth);
            preparedStatement.setLong(4, telephone);
            preparedStatement.setString(5, address);
            preparedStatement.setInt(6, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void remove(int id) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_USER_DATA);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public ArrayList<User> showAll() {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<User> users = UserBuilder.createUsers(resultSet);
            return users;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

}
