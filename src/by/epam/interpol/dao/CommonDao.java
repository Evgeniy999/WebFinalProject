package by.epam.interpol.dao;

import by.epam.interpol.entity.User;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.exception.DaoException;

import java.util.ArrayList;
import java.util.Optional;

public interface CommonDao<T> {

    Optional<T> searchById(int id);
    T add(T t) throws DaoException;
    void remove(int id) throws DaoException;
    ArrayList<T> showAll();


}
