package Component;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class DeviceAction {

    public AndroidDriver driver;
    protected WebDriverWait wait;
    private static final int TIMEOUT = 5;

    public DeviceAction(AndroidDriver driver) {
        this.driver = driver;

    }

    public DeviceAction getScreenSize() {
        Dimension size = driver.manage().window().getSize();
        return this;
    }

    public DeviceAction getSessionId() {
        SessionId sessionId = driver.getSessionId();
        return this;
    }

    public DeviceAction lockDevice() {
        driver.lockDevice();
        return this;
    }

    public DeviceAction unlockDevice() {
        driver.unlockDevice();
        return this;
    }

    public DeviceAction closeApp() {
        HashMap<String, Object> bundle = new HashMap<>();
        bundle.put("appId", "com.saucelabs.mydemoapp.rn");
        driver.executeScript("mobile: terminateApp", bundle);
        return this;
    }
}





