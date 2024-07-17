import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends BaseTest {
    public AndroidDriver driver;
    public Service service;

    @Test
    public void unsuccessfulLogIn() {
        home.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.usernameFieldFill("maciek123@wp.pl");
        login.passwordFieldFill("maciej123!");
        login.loginButtonClick();
        Assert.assertTrue(login.IsPasswordErrorMessageVisible(), "There is no message");
    }

    @Test(groups = {"group1"})
    public void successfulLogIn() {
        home.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
    }
    @Test
    public void logOutFromAccount()  {
        home.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.hamburgerMenuClick();
        home.logOutFromAccount();
        home.logOutAcceptButtonClick();
        Assert.assertTrue(home.isSuccessfulyLoggedOutMessageVisible(), "Successfuly Logged Out messsage is not visible");
    }
    @Test
    private void logInByCredentials() throws IOException {
        home.hamburgerMenuClick();
        login = home.goToLoginPage();
        service = new Service(driver);
        login.usernameFieldFill(service.getCredential("loginNative"));
        login.passwordFieldFill(service.getCredential("passwordNative"));
        login.loginButtonClick();
    }


}
