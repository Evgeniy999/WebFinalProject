package by.epam.interpol.service.user;

import by.epam.interpol.coding.PasswordCode;
import by.epam.interpol.dao.user.UserDaoImpl;
import by.epam.interpol.entity.User;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import by.epam.interpol.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl implements UserService {
    private static Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    private UserDaoImpl userDaoImpl = new UserDaoImpl();

    @Override
    public Optional<User> searchById(int id) {
        return userDaoImpl.searchById(id);
    }

    @Override
    public void remove(int id) throws DaoException {
        userDaoImpl.remove(id);
    }

    @Override
    public ArrayList<User> showAll() {
        return userDaoImpl.showAll();
    }

    @Override
    public User addUser(String login, String password, String name, String lastName,
                        Date birthday, long telephone, String address) throws DaoException {
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
            userDaoImpl.add(user);
            return user;
        } catch (DaoException e) {
            throw new DaoException("Registration is failed", e);
        }

    }

    @Override
    public void changePassword(int id, String password) throws DaoException {
        userDaoImpl.changePassword(id,PasswordCode.encode(password));
    }


}