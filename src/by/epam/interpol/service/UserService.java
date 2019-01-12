package by.epam.interpol.service;

import by.epam.interpol.entity.User;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.CommonService;


import java.sql.Date;
import java.util.Optional;

public interface UserService extends CommonService<User> {

    User addUser(String login, String password, String name, String lastName,
                 Date date, long birthday, String address) throws ServiceException;
    void changePassword(int id, String password) throws ServiceException;
    void changeProf(int id, String name,String last,Date birth,long telephone,String address) throws ServiceException;

}