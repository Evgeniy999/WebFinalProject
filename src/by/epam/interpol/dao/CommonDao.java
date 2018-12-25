package by.epam.interpol.dao;

import by.epam.interpol.entity.User;
import by.epam.interpol.exception.ApplicationException;

import java.util.Optional;

public interface CommonDao<T> {

    Optional<T> searchById(int id);
    T add(T t) throws ApplicationException;

}
