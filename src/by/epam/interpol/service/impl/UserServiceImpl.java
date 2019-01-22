package by.epam.interpol.service.impl;

import by.epam.interpol.coding.PasswordCode;
import by.epam.interpol.dao.impl.UserDaoImpl;
import by.epam.interpol.entity.User;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.UserService;

/**
 * The type User service.
 */
public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public Optional<User> searchById(int id) {
        return userDao.searchById(id);
    }

    @Override
    public void remove(int id) throws ServiceException {
        try {
            userDao.remove(id);
        } catch (DaoException e) {
            throw new ServiceException("Add user is failed", e);
        }
    }

    @Override
    public ArrayList<User> showAll() {
        return userDao.showAll();
    }

    @Override
    public User addUser(String login, String password, String name, String lastName,
                        Date birthday, long telephone, String address) throws ServiceException {
        User user = new User();

        String utfLogin = new String(login.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String utfPassword = new String(password.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        user.setName(name);
        user.setLastName(lastName);
        user.setLogin(utfLogin);
        user.setPassword(PasswordCode.encode(utfPassword));
        user.setType(false);
        user.setBirthday(birthday);
        user.setTelephone(telephone);
        user.setAddress(address);

        try {
            userDao.add(user);
            return user;
        } catch (DaoException e) {
            throw new ServiceException("Add user is failed", e);
        }

    }

    @Override
    public void changePassword(int id, String password) throws ServiceException {
        try {
            userDao.changePassword(id, PasswordCode.encode(password));
        } catch (DaoException e) {
            throw new ServiceException("Change password is failed", e);
        }
    }

    @Override
    public void changeProf(int id, String name, String last, Date birth, long telephone, String address) throws ServiceException {
        try {
            userDao.changeProf(id, name, last, birth, telephone, address);
        } catch (DaoException e) {
            throw new ServiceException("Change profile is failed", e);
        }
    }


}