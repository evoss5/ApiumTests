package Tests;

import Pages.Native.components.TopNavigationBar;
import Pages.WebView.WebViewHandle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTests extends BaseTest {
    public Service service;
    public WebViewHandle webView;
    public TopNavigationBar topNavigationBar;


    @Test
    public void unsuccessfulLogIn() {
//        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.usernameFieldFill("maciek123@wp.pl");
        login.passwordFieldFill("maciej123!");
        login.loginButtonClick();
        Assert.assertTrue(login.IsPasswordErrorMessageVisible(), "There is no message");
    }

    @Test
    public void successfulLogIn() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
    }
    @Test
    public void logOutFromAccount()  {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        home.logOutFromAccount();
        home.logOutAcceptButtonClick();
        Assert.assertTrue(home.isSuccessfulyLoggedOutMessageVisible(), "Successfuly Logged Out messsage is not visible");
    }
    @Test
    private void logInByCredentials() throws IOException {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        login = home.goToLoginPage();
        service = new Service(driver);
        login.usernameFieldFill(service.getCredential("loginNative"));
        login.passwordFieldFill(service.getCredential("passwordNative"));
        login.loginButtonClick();
    }
}
