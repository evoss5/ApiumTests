import Pages.HomePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    public AndroidDriver driver;

    @Test
    public void loginAsUser() {
        home.mainHeaderClick();
        login = home.goToLoginPage();
        login.usernameFieldFill("maciek123@wp.pl");
        login.passwordFieldFill("maciej123!");
        login.loginButtonClick();
        Assert.assertTrue(login.IsPasswordErrorMessageVisible(), "There is no message");
    }
}
