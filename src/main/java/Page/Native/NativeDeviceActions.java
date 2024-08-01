package Page.Native;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
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
        System.out.println(size);
        return this;
    }

    public NativeDeviceActions getSessionId() {
        SessionId sessionId = driver.getSessionId();
        System.out.println(sessionId);
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

    public NativeDeviceActions swipeManyTimes(int numberOfTimes) {    // TODO: 01.08.2024  Zrobić osobną klasę na Swipy (łącznie ze swipem w WebViewHandler)
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.10);

        PointerInput point = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(point, 1)
                .addAction(point.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(point.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(point, Duration.ofMillis(200)))
                .addAction(point.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY))
                .addAction(point.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        for (int i = 0; i <= numberOfTimes; i++) {
            driver.perform(Collections.singletonList(swipe));

        }
        return this;
    }

    public NativeDeviceActions closeApp() {
        HashMap<String, Object> bundle = new HashMap<>();
        bundle.put("appId", "com.saucelabs.mydemoapp.rn");
        driver.executeScript("mobile: terminateApp", bundle);
        return this;
    }

    public NativeDeviceActions swipeManyTimes2(int numberOfTimes) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.90);

        PointerInput point = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(point, 1)
                .addAction(point.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(point.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(point, Duration.ofMillis(200)))
                .addAction(point.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY))
                .addAction(point.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        for (int i = 0; i <= numberOfTimes; i++) {
            driver.perform(Collections.singletonList(swipe));

        }
        return this;
    }
    public NativeDeviceActions scrollToElementByText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
        return this;
    }
}

// TODO: 01.08.2024 Zainstalować loggera!

