package by.epam.interpol.service.document;

import by.epam.interpol.dao.document.DocumentDao;
import by.epam.interpol.entity.Document;
import by.epam.interpol.exception.ApplicationException;
import by.epam.interpol.exception.DaoException;
import by.epam.interpol.service.CommonService;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Optional;

public class DocServiceImpl implements DocService {

    private DocumentDao documentDao = new DocumentDao();

    @Override
    public Optional<Document> searchById(int id) {
        return documentDao.searchById(id);
    }

    @Override
    public void remove(int id) throws DaoException {
        documentDao.remove(id);
    }

    @Override
    public ArrayList<Document> showAll() {
        return documentDao.showAll();
    }

    @Override
    public void addDoc(String statement, Date time, double reward, String information, Date leadTime, String name,
                       String lastName, Part imagePart) throws DaoException {
        try {
//
//            Document document = new Document();
//            document.setName(name);
//            document.setLastName(lastName);
//            document.setStatement(statement);
//            document.setTime(time);
//            document.setLeadTime(leadTime);
//            document.setReward(reward);
//            document.setInformation(information);

            //set encoded photo
//            int fileSize = (int) imagePart.getSize();
//            byte[] photo = new byte[fileSize];
//            imagePart.getInputStream().read(photo, 0, fileSize);
//            document.setEncodedPhoto(Base64.getEncoder().encodeToString(photo));
//            //set photo
//            document.setPhoto();
//            InputStream inputStream = imagePart.getInputStream();
//            Blob blob;
//            blob.setBytes(fileSize, photo);
//            documentDao.add(document);
//            return document;
            InputStream inputStream = imagePart.getInputStream();
            documentDao.addDocument(statement, time, reward, information, leadTime, name, lastName, inputStream);
        } catch (DaoException | IOException e) {
            throw new DaoException("Add document is failed", e);
        }

    }
}
