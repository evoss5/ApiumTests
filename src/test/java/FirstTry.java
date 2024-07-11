import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FirstTry {
    public AndroidDriver driver;

    @AndroidFindBy(accessibility = "longpress reset app\n")
//    @AndroidFindBy(uiAutomator = )
    private WebElement mainHeader;

    @BeforeTest
    public void setup() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiAutomator2");
        dc.setCapability("appium:app", "D://Appium//Apps//myDemoApp.apk");


        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
    }
    @Test
    public void test() {
//        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

//    @AfterTest
//    public void close() {
//        driver.quit();
//    }

}

