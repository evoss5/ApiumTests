package Page;

import Page.Native.NativeDeviceActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class Utilities extends BaseScreen {
    public Utilities(AndroidDriver driver) {
        super(driver);
        natives = new NativeDeviceActions(driver);
    }

    public Utilities swipeUp(int numberOfTimes) {
        swipeIt(numberOfTimes);
        return this;
    }

    public Utilities swipeDown(int numberOfTimes) {
        swipeIt(numberOfTimes);
        return this;
    }

    private Utilities swipeIt(int numberOfTimes) {
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
}
