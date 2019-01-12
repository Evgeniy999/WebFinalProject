package by.epam.interpol.service.impl;

import by.epam.interpol.dao.impl.NewsDaoImpl;
import by.epam.interpol.entity.News;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.NewsService;

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
    public void remove(int id) throws ServiceException {
        try {
            newsDao.remove(id);
        } catch (DaoException e) {
            throw new ServiceException("Delete news is failed", e);
        }
    }

    @Override
    public ArrayList<News> showAll() {
        return newsDao.showAll();
    }

    @Override
    public void addNews(String topic, String information, String country, Date time, Part imagePart) throws ServiceException {
        try {
            InputStream inputStream = imagePart.getInputStream();
            newsDao.addNews(topic, information, country, time, inputStream);
        } catch (DaoException | IOException e) {
            throw new ServiceException("Add news is failed", e);
        }

    }
}
