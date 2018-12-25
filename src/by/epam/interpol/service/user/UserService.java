package by.epam.interpol.service.user;

import by.epam.interpol.coding.PasswordCode;
import by.epam.interpol.dao.user.UserDao;
import by.epam.interpol.entity.User;
import by.epam.interpol.exception.ApplicationException;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserService implements UserServiceInterface {
    private static Logger LOGGER = LogManager.getLogger(UserService.class);

    private UserDao userDao = new UserDao();

    @Override
    public Optional<User> searchById(int id) {
        return userDao.searchById(id);
    }

    @Override
    public Optional<User> searchUserByLogin(String login) {
        return userDao.searchUserByLogin(login);
    }

    @Override
    public User addUser(String login, String password, String name, String lastName,
                        Date birthday, long telephone, String address) throws ApplicationException {
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
        } catch (ApplicationException e) {
            throw new ApplicationException("Registration is failed", e);
        }

    }


}