package by.epam.interpol.dao;

import by.epam.interpol.entity.User;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.exception.DaoException;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The interface Common dao.
 *
 * @param <T> the type parameter
 */
public interface CommonDao<T> {

    /**
     * Search by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<T> searchById(int id);

    /**
     * Remove.
     *
     * @param id the id
     * @throws DaoException the dao exception
     */
    void remove(int id) throws DaoException;

    /**
     * Show all array list.
     *
     * @return the array list
     */
    ArrayList<T> showAll();

}
