package by.epam.interpol.dao;

import by.epam.interpol.dao.CommonDao;
import by.epam.interpol.entity.News;
import by.epam.interpol.exception.DaoException;

import java.io.InputStream;
import java.sql.Date;

public interface NewsDao extends CommonDao<News> {
     void addNews(String topic, String information, String country, Date date, InputStream image) throws DaoException;
}
