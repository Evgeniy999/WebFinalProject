package by.epam.interpol.dao;

import by.epam.interpol.exception.DaoException;

import java.sql.Date;

/**
 * The interface User dao.
 *
 * @param <T> the type parameter
 */
public interface UserDao<T> extends CommonDao {
    /**
     * Add t.
     *
     * @param t the t
     * @return the t
     * @throws DaoException the dao exception
     */
    T add(T t) throws DaoException;

    /**
     * Change password.
     *
     * @param id       the id
     * @param password the password
     * @throws DaoException the dao exception
     */
    void changePassword(int id, String password) throws DaoException;

    /**
     * Change prof.
     *
     * @param id        the id
     * @param name      the name
     * @param last      the last
     * @param birth     the birth
     * @param telephone the telephone
     * @param address   the address
     * @throws DaoException the dao exception
     */
    void changeProf(int id, String name, String last, Date birth, long telephone, String address) throws DaoException;
}
