package by.epam.interpol.util;

import by.epam.interpol.entity.News;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

/**
 * The type News builder.
 */
public class NewsBuilder {
    private static final String NEWS_ID = "news_id";
    private static final String NEWS_TOPIC = "topic";
    private static final String NEWS_INFORMATION = "information";
    private static final String NEWS_COUNTRY = "country";
    private static final String NEWS_DATE = "date_news";
    private static final String NEWS_PHOTO = "news_photo";


    /**
     * Create news news.
     *
     * @param resultSet the result set
     * @return the news
     * @throws SQLException the sql exception
     */
    public static News createNews(ResultSet resultSet) throws SQLException {

        int newsId = resultSet.getInt(NEWS_ID);
        String topic = resultSet.getString(NEWS_TOPIC);
        String information = resultSet.getString(NEWS_INFORMATION);
        String country = resultSet.getString(NEWS_COUNTRY);
        Date date = resultSet.getDate(NEWS_DATE);
        Blob photo = resultSet.getBlob(NEWS_PHOTO);
        String base64EncodedPhoto = null;
        if (photo != null) {
            base64EncodedPhoto = Base64.getEncoder().encodeToString(photo.getBytes(1, (int) photo.length()));
        }
        return new News(newsId, topic, information, country, date, photo, base64EncodedPhoto);

    }

    /**
     * Create news all array list.
     *
     * @param resultSet the result set
     * @return the array list
     * @throws SQLException the sql exception
     */
    public static ArrayList<News> createNewsAll(ResultSet resultSet) throws SQLException {
        ArrayList<News> result = new ArrayList<>();

        while (resultSet.next()) {

            int newsId = resultSet.getInt(NEWS_ID);
            String topic = resultSet.getString(NEWS_TOPIC);
            String information = resultSet.getString(NEWS_INFORMATION);
            String country = resultSet.getString(NEWS_COUNTRY);
            Date date = resultSet.getDate(NEWS_DATE);
            Blob photo = resultSet.getBlob(NEWS_PHOTO);
            String base64EncodedPhoto = null;
            if (photo != null) {
                base64EncodedPhoto = Base64.getEncoder().encodeToString(photo.getBytes(1, (int) photo.length()));
            }

            result.add(new News(newsId, topic, information, country, date, photo, base64EncodedPhoto));
        }

        return result;

    }

}
