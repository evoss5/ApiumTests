package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(47)\n")
    private WebElement mainBanner;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"open menu\"]\n")
    private WebElement humbergerMenu;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Log In\"]\n")
    private WebElement logInButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add To Cart\"]\n")
    private WebElement addToCartButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView\n")
    private WebElement counterPlusButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"1\"]\n")
    private WebElement numberOfProducts;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log Out\")\n")
    private WebElement logOutButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")\n")
    private WebElement logOutAcceptButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]\n")
    private WebElement successfulyLoggedOutMessage;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView\n")
    private WebElement cartButton;


    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public HomePage hamburgerMenuClick() {
        clickElement(humbergerMenu);
        return this;
    }

    public HomePage logInButtonClick() {
        clickElement(logInButton);
        return this;
    }

    public LoginPage goToLoginPage() {
        clickElement(logInButton);
        return new LoginPage(driver);
    }

    public HomePage chooseProductToBuy(String productName) {
        WebElement product = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"store item text\" and @text='" + productName + "']"));
        clickElement(product);
        return this;
    }

    public HomePage addToCartClick() {
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
        String text = driver.findElement(AppiumBy.xpath("\t\n" +
                "//android.widget.TextView[@text=\"1\"]")).getAttribute("text");
        return text;
    }
    public boolean isMainBannerVisible() {
         wait.until(ExpectedConditions.visibilityOf(mainBanner));
         return true;
    }
    public HomePage logOutFromAccount() {
        clickElement(logOutButton);
        return this;
    }
    public HomePage logOutAcceptButtonClick() {
        clickElement(logOutAcceptButton);
        return this;
    }
    public boolean isSuccessfulyLoggedOutMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(successfulyLoggedOutMessage));
        return true;
    }
    public CartPage goToCartPage() {
        clickElement(cartButton);
        return new CartPage(driver);
    }
}
