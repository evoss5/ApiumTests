package Screen.Native;

import Device.Action.ScrollAction;
import Screen.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CartScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Remove Item']\n")
    private WebElement removeItemButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No Items']\n")
    private WebElement noItemsInCartMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Proceed To Checkout']\n")
    private WebElement proceedToCheckoutButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Full Name* input field']\n")
    private WebElement nameField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Address Line 1* input field']\n")
    private WebElement addressLine;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='City* input field']\n")
    private WebElement cityField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='To Payment']\n")
    private WebElement goToPaymentButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Please provide your country.']\n")
    private WebElement provideYourCountryMessage;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Zip Code* input field']\n")
    private WebElement zipCodeField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Country* input field']\n")
    private WebElement countyField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You will not be charged until you review your purchase on the next screen.']\n")
    private WebElement enterPaymentMethodMessage;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Full Name* input field']\n")
    private WebElement fullNameField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Card Number* input field']\n")
    private WebElement paymentCardField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Expiration Date* input field']\n")
    private WebElement expirationDateField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Security Code* input field']")
    private WebElement securityCodeField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Review Order button']\n")
    private WebElement reviewOrderButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Place Order']\n")
    private WebElement placeOrderButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Checkout Complete']\n")
    private WebElement checkoutCompleteMessage;
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement productsNumberInCart;
    @AndroidFindBy(id = "product label\n")
    private WebElement productLabel;

    private ScrollAction scrollAction;

    public CartScreen(AndroidDriver driver) {
        super(driver);
        this.scrollAction = new ScrollAction(driver);
    }

    public CartScreen removeItem() {
        clickElement(removeItemButton);
        return this;
    }

    public boolean isNoItemsInCartMessageVisible() {
        isElementVisible(noItemsInCartMessage);
        return true;
    }

    public CartScreen proceedToCheckoutButtonClick() {
        clickElement(proceedToCheckoutButton);
        return this;
    }

    public CartScreen nameFieldFill(String name) {
        sendKeysToElement(nameField, name);
        return this;
    }

    public CartScreen addressLineFill(String text) {
        sendKeysToElement(addressLine, text);
        return this;
    }

    public CartScreen cityFieldFill(String text) {
        sendKeysToElement(cityField, text);
        return this;
    }

    public CartScreen goToPaymentButtonClick() {
        clickElement(goToPaymentButton);
        return this;
    }

    public String isProvideYourCountryMessageIsDisplayed() {
        return elementGetText(provideYourCountryMessage);
    }

    public CartScreen zipCodeFieldFill(String zipCode) {
        scrollAction.scrollToElementByText("Zip Code");
        sendKeysToElement(zipCodeField, zipCode);
        return this;
    }

    public CartScreen zipCodeButtonClick() {
        scrollAction.scrollToElementByText("ZipCode");
        clickElement(zipCodeField);
        return this;
    }

    public CartScreen countryFieldFill(String countryName) {
        sendKeysToElement(countyField, countryName);
        return this;
    }

    public boolean isPaymentMessageMethodMessageVisible() {
        isElementVisible(enterPaymentMethodMessage);
        return true;
    }

    public CartScreen fullnameFieldFill(String fullName) {
        sendKeysToElement(fullNameField, fullName);
        return this;
    }

    public CartScreen paymentCardFieldFill(String cardNumber) {
        sendKeysToElement(paymentCardField, cardNumber);
        return this;
    }

    public CartScreen expirationCardFieldFill(String date) {
        sendKeysToElement(expirationDateField, date);
        return this;
    }

    public CartScreen securityCardFieldFill(String code) {
        sendKeysToElement(securityCodeField, code);
        return this;
    }

    public CartScreen reviewOrderButtonClick() {
        clickElement(reviewOrderButton);
        return this;
    }

    public CartScreen placeOrderButtonClick() {
        clickElement(placeOrderButton);
        return this;
    }

    public boolean isCheckoutCompleteMessageVisible() {
        isElementVisible(checkoutCompleteMessage);
        return true;
    }

    public boolean isGoToPaymentButtonVisible() {
        isElementVisible(goToPaymentButton);
        return true;
    }

    public List<String> isProductInCart() {
        List<WebElement> cartItems = driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"product label\"]\n"));
        return cartItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
