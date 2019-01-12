package by.epam.interpol.dao;

import by.epam.interpol.dao.CommonDao;
import by.epam.interpol.exception.DaoException;

import java.sql.Date;

public interface UserDao<T> extends CommonDao {
    T add(T t) throws DaoException;
    void changePassword(int id, String password) throws DaoException;
    void changeProf(int id, String name, String last, Date birth, long telephone, String address) throws DaoException;
}
