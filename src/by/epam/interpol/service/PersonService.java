package by.epam.interpol.service;

import by.epam.interpol.entity.Person;
import by.epam.interpol.exception.ServiceException;

import java.sql.Blob;
import java.sql.Date;

public interface PersonService extends CommonService<Person> {
    void addPerson(String name, String lastName, Date birth, int weight, int height, String hair, String nationality,
                   String sex, String characteristics, int status, Blob imagePart) throws ServiceException;
}
