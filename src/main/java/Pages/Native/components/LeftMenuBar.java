package Pages.Native.components;

import Pages.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LeftMenuBar extends BaseScreen {
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='About'])[1]\n")
    private WebElement aboutButton;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.widget.ImageView[3]\n")
    private WebElement sauceDemoRobotLogo;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Drawing'])[1]\n")
    private WebElement drawingBar;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Clear']\n")
    private WebElement clearButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='menu item reset app']\n")
    private WebElement resetAppStateButton;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']\n")
    public WebElement resetAppStateWindowConfirmation;
    @AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']\n")
    private WebElement resetAppDoneConfirmation;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Sauce Bot Video\"]\n")
    private WebElement sauceBotVideoButton;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"video icon backward\"]\n")
    private WebElement videoBackwardButton;

    public LeftMenuBar(AndroidDriver driver) {
        super(driver);
    }
    public LeftMenuBar aboutButtonClick() {
        clickElement(aboutButton);
        return this;
    }
    public boolean isSauceDemoRobotLogoIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(sauceDemoRobotLogo));
        return true;
    }
    public  LeftMenuBar drawingButtonClick() {
        clickElement(drawingBar);
        return this;
    }
    public boolean isClearButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(clearButton));
        return true;
    }
    public LeftMenuBar resetAppStateButtonClick() {
        clickElement(resetAppStateButton);
        return this;
    }
    public LeftMenuBar resetAppStateWindowConfirmationClick() {
        clickElement(resetAppStateWindowConfirmation);
        return this;
    }
    public String resetAppGetText() {
         return resetAppDoneConfirmation.getText();
    }
    public LeftMenuBar sauceBoVideoButtonClick() {
        clickElement(sauceBotVideoButton);
        return this;
    }
}
