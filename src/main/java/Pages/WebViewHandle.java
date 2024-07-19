package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.Set;

public class WebViewHandle extends BaseScreen {
    Random random = new Random();

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
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortButton;
    @FindBy(xpath = "//footer[@class='footer']")
    private WebElement footer;
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement productsNumberInCart;
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipCodeField;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;
    @FindBy(xpath = "//h2[text()='Thank you for your order!']")
    private WebElement thankYouForOrderMessage;


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

    public WebViewHandle addProductToTheCartClick() {
        clickElement(addProductToCart);
        return this;
    }

    public boolean isProductShownInTheCart() {
        wait.until(ExpectedConditions.visibilityOf(removerProductFromCart));
        wait.until(ExpectedConditions.elementToBeClickable(removerProductFromCart));
        return true;
    }

    public WebViewHandle sortProductsBy() {
        wait.until(ExpectedConditions.visibilityOf(sortButton));
        Select dropdown = new Select(sortButton);
        int size1 = dropdown.getOptions().size();
        int i = random.nextInt(size1);
        dropdown.selectByIndex(i);
        return this;
    }

    public WebViewHandle sortButtonCLick() {
        clickElement(sortButton);
        return this;
    }

    public WebViewHandle scrollDownToFooter() {
        natives.swipeManyTimes(10);
        return this;
    }

    public String numberOfProducts() {
        String productsNumberInCartText = productsNumberInCart.getText();
        return productsNumberInCartText;
    }

    public WebViewHandle cartButtonClick() {
        clickElement(cartButton);
        return this;
    }

    public WebViewHandle checkoutButtonClick() {
        clickElement(checkoutButton);
        return this;
    }

    public WebViewHandle firstNameFieldFill(String firstName) {
        sendKeysToElement(firstNameField, firstName);
        return this;
    }

    public WebViewHandle lastNameFieldFill(String lastName) {
        sendKeysToElement(lastNameField, lastName);
        return this;
    }

    public WebViewHandle zipCodeFieldFill(String zipCode) {
        sendKeysToElement(zipCodeField, zipCode);
        return this;
    }

    public WebViewHandle continueButtonClick() {
        continueButton.click();
        return this;
    }
    public WebViewHandle finishButtonClick() {
        clickElement(finishButton);
        return this;
    }
    public String thankYouForOrderMessageText() {
        String message = thankYouForOrderMessage.getText();
        return message;
    }
    public String productsGetText() {
        String text = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        return text;
    }
}



