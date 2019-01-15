package by.epam.interpol.dao;

import by.epam.interpol.dao.CommonDao;
import by.epam.interpol.entity.News;
import by.epam.interpol.exception.DaoException;

import java.io.InputStream;
import java.sql.Date;

/**
 * The interface News dao.
 */
public interface NewsDao extends CommonDao<News> {
    /**
     * Add news.
     *
     * @param topic       the topic
     * @param information the information
     * @param country     the country
     * @param date        the date
     * @param image       the image
     * @throws DaoException the dao exception
     */
    void addNews(String topic, String information, String country, Date date, InputStream image) throws DaoException;
}
