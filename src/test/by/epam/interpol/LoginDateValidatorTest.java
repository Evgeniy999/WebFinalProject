package test.by.epam.interpol;

import by.epam.interpol.validation.LoginDataValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDateValidatorTest {


    @Test(dataProvider = "testValidateTrueDataLogin")
    public void testValidateLoginTrue(String login) {
       Assert.assertTrue(LoginDataValidator.loginCheck(login));

    }
    @DataProvider(name = "testValidateTrueDataLogin")
    public Object[][] testValidateTrueDataLogin(){
        return new Object[][]{
                {"ALEX229"},
                {"Evgeniy99"},
                {"Lol123"},
                { "Asd234"},
                { "Bobi223"},
        };
    }

    @Test(dataProvider = "testValidateTrueDataPassword")
    public void testValidatePasswordTrue(String password) {
        Assert.assertTrue(LoginDataValidator.passwordCheck(password));

    }
    @DataProvider(name = "testValidateTrueDataPassword")
    public Object[][] testValidateTrueDataPassword(){
        return new Object[][]{
                {"12331222"},
                {"123123412412"},
        };
    }

    @Test(dataProvider = "testValidateFalseDataLogin")
    public void testValidateLoginFalse(String login) {
        Assert.assertFalse(LoginDataValidator.loginCheck(login));

    }
    @DataProvider(name = "testValidateFalseDataLogin")
    public Object[][] testValidateFalseDataLogin(){
        return new Object[][]{
                {"ALEX2292222222222222222222221"},
                {"Ev"},
                {"Lol123123!!!!!!"},
                { "Asd234ewr@#"},
                { "Bobi223!@&^"},
        };
    }

    @Test(dataProvider = "testValidateFalseDataPassword")
    public void testValidateFalseDate(String password) {
        Assert.assertFalse(LoginDataValidator.passwordCheck(password));

    }
    @DataProvider(name = "testValidateFalseDataPassword")
    public Object[][] testValidateFalseDataPassword(){
        return new Object[][]{
                {"123312rrrrrrrrrrrrrrrrrrrrrrrrrrrrr"},
                {"1231231231232131231232131231231232131"},
        };
    }

}
