package Device.Action;

import Screen.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ScrollAction  extends BaseScreen {
    public ScrollAction(AndroidDriver driver) {
        super(driver);
    }

    public ScrollAction scrollToElementByText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
        return this;
    }
}

