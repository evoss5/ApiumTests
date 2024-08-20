package Screen.Native;

import Component.*;
import Device.Action.AndroidActionBar;
import Device.Action.ScrollAction;
import Device.Action.SwipeAction;
import Screen.BaseScreen;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class HomeScreen extends BaseScreen {


    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(47)\n")
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


    public ContextHandler webView;
    public TopNavigationBar topNavigationBar;
    public AndroidActionBar androidActionBar;
    public LeftMenuBar leftMenuBar;
    public SwipeAction swipeAction;
    public ScrollAction scrollAction;


    public HomeScreen(AndroidDriver driver) {
        super(driver);
        this.topNavigationBar = new TopNavigationBar(driver);
        this.leftMenuBar = new LeftMenuBar(driver);
        this.androidActionBar = new AndroidActionBar(driver);
        this.webView = new ContextHandler(driver);
        this.natives = new DeviceAction(driver);
        this.swipeAction = new SwipeAction(driver);
        this.scrollAction = new ScrollAction(driver);
    }

    public HomeScreen logInButtonClick() {
        clickElement(logInButton);
        return this;
    }

    public LoginScreen goToLoginScreen() {
        topNavigationBar.hamburgerMenuClick();
        leftMenuBar.loginButtonClick();
        return new LoginScreen(driver);
    }

    public LoginScreen goToLoginPage() {
        clickElement(logInButton);
        return new LoginScreen(driver);
    }

    public HomeScreen chooseProductToBuy(String productName) {
        WebElement product = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text='" + productName + "']"));
        isElementVisible(product);
        clickElement(product);
        return this;
    }

    public HomeScreen addToCartClick() {
        scrollAction.scrollToElementByText("Add To Cart");
        clickElement(addToCartButton);
        return this;
    }

    public void scrollDownToText(String text) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
    }

    public void increaseNumberOfProductsBought() {
        scrollAction.scrollToElementByText("Add To Cart");
        clickElement(counterPlusButton);
    }

    public String checkIfNumberOfProductsIsNotEvenOne() {
        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"1\").instance(0)\n")).getText();
    }

    public boolean isMainBannerVisible() {
        isElementVisible(mainBanner);
        return true;
    }

    public HomeScreen logOutFromAccount() {
        webView.switchToNative();
        topNavigationBar.hamburgerMenuClick();
        clickElement(logOutButton);

        return this;
    }

    public HomeScreen logOutAcceptButtonClick() {
        clickElement(logOutAcceptButton);
        return this;
    }

    public boolean isSuccessfulyLoggedOutMessageVisible() {
        isElementVisible(successfullyLoggedOutMessage);
        return true;
    }

    public CartScreen goToCartPage() {
        clickElement(cartButton);
        return new CartScreen(driver);
    }

    public HomeScreen chooseProductsColor(String color) throws InterruptedException {
        WebElement productColor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc='" + color + " circle']/android.view.ViewGroup\n")));
        clickElement(productColor);
        return this;
    }

    public HomeScreen apiCallsButtonClick() {
        topNavigationBar.hamburgerMenuClick();
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

    public Screen.WebView.HomeScreen goToWebView() {
        topNavigationBar.hamburgerMenuClick();
        clickElement(webViewButton);
        return new Screen.WebView.HomeScreen(driver);
    }

    public HomeScreen urlFieldFill() {
        sendKeysToElement(urlField, "https://www.saucedemo.com");
        return this;
    }

    public Screen.WebView.LoginScreen goToSiteButtonClick() {
        clickElement(goToSiteButton);
        webView.switchToWebView();
        return new Screen.WebView.LoginScreen(driver);
    }

    public HomeScreen aboutButtonClick() {
        clickElement(aboutButton);
        return this;
    }

    public String productHighlightsGetText() {
        scrollAction.scrollToElementByText("Product Highlights");
        return elementGetText(productHighlightsText);
    }

    public ResetAppStatePopup goToResetAppState() {
        topNavigationBar.hamburgerMenuClick();
        leftMenuBar.resetAppStateButtonClick();
        return new ResetAppStatePopup(driver);
    }

    public SauceVideo goToSauceVideo() {
        topNavigationBar.hamburgerMenuClick();
        scrollAction.scrollToElementByText("Sauce Bot Video");
        leftMenuBar.sauceBoVideoButtonClick();
        webView.switchToWebView();
        return new SauceVideo(driver);
    }

    public LeftMenuBar goToAboutInfo() {
        topNavigationBar.hamburgerMenuClick();
        leftMenuBar.aboutButtonClick();
        return new LeftMenuBar(driver);
    }

    public LeftMenuBar goToDrawingMenu() {
        topNavigationBar.hamburgerMenuClick();
        leftMenuBar.drawingButtonClick();
        return new LeftMenuBar(driver);
    }

    public LeftMenuBar goToApiCalls() {
        topNavigationBar.hamburgerMenuClick();
        leftMenuBar.apiCallsButtonClick();
        return new LeftMenuBar(driver);
    }

    public LeftMenuBar goToQRCodeScanner() {
        topNavigationBar.hamburgerMenuClick();
        leftMenuBar.qrCodeScannerButtonClick();
        return new LeftMenuBar(driver);
    }

    public LeftMenuBar goToBiometricsMenu() {
        topNavigationBar.hamburgerMenuClick();
        leftMenuBar.biometricsMenuClick();
        return new LeftMenuBar(driver);
    }

    public HomeScreen randomProductClick() {
        List<WebElement> productList = driver.findElements(By.xpath("(//android.view.ViewGroup[@content-desc=\"store item\"])"));
        Random random = new Random();
        int listSize = random.nextInt(productList.size());
        WebElement list = productList.get(listSize);
        clickElement(list);
        return this;
    }

    public HomeScreen sortProductButtonClick() {
        topNavigationBar.sortButtonClick();
        topNavigationBar.sortProductsAscOrDesc();
        return this;
    }

    public HomeScreen randomProductClick2(String product) {
        WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='store item text' and @text='" + product + "']\n"));
        clickElement(element);
        return this;
    }
    public By randomThing() {
        return By.xpath("");   // TODO: 20.08.2024 Przykład metody z xPathem 
    }
    }









