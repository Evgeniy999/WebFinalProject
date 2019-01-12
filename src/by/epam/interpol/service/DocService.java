package by.epam.interpol.service;

import by.epam.interpol.entity.Document;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.CommonService;

import javax.servlet.http.Part;
import java.sql.Date;

public interface DocService extends CommonService<Document> {
    void addDoc(String statement, Date time, double reward,
                    String information, Date leadTime, String name, String lastName, Part photo) throws ServiceException;
}
