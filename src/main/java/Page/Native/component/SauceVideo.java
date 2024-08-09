package Page.Native.component;

import Page.BaseScreen;
import Page.WebView.ContextHandler;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SauceVideo extends BaseScreen {

    public WebDriver WebDriver;
    public ContextHandler webView;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"video icon backward\"]\n")
    private WebElement videoBackwardButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"video icon play\"]")
    private WebElement videoPlayButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"video icon forward\"]\n")
    private WebElement videoForwardButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"video icon volume-up\"]\n")
    private WebElement videoVolumeUp;
    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Full screen\"]\n")
    private WebElement fullScreenButton;
    @AndroidFindBy(xpath = "//button[@aria-label=\"Show cards\"]")
    private WebElement dotButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"video icon stop\"]\n")
    private WebElement videoStopButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"video icon volume-mute\"]\n")
    private WebElement muteSoundIcon;
    @AndroidFindBy(xpath = "//button[@title='Exit full screen']")
    private WebElement exitFullscreenButton;
    @AndroidFindBy(tagName = "iframe")
    private WebElement iframe;


    public SauceVideo(AndroidDriver driver) {
        super(driver);
        this.webView = new ContextHandler(driver);
    }

    public SauceVideo videoBackwardButtonClick() {
        clickElement(videoBackwardButton);
        return this;
    }

    public SauceVideo videoPlayButtonClick() {
        clickElement(videoPlayButton);
        return this;
    }

    public SauceVideo videoForwardButtonClick() {

        driver.switchTo().defaultContent();
        webView.switchBackToNative();
        clickElement(videoForwardButton);
        return this;
    }

    public SauceVideo videoVolumeUpClick() {
        clickElement(videoVolumeUp);
        return this;
    }

    public SauceVideo fullScreenClick() {

        clickElement(fullScreenButton);
        return this;
    }

    public SauceVideo dotButtonClick() {
        WebElement element = WebDriver.findElement(By.tagName("iframe"));
        WebDriver.switchTo().frame(element);
        clickElement(dotButton);
        return this;
    }

    public SauceVideo videoStopButtonClick() {
        clickElement(videoStopButton);
        return this;
    }

    public boolean isPlayButtonVisible() {
        isElementVisible(videoPlayButton);
        return true;
    }

    public boolean isMuteSoundIconVisible() {
        isElementVisible(muteSoundIcon);
        return true;
    }

    public String timeGetText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("\"android.view.View\\n\""))).getText();
    }

    public SauceVideo exitFullscreenButtonClick() {
        clickElement(exitFullscreenButton);
        return this;
    }

    public int checkTime() {
        String startTime = timeGetText();
        int i = convertTimeToSeconds(startTime);//sprawdzić czy to jest TimeStamp czy DateTime
        System.out.println(i);
        videoForwardButtonClick();
        String endTime = timeGetText();
        int i1 = convertTimeToSeconds(endTime);
        System.out.println(i1);
        // endTime - startTime = 0 : 15;
        int timeDifference = i1 - i;
        return timeDifference;
    }

    private static int convertTimeToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    public double getCurrentVideoTime() {
        webView.switchToWebView();
        WebElement element = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (double) js.executeScript(
                "return document.querySelector('video').currentTime;"
        );
    }
}

