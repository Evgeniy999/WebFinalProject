package by.epam.interpol.dao.impl;

import by.epam.interpol.dao.PersonDao;
import by.epam.interpol.entity.Document;
import by.epam.interpol.entity.Person;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.pool.PoolConnection;
import by.epam.interpol.util.DocBuilder;
import by.epam.interpol.util.PersonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class PersonDaoImpl implements PersonDao {

    private static Logger LOGGER = LogManager.getLogger();
    private static final String SEARCH_PERSON_BY_ID = "SELECT * FROM people JOIN type_statement on people.person_status=type_statement.statement_id  WHERE person_id = ?";
    private static final String INSERT_PERSON = "INSERT INTO people values(null,?,?,?,?,?,?,?,?,?,?,?) ";
    private static final String SELECT_PERSON_ALL = "SELECT * FROM people JOIN type_statement on people.person_status=type_statement.statement_id ";
    private static final String REMOVE_PERSON_DATA = "DELETE FROM people WHERE person_id = ?";
    private static final String WHERE_PERSON_INF = "SELECT * FROM people WHERE  person_name= ? and person_lastName=?";

    @Override
    public void addPerson(String name, String lastName, Date birth, int weight, int height, String hair, String nationality,
                          String sex, String characteristics, int status, Blob image) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(WHERE_PERSON_INF);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                throw new DaoException("Person already exist");
            } else {
                PreparedStatement statement = connection.prepareStatement(INSERT_PERSON);
                statement.setString(1, name);
                statement.setString(2, lastName);
                statement.setDate(3, birth);
                statement.setInt(4, status);
                statement.setInt(5, weight);
                statement.setInt(6, height);
                statement.setString(7, hair);
                statement.setString(8, nationality);
                statement.setString(9, characteristics);
                statement.setString(10, sex);
                statement.setBlob(11, image);
                statement.executeUpdate();
                connection.commit();
                LOGGER.info("Person correctly added");
            }
        } catch (SQLException e) {
            throw new DaoException("Person not added", e);
        }
    }

    @Override
    public Optional<Person> searchById(int id) {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PERSON_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Person person = null;
            if (resultSet.next()) {
                person = PersonBuilder.createPerson(resultSet);
            }
            return Optional.of(person);
        } catch (
                SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public void remove(int id) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_PERSON_DATA);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public ArrayList<Person> showAll() {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PERSON_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Person> people = PersonBuilder.createPersonAll(resultSet);
            return people;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }
}
