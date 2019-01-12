package by.epam.interpol.service;

import by.epam.interpol.entity.News;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.CommonService;

import javax.servlet.http.Part;
import java.sql.Date;

public interface NewsService extends CommonService<News> {
    void addNews(String topic, String information, String country, Date time, Part imagePart) throws  ServiceException;

}
