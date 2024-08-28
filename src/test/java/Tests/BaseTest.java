package Tests;

import Screen.Native.HomeScreen;
import Screen.Native.LoginScreen;
import Component.DeviceAction;
import Component.TopNavigationBar;
import Device.Action.SwipeAction;
import Component.ContextHandler;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver driver;
    protected HomeScreen home;
    protected LoginScreen login;
    protected DeviceAction natives;
    protected CommonMethods commonMethods;
    protected ContextHandler webView;
    protected TopNavigationBar topNavigationBar;
    protected SwipeAction swipeAction;


    @BeforeMethod(alwaysRun = true)
    public void setup() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723";
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiAutomator2");
        dc.setCapability("appium:app", "D://Appium//Apps//myDemoApp.apk");
        dc.setCapability("chromedriverExecutable", "C://driverForAppium/chromedriver.exe");
        dc.setCapability("autoGrantPermissions", true);
        dc.setCapability("locationServiceEnabled", true);
        dc.setCapability("locationServiceAuthorized", true);

        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
        natives = new DeviceAction(driver);
        home = new HomeScreen(driver);
        commonMethods = new CommonMethods();
    }


//    @AfterTest
//    public void close() {
//        driver.quit();
//    }
}

