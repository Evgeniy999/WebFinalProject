package by.epam.interpol.dao.user;

import by.epam.interpol.connection.PoolConnection;
import by.epam.interpol.dao.CommonDao;
import by.epam.interpol.entity.User;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.util.UserBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class UserDao implements CommonDao<User> {

    private static Logger LOGGER = LogManager.getLogger(UserDao.class);
    private static final String SEARCH_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
    private static final String SEARCH_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String INSERT_NEW_USER_COMMON = "INSERT INTO users values(null,?,?,?,?,?,?,?,?)";
    private static final String REMOVE_USER_DATA = "DELETE FROM users  WHERE user_id = ?";
    private static final String SELECT_USER_ALL = "SELECT * FROM users";


    @Override
    public Optional<User> searchById(int id) {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if(resultSet.next()){
                user = UserBuilder.createUser(resultSet);
            }
            return Optional.of(user);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }


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

    public User add(User user) throws DaoException {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

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
                connection.commit();
                LOGGER.info("User correctly added");

                return user;
            }
        } catch (SQLException e) {
            throw new DaoException("User not added", e);
        }

    }


    @Override
    public void remove(User element) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_USER_DATA);
            preparedStatement.setInt(1, element.getUserId());
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
