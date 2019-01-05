package by.epam.interpol.service.user;

import by.epam.interpol.entity.User;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.service.CommonService;


import java.sql.Date;
import java.util.Optional;

public interface UserService extends CommonService<User> {

    Optional<User> searchUserByLogin(String login);
    User addUser(String login, String password, String name, String lastName,
                 Date date, long birthday, String address) throws ApplicationException, DaoException;
    void changePassword(int id, String password) throws DaoException;

}