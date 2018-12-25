package by.epam.interpol.service;

import by.epam.interpol.entity.User;

import java.util.Optional;

public interface CommonService<T> {

    Optional<T> searchById(int id);

}
