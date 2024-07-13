import Pages.HomePage;
import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AndroidDriver driver;

    @AndroidFindBy(accessibility = "longpress reset app\n")
//    @AndroidFindBy(uiAutomator = )
    private WebElement mainHeader;
    protected HomePage home;
    protected LoginPage login;

    @BeforeTest
    public void setup() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723";


        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiAutomator2");
        dc.setCapability("appium:app", "D://Appium//Apps//myDemoApp.apk");

        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
        home = new HomePage(driver);

    }

    @Test
    public void test() {
//   driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        home.mainHeaderClick();
        login = home.goToLoginPage();
        login.usernameFieldFill("maciek123@wp.pl");
        login.passwordFieldFill("maciej123!");
        login.loginButtonClick();
        Assert.assertTrue(login.IsPasswordErrorMessageVisible(), "There is no message");

    }

//    @AfterTest
//    public void close() {
//        driver.quit();
//    }

}

