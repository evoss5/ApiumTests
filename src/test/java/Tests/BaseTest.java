package Tests;

import Pages.Native.HomeScreen;
import Pages.Native.LoginScreen;
import Pages.Native.NativeDeviceActions;
import Pages.Native.components.TopNavigationBar;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AndroidDriver driver;
    protected WebDriver webDriver;
    protected HomeScreen home;
    protected LoginScreen login;
    protected NativeDeviceActions navigate;
    protected TopNavigationBar topNavigationBar;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723";


        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiAutomator2");
        dc.setCapability("appium:app", "D://Appium//Apps//myDemoApp.apk");
        dc.setCapability("chromedriverExecutable", "C://driverForAppium/chromedriver.exe");
        dc.setCapability("locationServiceEnabled", true);
        dc.setCapability("locationServiceAuthorized", true);


        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
//        navigate = new NativeDeviceActions(driver);
        home = new HomeScreen(driver);




    }

    public void catalog() {
        HomeScreen homeScreen = new HomeScreen(driver);
    }



//    @AfterTest
//    public void close() {
//        driver.quit();
//    }
}

