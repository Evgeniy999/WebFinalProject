package by.epam.interpol.util;

import by.epam.interpol.entity.Person;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

public class PersonBuilder {

    private static final String PERSON_ID = "person_id";
    private static final String PERSON_NAME = "person_name";
    private static final String PERSON_LAST = "person_lastName";
    private static final String PERSON_BIRTHDAY = "person_birthday";
    private static final String PERSON_STATUS = "status";
    private static final String PERSON_WEIGHT = "weight";
    private static final String PERSON_HEIGHT = "height";
    private static final String PERSON_COLOR_HAIR = "color_of_hair";
    private static final String PERSON_NATIONALITY = "nationality";
    private static final String PERSON_CHARACTERISTICS = "characteristics";
    private static final String PERSON_SEX = "sex";
    private static final String PERSON_PHOTO = "person_photo";


    public static Person createPerson(ResultSet resultSet) throws SQLException {
        int persId = resultSet.getInt(PERSON_ID);
        String name = resultSet.getString(PERSON_NAME);
        String last = resultSet.getString(PERSON_LAST);
        Date birth = resultSet.getDate(PERSON_BIRTHDAY);
        String status = resultSet.getString(PERSON_STATUS);
        int weight = resultSet.getInt(PERSON_WEIGHT);
        int height = resultSet.getInt(PERSON_HEIGHT);
        String hairColor = resultSet.getString(PERSON_COLOR_HAIR);
        String nationality = resultSet.getString(PERSON_NATIONALITY);
        String characteristics = resultSet.getString(PERSON_CHARACTERISTICS);
        String sex = resultSet.getString(PERSON_SEX);
        Blob photo = resultSet.getBlob(PERSON_PHOTO);

        String base64EncodedPhoto = null;
        if (photo != null) {
            base64EncodedPhoto = Base64.getEncoder().encodeToString(photo.getBytes(1, (int) photo.length()));
        }
        return new Person(persId, name, last, status,weight,height,
        hairColor, nationality,characteristics, birth, sex, base64EncodedPhoto,photo);
    }

    public static ArrayList<Person> createPersonAll(ResultSet resultSet) throws SQLException {
        ArrayList<Person> result = new ArrayList<>();
        while (resultSet.next()) {
            int persId = resultSet.getInt(PERSON_ID);
            String name = resultSet.getString(PERSON_NAME);
            String last = resultSet.getString(PERSON_LAST);
            Date birth = resultSet.getDate(PERSON_BIRTHDAY);
            String status = resultSet.getString(PERSON_STATUS);
            int weight = resultSet.getInt(PERSON_WEIGHT);
            int height = resultSet.getInt(PERSON_HEIGHT);
            String hairColor = resultSet.getString(PERSON_COLOR_HAIR);
            String nationality = resultSet.getString(PERSON_NATIONALITY);
            String characteristics = resultSet.getString(PERSON_CHARACTERISTICS);
            String sex = resultSet.getString(PERSON_SEX);
            Blob photo = resultSet.getBlob(PERSON_PHOTO);

            String base64EncodedPhoto = null;
            if (photo != null) {
                base64EncodedPhoto = Base64.getEncoder().encodeToString(photo.getBytes(1, (int) photo.length()));
            }
            result.add(new Person(persId, name, last, status, weight, height,
                    hairColor, nationality, characteristics, birth, sex, base64EncodedPhoto, photo));
        }
        return result;
    }

}
