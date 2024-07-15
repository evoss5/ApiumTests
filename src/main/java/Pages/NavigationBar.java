package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class NavigationBar extends BaseScreen {

    public NavigationBar(AndroidDriver driver) {
        super(driver);
    }

    public NavigationBar navigateBackButton() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        return this;
    }

    public NavigationBar navigateHomeButton() {
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        return this;
    }

    public NavigationBar switchToRecentAppsButton() {
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        return this;
    }
}
