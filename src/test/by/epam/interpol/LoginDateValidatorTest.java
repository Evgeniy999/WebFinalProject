package test.by.epam.interpol;

import by.epam.interpol.validation.LoginDataValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The type Login date validator test.
 */
public class LoginDateValidatorTest {


    /**
     * Test validate login true.
     *
     * @param login the login
     */
    @Test(dataProvider = "testValidateTrueDataLogin")
    public void testValidateLoginTrue(String login) {
        Assert.assertTrue(LoginDataValidator.loginCheck(login));

    }

    /**
     * Test validate true data login object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "testValidateTrueDataLogin")
    public Object[][] testValidateTrueDataLogin() {
        return new Object[][]{
                {"ALEX229"},
                {"Evgeniy99"},
                {"Lol123"},
                {"Asd234"},
                {"Bobi223"},
        };
    }

    /**
     * Test validate password true.
     *
     * @param password the password
     */
    @Test(dataProvider = "testValidateTrueDataPassword")
    public void testValidatePasswordTrue(String password) {
        Assert.assertTrue(LoginDataValidator.passwordCheck(password));

    }

    /**
     * Test validate true data password object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "testValidateTrueDataPassword")
    public Object[][] testValidateTrueDataPassword() {
        return new Object[][]{
                {"12331222"},
                {"123123412412"},
        };
    }

    /**
     * Test validate login false.
     *
     * @param login the login
     */
    @Test(dataProvider = "testValidateFalseDataLogin")
    public void testValidateLoginFalse(String login) {
        Assert.assertFalse(LoginDataValidator.loginCheck(login));

    }

    /**
     * Test validate false data login object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "testValidateFalseDataLogin")
    public Object[][] testValidateFalseDataLogin() {
        return new Object[][]{
                {"ALEX2292222222222222222222221"},
                {"Ev"},
                {"Lol123123!!!!!!"},
                {"Asd234ewr@#"},
                {"Bobi223!@&^"},
        };
    }

    /**
     * Test validate false date.
     *
     * @param password the password
     */
    @Test(dataProvider = "testValidateFalseDataPassword")
    public void testValidateFalseDate(String password) {
        Assert.assertFalse(LoginDataValidator.passwordCheck(password));

    }

    /**
     * Test validate false data password object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "testValidateFalseDataPassword")
    public Object[][] testValidateFalseDataPassword() {
        return new Object[][]{
                {"123312rrrrrrrrrrrrrrrrrrrrrrrrrrrrr"},
                {"1231231231232131231232131231231232131"},
        };
    }

}
