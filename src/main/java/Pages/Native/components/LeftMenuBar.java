package Pages.Native.components;

import Pages.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
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

    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Sauce Bot Video\"]\n")
    private WebElement sauceBotVideoButton;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"video icon backward\"]\n")
    private WebElement videoBackwardButton;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Api Calls\"]\n")
    private WebElement apiCallsButton;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"API calls\"]\n")
    private WebElement apiCallsIcon;
    @AndroidFindBy(accessibility = "menu item log in")
    private WebElement logInButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"QR Code Scanner\"]\n")
    private WebElement qrCodeScanner;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FingerPrint\"]\n")
    private WebElement biometricsMenuButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]\n")
    private WebElement biometricMessage;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]\n")
    private WebElement biometricOkMessage;

    public LeftMenuBar(AndroidDriver driver) {
        super(driver);
    }
    public LeftMenuBar aboutButtonClick() {
        clickElement(aboutButton);
        return this;
    }

    public LeftMenuBar loginButtonClick() {
        clickElement(logInButton);
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


    public LeftMenuBar sauceBoVideoButtonClick() {
        clickElement(sauceBotVideoButton);
        return this;
    }
    public LeftMenuBar apiCallsButtonClick() {
        clickElement(apiCallsButton);
        return this;
    }
    public boolean isApiCallsLogoVisible() {
        wait.until(ExpectedConditions.visibilityOf(apiCallsIcon));
        return true;
    }
    public ResetAppStatePopup resetAppStateButtonClick() {
        clickElement(resetAppStateButton);
        return new ResetAppStatePopup(driver);
    }
    public LeftMenuBar qrCodeScannerButtonClick() {
        clickElement(qrCodeScanner);
        return this;
    }
    public LeftMenuBar biometricsMenuClick() {
        clickElement(biometricsMenuButton);
        return this;
    }
    public String biometricMesssage() {
        if (biometricMessage.isDisplayed()) {
            clickElement(biometricOkMessage);
        }
        String text = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Allow login with FingerPrint\"]\n")).getText();
        return text;
    }

}
