package Page.Native;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class NativeDeviceActions {

    public AndroidDriver driver;
    protected WebDriverWait wait;
    private static final int TIMEOUT = 5;

    public NativeDeviceActions(AndroidDriver driver) {
        this.driver = driver;

    }

    public NativeDeviceActions getScreenSize() {
        Dimension size = driver.manage().window().getSize();
        return this;
    }

    public NativeDeviceActions getSessionId() {
        SessionId sessionId = driver.getSessionId();
        return this;
    }

    public NativeDeviceActions lockDevice() {
        driver.lockDevice();
        return this;
    }

    public NativeDeviceActions unlockDevice() {
        driver.unlockDevice();
        return this;
    }

    public NativeDeviceActions closeApp() {
        HashMap<String, Object> bundle = new HashMap<>();
        bundle.put("appId", "com.saucelabs.mydemoapp.rn");
        driver.executeScript("mobile: terminateApp", bundle);
        return this;
    }

    public NativeDeviceActions scrollToElementByText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
        return this;
    }
}



