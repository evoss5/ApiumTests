package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.SessionId;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;

public class NativeDeviceActions extends BaseScreen {

    public NativeDeviceActions(AndroidDriver driver) {
        super(driver);
    }

    public NativeDeviceActions navigateBackButton() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        return this;
    }

    public NativeDeviceActions navigateHomeButton() {
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        return this;
    }

    public NativeDeviceActions switchToRecentAppsButton() {
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        return this;
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

    public NativeDeviceActions swipeAction() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.10);

        PointerInput point = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(point, 1).addAction(point.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(point.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(point, Duration.ofMillis(200)))
                .addAction(point.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY))
                .addAction(point.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
        return this;
    }

    public NativeDeviceActions swipeManyTimes(int numberOfTimes) {
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
    }public NativeDeviceActions swipeWithCords(int xStart, int yStart, int xEnd, int yEnd) {
        PointerInput point = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(point, 1).addAction(point.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), xStart, yStart))
                .addAction(point.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(point, Duration.ofMillis(200)))
                .addAction(point.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), xEnd, yEnd))
                .addAction(point.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));
        return this;
}
    public NativeDeviceActions closeApp() {
        HashMap<String, Object> bundle = new HashMap<>();
        bundle.put("appId", "com.saucelabs.mydemoapp.rn");
        driver.executeScript("mobile: terminateApp", bundle);
        return this;
    }
}