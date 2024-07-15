package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Remove Item\"]\n")
    private WebElement removeItemButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"No Items\"]\n")
    private WebElement noItemsInCartMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Proceed To Checkout\"]\n")
    private WebElement proceedToCheckoutButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Full Name* input field\"]\n")
    private WebElement nameField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]\n")
    private WebElement addressLine;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"City* input field\"]\n")
    private WebElement cityField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"To Payment\"]\n")
    private WebElement goToPaymentBUtton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Please provide your country.\"]\n")
    private WebElement provideYourCountryMessage;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Zip Code* input field\"]\n")
    private WebElement zipCodeField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Country* input field\"]\n")
    private WebElement countyField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You will not be charged until you review your purchase on the next screen.\"]\n")
    private WebElement enterPaymentMethodMessage;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Full Name* input field\"]\n")
    private WebElement fullNameField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Card Number* input field\"]\n")
    private WebElement paymentCardField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]\n")
    private WebElement expirationDateField;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Security Code* input field\"]")
    private WebElement securityCodeField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Review Order button\"]\n")
    private WebElement reviewOrderButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Place Order\"]\n")
    private WebElement placeOrderButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Checkout Complete\"]\n")
    private WebElement checkoutCompleteMessage;

    public CartScreen(AndroidDriver driver) {
        super(driver);
    }
    public CartScreen removeItem() {
        clickElement(removeItemButton);
        return this;
    }
    public boolean isNoItemsInCartMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(noItemsInCartMessage));
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
        clickElement(goToPaymentBUtton);
        return this;
    }
    public String IsProvideYourCountryMessageIsDisplayed() {
        String text = provideYourCountryMessage.getText();
        return text;
    }
    public CartScreen zipCodeFieldFill(String zipCode) {
        sendKeysToElement(zipCodeField, zipCode);
        return this;
    }
    public CartScreen countryFieldFill(String countryName) {
        sendKeysToElement(countyField, countryName);
        return this;
    }
    public boolean isPaymentMessageMethodMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(enterPaymentMethodMessage));
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
        wait.until(ExpectedConditions.visibilityOf(checkoutCompleteMessage));
        return true;
    }

}
