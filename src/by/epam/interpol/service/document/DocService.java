package by.epam.interpol.service.document;

import by.epam.interpol.dao.document.DocumentDao;
import by.epam.interpol.entity.Document;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.service.CommonService;

import java.util.ArrayList;
import java.util.Optional;

public class DocService implements CommonService<Document> {

    private DocumentDao documentDao = new DocumentDao();

    @Override
    public Optional<Document> searchById(int id) {
        return documentDao.searchById(id);
    }

    @Override
    public void remove(int id) throws DaoException {

    }

    @Override
    public ArrayList<Document> showAll() {
        return documentDao.showAll();
    }
}
