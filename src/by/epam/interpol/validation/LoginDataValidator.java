package by.epam.interpol.validation;

import java.util.regex.Pattern;

/**
 * The type Login data validator.
 */
public class LoginDataValidator
{
    private static final String LOGIN_REGEX = "^([A-Za-z0-9-]){3,15}$";

    /**
     * Login check boolean.
     *
     * @param login the login
     * @return the boolean
     */
    public static boolean loginCheck(String login)
    {
        return  Pattern.matches(LOGIN_REGEX, login);
    }

    /**
     * Password check boolean.
     *
     * @param password the password
     * @return the boolean
     */
    public static boolean passwordCheck(String password)
    {
        return  (!password.isEmpty() && password.length()<=20);
    }

}
