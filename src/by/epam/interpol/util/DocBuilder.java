package by.epam.interpol.util;

import by.epam.interpol.entity.Document;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

/**
 * The type Doc builder.
 */
public class DocBuilder {
    private static final String DOC_ID = "document_id";
    private static final String DOC_STATEMENT = "status";
    private static final String DOC_TIME = "time";
    private static final String DOC_REWARD = "reward";
    private static final String DOC_INF = "doc_information";
    private static final String DOC_LEAD_TIME = "leadTime";
    private static final String USER_NAME = "name_owner";
    private static final String USER_LAST = "lastName_owner";
    private static final String DOC_USER_PHOTO = "photo";


    /**
     * Create doc document.
     *
     * @param resultSet the result set
     * @return the document
     * @throws SQLException the sql exception
     */
    public static Document createDoc(ResultSet resultSet) throws SQLException {
        int docId = resultSet.getInt(DOC_ID);
        String statement = resultSet.getString(DOC_STATEMENT);
        Date time = resultSet.getDate(DOC_TIME);
        double reward = resultSet.getDouble(DOC_REWARD);
        String information = resultSet.getString(DOC_INF);
        Date leadTime = resultSet.getDate(DOC_LEAD_TIME);
        String name = resultSet.getString(USER_NAME);
        String lastName = resultSet.getString(USER_LAST);
        Blob photo = resultSet.getBlob(DOC_USER_PHOTO);
        String base64EncodedPhoto = null;
        if (photo != null) {
            base64EncodedPhoto = Base64.getEncoder().encodeToString(photo.getBytes(1, (int) photo.length()));
        }
        return new Document(docId, statement, time, reward, information, leadTime, name, lastName, photo, base64EncodedPhoto);

    }

    /**
     * Create doc all array list.
     *
     * @param resultSet the result set
     * @return the array list
     * @throws SQLException the sql exception
     */
    public static ArrayList<Document> createDocAll(ResultSet resultSet) throws SQLException {
        ArrayList<Document> result = new ArrayList<>();

        while (resultSet.next()) {
            int docId = resultSet.getInt(DOC_ID);
            String statement = resultSet.getString(DOC_STATEMENT);
            Date time = resultSet.getDate(DOC_TIME);
            double reward = resultSet.getDouble(DOC_REWARD);
            String information = resultSet.getString(DOC_INF);
            Date leadTime = resultSet.getDate(DOC_LEAD_TIME);
            String name = resultSet.getString(USER_NAME);
            String lastName = resultSet.getString(USER_LAST);
            Blob photo = resultSet.getBlob(DOC_USER_PHOTO);
            String base64EncodedPhoto = null;
            if (photo != null) {
                base64EncodedPhoto = Base64.getEncoder().encodeToString(photo.getBytes(1, (int) photo.length()));
            }
            result.add(new Document(docId, statement, time, reward, information, leadTime, name, lastName, photo, base64EncodedPhoto));
        }

        return result;

    }

}
