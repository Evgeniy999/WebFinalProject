package by.epam.interpol.util;

import by.epam.interpol.entity.News;
import by.epam.interpol.entity.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewsBuilder {
    private static final String NEWS_ID = "news_id";
    private static final String NEWS_TOPIC = "topic";
    private static final String NEWS_INFORMATION = "information";
    private static final String NEWS_COUNTRY = "country";
    private static final String NEWS_DATE = "date_news";


    public static News createNews(ResultSet resultSet) throws SQLException {
        int newsId = resultSet.getInt(NEWS_ID);
        String topic = resultSet.getString(NEWS_TOPIC);
        String information = resultSet.getString(NEWS_INFORMATION);
        String country = resultSet.getString(NEWS_COUNTRY);
        Date date = resultSet.getDate(NEWS_DATE);
        return new News(newsId,topic,information,country,date);

    }

    public static ArrayList<News> createNewsAll(ResultSet resultSet) throws SQLException {
        ArrayList<News> result = new ArrayList<>();

        while (resultSet.next()) {

            int newsId = resultSet.getInt(NEWS_ID);
            String topic = resultSet.getString(NEWS_TOPIC);
            String information = resultSet.getString(NEWS_INFORMATION);
            String country = resultSet.getString(NEWS_COUNTRY);
            Date date = resultSet.getDate(NEWS_DATE);

            result.add(new News(newsId,topic,information,country,date));
        }

        return result;

    }

}
