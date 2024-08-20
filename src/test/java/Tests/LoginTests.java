package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends BaseTest {
    public CommonMethods commonMethods;



    @Test
    public void unsuccessfulLogIn() {
        login = home.goToLoginScreen();
        login.usernameFieldFill("maciek123@wp.pl");
        login.passwordFieldFill("maciej123!");
        login.loginButtonClick();
        Assert.assertTrue(login.IsPasswordErrorMessageVisible(), "There is no message");
    }

    @Test
    public void successfulLogIn() {
        login = home.goToLoginScreen();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible(), "Main banner is not visible");
    }
    @Test
    public void logOutFromAccount()  {
        login = home.goToLoginScreen();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.logOutFromAccount();
        home.logOutAcceptButtonClick();
        Assert.assertTrue(home.isSuccessfulyLoggedOutMessageVisible(), "Successfuly Logged Out messsage is not visible");
    }
    @Test
    private void logInByCredentials() throws IOException {
        login = home.goToLoginPage();
        commonMethods = new CommonMethods();
        login.usernameFieldFill(commonMethods.getCredential("loginNative"));
        login.passwordFieldFill(commonMethods.getCredential("passwordNative"));
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible(), "Main banner is not visible");
    }
}
