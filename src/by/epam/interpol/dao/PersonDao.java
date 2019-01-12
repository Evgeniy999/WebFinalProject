package by.epam.interpol.dao;

import by.epam.interpol.entity.Person;
import by.epam.interpol.exception.DaoException;


import java.sql.Blob;
import java.sql.Date;

public interface PersonDao extends CommonDao<Person> {
    void addPerson(String name, String lastName, Date birth,int weight,int height, String hair, String nationality,
                   String sex, String characteristics, int status, Blob image) throws DaoException;
}
