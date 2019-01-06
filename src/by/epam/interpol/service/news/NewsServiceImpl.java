package by.epam.interpol.service.news;

import by.epam.interpol.dao.news.NewsDaoImpl;
import by.epam.interpol.entity.News;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.exception.DaoException;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

public class NewsServiceImpl implements NewsService {

    private NewsDaoImpl newsDao = new NewsDaoImpl();

    @Override
    public Optional<News> searchById(int id) {
        return newsDao.searchById(id);
    }

    @Override
    public void remove(int id) throws DaoException {
        newsDao.remove(id);
    }

    @Override
    public ArrayList<News> showAll() {
        return newsDao.showAll();
    }

    @Override
    public void addNews(String topic, String information, String country, Date time, Part imagePart) throws DaoException {
        try {
            InputStream inputStream = imagePart.getInputStream();
            newsDao.addNews(topic, information, country, time, inputStream);
        } catch (DaoException | IOException e) {
            throw new DaoException("Add document is failed", e);
        }

    }
}
