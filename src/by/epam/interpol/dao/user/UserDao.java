package by.epam.interpol.dao.user;

import by.epam.interpol.dao.CommonDao;
import by.epam.interpol.exception.DaoException;

public interface UserDao<T> extends CommonDao {
    T add(T t) throws DaoException;
}
