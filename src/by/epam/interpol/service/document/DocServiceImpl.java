package by.epam.interpol.service.document;

import by.epam.interpol.dao.document.DocumentDao;
import by.epam.interpol.entity.Document;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.service.CommonService;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

public class DocServiceImpl implements DocService {

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

    @Override
    public Document addDoc(String statement, Date time, double reward, String information, Date leadTime, String name, String lastName) throws DaoException {
        Document document = new Document();
        document.setName(name);
        document.setLastName(lastName);
        document.setStatement(statement);
        document.setTime(time);
        document.setLeadTime(leadTime);
        document.setReward(reward);
        document.setInformation(information);
        try {
            documentDao.add(document);
            return document;
        } catch (DaoException e) {
            throw new DaoException("Registration is failed", e);
        }

    }
}
