package by.epam.interpol.util;

import by.epam.interpol.entity.Document;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DocBuilder {
    private static final String DOC_ID = "document_id";
    private static final String DOC_STATEMENT = "status";
    private static final String DOC_TIME = "time";
    private static final String DOC_REWARD= "reward";
    private static final String DOC_INF = "doc_information";
    private static final String DOC_LEAD_TIME = "leadTime";


    public static Document createDoc(ResultSet resultSet) throws SQLException {
        int docId = resultSet.getInt(DOC_ID);
        String statement = resultSet.getString(DOC_STATEMENT);
        Date time = resultSet.getDate(DOC_TIME);
        double reward = resultSet.getDouble(DOC_REWARD);
        String information = resultSet.getString(DOC_INF);
        Date leadTime = resultSet.getDate(DOC_LEAD_TIME);
        return new Document(docId,statement,time,reward, information,leadTime);

    }

    public static ArrayList<Document> createDocAll(ResultSet resultSet) throws SQLException {
        ArrayList<Document> result = new ArrayList<>();

        while (resultSet.next()) {

            int docId = resultSet.getInt(DOC_ID);
            String statement = resultSet.getString(DOC_STATEMENT);
            Date time = resultSet.getDate(DOC_TIME);
            double reward = resultSet.getDouble(DOC_REWARD);
            String information = resultSet.getString(DOC_INF);
            Date leadTime = resultSet.getDate(DOC_LEAD_TIME);
            result.add(new Document(docId,statement,time,reward, information,leadTime));
        }

        return result;

    }

}
