package by.epam.interpol.dao;

import by.epam.interpol.entity.Document;
import by.epam.interpol.exception.DaoException;

import java.io.InputStream;
import java.sql.Date;

/**
 * The interface Document dao.
 */
public interface DocumentDao extends  CommonDao<Document> {
    /**
     * Add document.
     *
     * @param stat        the stat
     * @param time        the time
     * @param reward      the reward
     * @param information the information
     * @param leadTime    the lead time
     * @param name        the name
     * @param lastName    the last name
     * @param image       the image
     * @throws DaoException the dao exception
     */
    void addDocument(String stat, Date time, double reward, String information, Date leadTime, String name,
                     String lastName, InputStream image) throws DaoException;
}
