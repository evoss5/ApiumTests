import Pages.HomeScreen;
import Pages.LoginScreen;
import Pages.NativeDeviceActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AndroidDriver driver;

    @AndroidFindBy(accessibility = "longpress reset app\n")
//    @AndroidFindBy(uiAutomator = )
    private WebElement mainHeader;
    protected HomeScreen home;
    protected LoginScreen login;
    protected NativeDeviceActions navigate;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723";


        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiAutomator2");
        dc.setCapability("appium:app", "D://Appium//Apps//myDemoApp.apk");
        dc.setCapability("chromedriverExecutable", "C://driverForAppium/chromedriver.exe");




        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
        navigate = new NativeDeviceActions(driver);
        home = new HomeScreen(driver);

    }
//    @AfterTest
//    public void close() {
//        driver.quit();
//    }
}

