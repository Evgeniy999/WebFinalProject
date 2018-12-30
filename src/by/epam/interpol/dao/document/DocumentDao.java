package by.epam.interpol.dao.document;

import by.epam.interpol.connection.PoolConnection;
import by.epam.interpol.dao.CommonDao;
import by.epam.interpol.entity.Document;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.util.DocBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class DocumentDao implements CommonDao<Document> {

    private static Logger LOGGER = LogManager.getLogger();
    private static final String SEARCH_DOC_BY_ID = "SELECT * FROM documents, statement WHERE document_id = ?";
    private static final String WHERE_DOC_INFORMATION = "SELECT * FROM documents WHERE  doc_information = ?";
    private static final String INSERT_DOC_COMMON = "INSERT * INTO documents values(null,?,?,?,?,?)";
    private static final String SELECT_DOC_ALL = "SELECT * FROM documents JOIN statement on documents.statement_id=statement.statement_id";

    @Override
    public Optional<Document> searchById(int id) {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_DOC_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Document doc = DocBuilder.createDoc(resultSet);
            return Optional.of(doc);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public Document add(Document document) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(WHERE_DOC_INFORMATION);
            preparedStatement.setString(1, document.getInformation());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                throw new DaoException("Document with input login already exist");
            } else {
                PreparedStatement statement = connection.prepareStatement(INSERT_DOC_COMMON);
                statement.setString(1, document.getStatement());
                statement.setDate(2, document.getTime());
                statement.setDouble(3, document.getReward());
                statement.setString(4, document.getInformation());
                statement.setDate(5, document.getLeadTime());

                statement.executeUpdate();
                connection.commit();
                LOGGER.info("Document correctly added");

                return document;
            }
        } catch (SQLException e) {
            throw new DaoException("Document not added", e);
        }

    }

    @Override
    public void remove(Document document) throws DaoException {

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
