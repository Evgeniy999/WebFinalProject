package by.epam.interpol.service.impl;

import by.epam.interpol.dao.PersonDao;
import by.epam.interpol.dao.impl.PersonDaoImpl;
import by.epam.interpol.entity.Person;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.exception.ServiceException;
import by.epam.interpol.service.PersonService;


import java.sql.Blob;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Optional;

/**
 * The type Person service.
 */
public class PersonServiceImpl implements PersonService {

    private PersonDaoImpl personDao = new PersonDaoImpl();

    @Override
    public void addPerson(String name, String lastName, Date birth, int weight, int height, String hair, String nationality,
                          String sex, String characteristics, int status, Blob imagePart) throws ServiceException {
        try {
            personDao.addPerson(name, lastName, birth, weight, height, hair, nationality, sex, characteristics, status, imagePart);
        } catch (DaoException e) {
            throw new ServiceException("Add document is failed", e);
        }

    }

    @Override
    public Optional<Person> searchById(int id) {
        return personDao.searchById(id);
    }

    @Override
    public void remove(int id) throws ServiceException {
        try {
            personDao.remove(id);
        } catch (DaoException e) {
            throw new ServiceException("Delete Person is failed");
        }
    }

    @Override
    public ArrayList<Person> showAll() {
        return personDao.showAll();
    }
}
