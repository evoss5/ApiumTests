package Pages.Native;

import Pages.BaseScreen;
import Pages.WebView.WebViewHandle;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeScreen extends BaseScreen {
    public WebViewHandle webView;


    @AndroidFindBy(uiAutomator = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]\n")
    private WebElement mainBanner;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log In']\n")
    private WebElement logInButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add To Cart']\n")
    private WebElement addToCartButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='counter plus button']/android.widget.ImageView\n")
    private WebElement counterPlusButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='1']\n")
    private WebElement numberOfProducts;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log Out\")\n")        //
    private WebElement logOutButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")\n")
    private WebElement logOutAcceptButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']\n")
    private WebElement successfullyLoggedOutMessage;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView\n")
    private WebElement cartButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Api Calls']\n")
    private WebElement apiCallsButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Webview']\n")
    private WebElement webViewButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='URL input field']\n")
    private WebElement urlField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Go To Site button']\n")
    private WebElement goToSiteButton;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='About'])[1]\n")
    private WebElement aboutButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Product Highlights']\n")
    private WebElement productHighlightsText;



    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }


    public HomeScreen logInButtonClick() {
        clickElement(logInButton);
        return this;
    }

    public LoginScreen goToLoginPage() {
        clickElement(logInButton);
        return new LoginScreen(driver);
    }

    public HomeScreen chooseProductToBuy(String productName) {
        WebElement product = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text='" + productName + "']"));
        clickElement(product);
        return this;
    }

    public HomeScreen addToCartClick() {
        clickElement(addToCartButton);
        return this;
    }

    public void scrollDownToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
    }

    public void increaseNumberOfProductsBought() {
        clickElement(counterPlusButton);
    }

    public String checkIfNumberOfProductsIsNotEvenOne() {
        return driver.findElement(AppiumBy.xpath("\t\n" +
                "//android.widget.TextView[@text=\"1\"]")).getAttribute("text");
    }

    public boolean isMainBannerVisible() {
        wait.until(ExpectedConditions.visibilityOf(mainBanner));
        return true;
    }

    public HomeScreen logOutFromAccount() {
        clickElement(logOutButton);
        return this;
    }

    public HomeScreen logOutAcceptButtonClick() {
        clickElement(logOutAcceptButton);
        return this;
    }

    public boolean isSuccessfulyLoggedOutMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(successfullyLoggedOutMessage));
        return true;
    }

    public CartScreen goToCartPage() {
        clickElement(cartButton);
        return new CartScreen(driver);
    }

    public HomeScreen chooseProductsColor(String color) {
//        WebElement productColor = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='" + color + " circle']/android.view.ViewGroup\n"));
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='" + color + " circle']/android.view.ViewGroup\n")).click();

//        clickElement(productColor);
        return this;
    }

    public HomeScreen apiCallsButtonClick() {
        clickElement(apiCallsButton);
        return this;
    }

    public HomeScreen setRating(int rate) {
        driver.findElement(By.xpath("(//android.widget.TextView[@text=\"\uDB81\uDCCF\"])[" + rate + "]")).click();
        return this;
    }
    public boolean setRatingGetText(int rate) {
        driver.findElement(By.xpath("(//android.widget.TextView[@text=\"\uDB81\uDCCF\"])[" + rate + "]")).isDisplayed();
        return true;
    }

    public WebViewHandle goToWebView() {
        clickElement(webViewButton);
        return new WebViewHandle(driver);
    }

    public HomeScreen urlFieldFill() {
        sendKeysToElement(urlField, "https://www.saucedemo.com");
        return this;
    }

    public Pages.WebView.LoginScreen goToSiteButtonClick() {
        clickElement(goToSiteButton);
        webView = new WebViewHandle(driver);
        webView.switchToWebView();
        return new Pages.WebView.LoginScreen(driver);
    }
    public HomeScreen aboutButtonClick() {
        clickElement(aboutButton);
        return this;
    }
    public String productHighlightsGetText() {
        return productHighlightsText.getText();
    }
}




