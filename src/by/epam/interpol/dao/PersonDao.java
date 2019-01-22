package by.epam.interpol.dao;

import by.epam.interpol.entity.Person;
import by.epam.interpol.exception.DaoException;

import java.sql.Blob;
import java.sql.Date;

/**
 * The interface Person dao.
 */
public interface PersonDao extends CommonDao<Person> {
    /**
     * Add person.
     *
     * @param name            the name
     * @param lastName        the last name
     * @param birth           the birth
     * @param weight          the weight
     * @param height          the height
     * @param hair            the hair
     * @param nationality     the nationality
     * @param sex             the sex
     * @param characteristics the characteristics
     * @param status          the status
     * @param image           the image
     * @throws DaoException the dao exception
     */
    void addPerson(String name, String lastName, Date birth,int weight,int height, String hair, String nationality,
                   String sex, String characteristics, int status, Blob image) throws DaoException;
}
