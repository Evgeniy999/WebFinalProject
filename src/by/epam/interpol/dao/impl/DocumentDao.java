package by.epam.interpol.dao.impl;

import by.epam.interpol.pool.PoolConnection;
import by.epam.interpol.dao.CommonDao;
import by.epam.interpol.entity.Document;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.util.DocBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class DocumentDao implements CommonDao<Document> {

    private static Logger LOGGER = LogManager.getLogger();
    private static final String SEARCH_DOC_BY_ID = "SELECT * FROM documents JOIN type_statement on documents.type_statement=type_statement.statement_id  WHERE document_id = ?";
    private static final String WHERE_DOC_INFORMATION = "SELECT * FROM documents WHERE  doc_information = ?";
    private static final String INSERT_DOC_COMMON = "INSERT INTO documents values(null,?,?,?,?,?,?,?,?)";
    private static final String SELECT_DOC_ALL = "SELECT * FROM documents JOIN type_statement on documents.type_statement=type_statement.statement_id ";
    private static final String REMOVE_DOC_DATA = "DELETE FROM documents  WHERE document_id = ?";

    @Override
    public Optional<Document> searchById(int id) {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_DOC_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Document doc = null;
            if (resultSet.next()) {
                doc = DocBuilder.createDoc(resultSet);
            }
            return Optional.of(doc);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    public void addDocument(String stat, Date time, double reward, String information, Date leadTime, String name,
                        String lastName, InputStream image) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(WHERE_DOC_INFORMATION);
            preparedStatement.setString(1, information);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                throw new DaoException("Document with input login already exist");
            } else {
                PreparedStatement statement = connection.prepareStatement(INSERT_DOC_COMMON);
                statement.setString(1, name);
                statement.setString(2, lastName);
                statement.setInt(3, Integer.parseInt(stat));
                statement.setDate(4, time);
                statement.setDouble(5, reward);
                statement.setString(6, information);
                statement.setDate(7, leadTime);
                statement.setBlob(8, image);
                statement.executeUpdate();
                connection.commit();
                LOGGER.info("Document correctly added");
            }
        } catch (SQLException e) {
            throw new DaoException("Document not added", e);
        }

    }

    @Override
    public void remove(int id) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_DOC_DATA);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public ArrayList<Document> showAll() {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOC_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Document> documents = DocBuilder.createDocAll(resultSet);
            return documents;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

}
