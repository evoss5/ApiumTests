package Pages.Native.components;

import Pages.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class FooterNavigationBar extends BaseScreen {
    public FooterNavigationBar(AndroidDriver driver) {
        super(driver);
    }
    public FooterNavigationBar navigateBackButton() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        return this;
    }
    public FooterNavigationBar navigateHomeButton() {
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        return this;
    }
    public FooterNavigationBar recentAppsButton() {
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        return this;
    }
}
