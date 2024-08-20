package Device.Action;

import Component.DeviceAction;
import Screen.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class SwipeAction extends BaseScreen {
    public SwipeAction(AndroidDriver driver) {
        super(driver);
        natives = new DeviceAction(driver);
    }

    public SwipeAction swipeUp(int numberOfTimes) {
        swipeIt(numberOfTimes, 0.90);
        return this;
    }

    public SwipeAction swipeDown(int numberOfTimes) {
        swipeIt(numberOfTimes, 0.20);
        return this;
    }

    private SwipeAction swipeIt(int numberOfTimes, double upOrDown) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.getWidth() / 2;
        int startY = size.getHeight() / 2;
        int endX = startX;
        int endY = (int) (size.getHeight() * upOrDown);

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
}