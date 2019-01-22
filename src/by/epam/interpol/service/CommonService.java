package by.epam.interpol.service;

import by.epam.interpol.exception.ServiceException;

import java.util.ArrayList;
import java.util.Optional;

/**
 * The interface Common service.
 *
 * @param <T> the type parameter
 */
public interface CommonService<T> {

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
     * @throws ServiceException the service exception
     */
    void remove(int id) throws ServiceException;

    /**
     * Show all array list.
     *
     * @return the array list
     */
    ArrayList<T> showAll();
}
