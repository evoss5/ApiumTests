package Page.Native.component;

import Page.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroidActionBar extends BaseScreen {
    public AndroidActionBar(AndroidDriver driver) {
        super(driver);
    }
    public AndroidActionBar navigateBackButton() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        return this;
    }
    public AndroidActionBar navigateHomeButton() {
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        return this;
    }
    public AndroidActionBar recentAppsButton() {
        driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        return this;
    }
}
