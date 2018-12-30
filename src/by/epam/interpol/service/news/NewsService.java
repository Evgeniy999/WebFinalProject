package by.epam.interpol.service.news;

import by.epam.interpol.dao.news.NewsDao;
import by.epam.interpol.entity.News;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.service.CommonService;

import java.util.ArrayList;
import java.util.Optional;

public class NewsService implements CommonService<News> {
    private NewsDao newsDao = new NewsDao();
    @Override
    public Optional<News> searchById(int id) {
        return newsDao.searchById(id);
    }

    @Override
    public void remove(News news) throws DaoException {

    }

    @Override
    public ArrayList<News> showAll() {
        return newsDao.showAll();
    }

}
