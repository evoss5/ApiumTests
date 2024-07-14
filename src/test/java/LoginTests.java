import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    public AndroidDriver driver;

    @Test
    public void unsuccessfulLogIn() {
        home.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.usernameFieldFill("maciek123@wp.pl");
        login.passwordFieldFill("maciej123!");
        login.loginButtonClick();
        Assert.assertTrue(login.IsPasswordErrorMessageVisible(), "There is no message");
    }

    @Test
    public void successfulLogIn() {
        home.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
    }
    @Test
    public void logOutFromAccount() {
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


}
