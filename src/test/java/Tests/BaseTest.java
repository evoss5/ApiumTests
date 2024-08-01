package Tests;

import Page.Native.HomeScreen;
import Page.Native.LoginScreen;
import Page.Native.NativeDeviceActions;
import Page.Native.component.TopNavigationBar;
import Page.WebView.ContextHandler;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AndroidDriver driver;
    protected HomeScreen home;
    protected LoginScreen login;
    protected NativeDeviceActions natives;
    protected ContextHandler webView;
    protected TopNavigationBar topNavigationBar;


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
        natives = new NativeDeviceActions(driver);
        home = new HomeScreen(driver);
        webView = new ContextHandler(driver);
        topNavigationBar = new TopNavigationBar(driver);
    }

//    @AfterTest
//    public void close() {
//        driver.quit();
//    }
}

