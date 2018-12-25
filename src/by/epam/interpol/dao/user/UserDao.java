package by.epam.interpol.dao.user;

import by.epam.interpol.connection.PoolConnection;
import by.epam.interpol.dao.CommonDao;
import by.epam.interpol.entity.User;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.util.UserBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.Optional;

public class UserDao implements CommonDao<User> {

    private static Logger LOGGER = LogManager.getLogger(UserDao.class);
    private static final String SEARCH_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
    private static final String SEARCH_USER_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String INSERT_NEW_USER_COMMON = "INSERT INTO users values(null,?,?,?,?,?,?,?,?)";


    @Override
    public Optional<User> searchById(int id) {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = UserBuilder.createUser(resultSet);
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
            if (resultSet.next()) {//todo добавить запрос на админа
                user = UserBuilder.createUser(resultSet);
            }
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            return Optional.empty();
        }

    }

    public User add(User user) throws ApplicationException {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_USER_BY_LOGIN);
            preparedStatement.setString(1, user.getLogin());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                throw new ApplicationException("User with input login already exist");
            } else {
                PreparedStatement userAddStatement = connection.prepareStatement(INSERT_NEW_USER_COMMON);
                userAddStatement.setString(1, user.getLogin());
                userAddStatement.setString(2, user.getPassword());
                userAddStatement.setString(3, user.getName());
                userAddStatement.setString(4, user.getLastName());
                userAddStatement.setBoolean(5, user.isType());
                userAddStatement.setDate(6, user.getBirthday());
                userAddStatement.setLong(7, user.getTelephone());
                userAddStatement.setString(8, user.getAddress());


                userAddStatement.executeUpdate();
                connection.commit();
                LOGGER.info("User correctly added");

                return user;
            }
        } catch (SQLException e) {
            throw new ApplicationException("User not added", e);
        }

    }

}
