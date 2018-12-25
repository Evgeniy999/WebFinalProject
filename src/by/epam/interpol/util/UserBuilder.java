package by.epam.interpol.util;


import by.epam.interpol.entity.User;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserBuilder {
    private static final String USER_ID = "user_id";
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";
    private static final String USER_NAME = "user_name";
    private static final String USER_LAST = "user_lastName";
    private static final String USER_TYPE = "type";
    private static final String USER_BIRTHDAY = "user_birthday";
    private static final String USER_TELEPHONE = "telephone";
    private static final String USER_ADDRESS = "address";


    public static User createUser(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt(USER_ID);
        String login = resultSet.getString(USER_LOGIN);
        String password = resultSet.getString(USER_PASSWORD);
        String name = resultSet.getString(USER_NAME);
        String lastName = resultSet.getString(USER_LAST);
        Boolean type = resultSet.getBoolean(USER_TYPE);
        Date birthday = resultSet.getDate(USER_BIRTHDAY);
        long telephone = resultSet.getLong(USER_TELEPHONE);
        String address = resultSet.getString(USER_ADDRESS);
        return new User(userId, login, password, name, lastName,  birthday, telephone, address,type);

    }

    public static ArrayList<User> createUsers(ResultSet resultSet) throws SQLException {
        ArrayList<User> result = new ArrayList<>();

        while (resultSet.next()) {

            int userId = resultSet.getInt(USER_ID);
            String login = resultSet.getString(USER_LOGIN);
            String password = resultSet.getString(USER_PASSWORD);
            String name = resultSet.getString(USER_NAME);
            String lastName = resultSet.getString(USER_LAST);
            Boolean type = resultSet.getBoolean(USER_TYPE);
            Date birthday = resultSet.getDate(USER_BIRTHDAY);
            long telephone = resultSet.getLong(USER_TELEPHONE);
            String address = resultSet.getString(USER_ADDRESS);

            result.add(new User(userId, login, password, name, lastName,  birthday, telephone, address,type));
        }

        return result;

    }

}
