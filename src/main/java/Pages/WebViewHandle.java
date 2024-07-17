package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class WebViewHandle extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"URL input field\"]\n")
    private WebElement URLField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Go To Site button\"]\n")
    private WebElement goToSiteButton;
    @AndroidFindBy(xpath = "//div[@class='login_logo']")
    private WebElement mainHeader;
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartButton;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addProductToCart;
    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    private WebElement removerProductFromCart;


    public WebViewHandle(AndroidDriver driver) {
        super(driver);
    }

    public WebViewHandle urlFieldFill() {
//        clickElement(URLField);
        sendKeysToElement(URLField, "https://www.saucedemo.com");
        return this;
    }

    public WebViewHandle goToSiteButtonClick() {
        clickElement(goToSiteButton);
        return this;
    }

    public WebViewHandle userNameFieldFill(String username) {
        sendKeysToElement(userNameField, username);
        return this;
    }

    public WebViewHandle passwordField(String password) {
        sendKeysToElement(passwordField, password);
        return this;
    }

    public WebViewHandle loginButtonCLick() {
        clickElement(loginButton);
        return this;
    }

    public boolean isCartButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(cartButton));
        return true;
    }

    public WebViewHandle switchToWebView() {
        Set<String> contextNames = driver.getContextHandles();
        String lastContextView = (String) contextNames.toArray()[contextNames.size() - 1];

        if (lastContextView.contains("WEBVIEW_") || lastContextView.contains("WEBVIEW_com.xxxxxx.android.mobile.xxxxx")) {
            driver.context(lastContextView);
        }
        return this;
    }

    public WebViewHandle switchBackToNative() {
        Set<String> contextNames = driver.getContextHandles();
        String lastContextView = (String) contextNames.toArray()[contextNames.size() - 1];
        if (lastContextView.contains("WEBVIEW_")) {
            driver.context("NATIVE_APP");
        }
        return this;
    }

        public WebViewHandle addProductToTheCartClick () {
            clickElement(addProductToCart);
            return this;
        }

        public boolean isProductShownInTheCart () {
            wait.until(ExpectedConditions.visibilityOf(removerProductFromCart));
            wait.until(ExpectedConditions.elementToBeClickable(removerProductFromCart));
            return true;
        }
    }


