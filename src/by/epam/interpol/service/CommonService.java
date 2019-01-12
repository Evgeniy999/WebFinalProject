package by.epam.interpol.service;

import by.epam.interpol.entity.User;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;

import java.util.ArrayList;
import java.util.Optional;

public interface CommonService<T> {

    Optional<T> searchById(int id);
    void remove(int id) throws ServiceException;
    ArrayList<T> showAll();
}
