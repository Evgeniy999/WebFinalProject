package by.epam.interpol.validation;

import java.util.regex.Pattern;

public class LoginDataValidator
{
    private static final String LOGIN_REGEX = "^([A-Za-z0-9-]){3,15}$";

    public static boolean loginCheck(String login)
    {
        return  Pattern.matches(LOGIN_REGEX, login);
    }

    public static boolean passwordCheck(String password)
    {
        return  (!password.isEmpty() && password.length()<=20);
    }

}
