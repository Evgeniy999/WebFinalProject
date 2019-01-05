package by.epam.interpol.service.document;

import by.epam.interpol.entity.Document;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.service.CommonService;

import java.sql.Date;

public interface DocService extends CommonService<Document> {
    Document addDoc(String statement, Date time, double reward,
                    String information, Date leadTime, String name, String lastName) throws DaoException;
}
