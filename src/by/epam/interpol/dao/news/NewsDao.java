package by.epam.interpol.dao.news;

import by.epam.interpol.connection.PoolConnection;
import by.epam.interpol.dao.CommonDao;
import by.epam.interpol.dao.user.UserDao;
import by.epam.interpol.entity.News;

import by.epam.interpol.exception.DaoException;
import by.epam.interpol.util.NewsBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class NewsDao implements CommonDao<News> {

    private static Logger LOGGER = LogManager.getLogger();
    private static final String SEARCH_NEWS_BY_ID = "SELECT * FROM news WHERE news_id = ?";
    private static final String SEARCH_NEWS_BY_INF = "SELECT * FROM news WHERE  information= ?";
    private static final String INSERT_NEW_COMMON = "INSERT * INTO news values(null,?,?,?,?)";
    private static final String SELECT_NEW_ALL = "SELECT news_id,topic,information,country,date_news FROM news";


    @Override
    public Optional<News> searchById(int id) {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NEWS_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            News news = null;
            if(resultSet.next()) {
              news = NewsBuilder.createNews(resultSet);
            }
            return Optional.of(news);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public News add(News news) throws DaoException {
        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NEWS_BY_INF);
            preparedStatement.setString(1, news.getInformation());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                throw new DaoException("News already exist");
            } else {
                PreparedStatement statement = connection.prepareStatement(INSERT_NEW_COMMON);
                statement.setString(1, news.getTopic());
                statement.setString(2, news.getInformation());
                statement.setString(3, news.getCountry());
                statement.setDate(4, news.getTime());

                statement.executeUpdate();
                connection.commit();
                LOGGER.info("News correctly added");

                return news;
            }
        } catch (SQLException e) {
            throw new DaoException("News not added", e);
        }

    }

    @Override
    public void remove(int id) throws DaoException {

    }

    @Override
    public ArrayList<News> showAll() {

        try (Connection connection = PoolConnection.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NEW_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<News> news = NewsBuilder.createNewsAll(resultSet);
            return news;
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

}
