package by.epam.interpol.service;

import by.epam.interpol.entity.User;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.CommonService;


import java.sql.Date;
import java.util.Optional;

/**
 * The interface User service.
 */
public interface UserService extends CommonService<User> {

    /**
     * Add user user.
     *
     * @param login    the login
     * @param password the password
     * @param name     the name
     * @param lastName the last name
     * @param date     the date
     * @param birthday the birthday
     * @param address  the address
     * @return the user
     * @throws ServiceException the service exception
     */
    User addUser(String login, String password, String name, String lastName,
                 Date date, long birthday, String address) throws ServiceException;

    /**
     * Change password.
     *
     * @param id       the id
     * @param password the password
     * @throws ServiceException the service exception
     */
    void changePassword(int id, String password) throws ServiceException;

    /**
     * Change prof.
     *
     * @param id        the id
     * @param name      the name
     * @param last      the last
     * @param birth     the birth
     * @param telephone the telephone
     * @param address   the address
     * @throws ServiceException the service exception
     */
    void changeProf(int id, String name,String last,Date birth,long telephone,String address) throws ServiceException;

}