package Pages.WebView;

import Pages.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartScreen extends BaseScreen {
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


    public CartScreen(AndroidDriver driver) {
        super(driver);
    }

    public CartScreen checkoutButtonClick() {
        clickElement(checkoutButton);
        return this;
    }

    public CartScreen firstNameFieldFill(String firstName) {
        sendKeysToElement(firstNameField, firstName);
        return this;
    }

    public CartScreen lastNameFieldFill(String lastName) {
        sendKeysToElement(lastNameField, lastName);
        return this;
    }
    public CartScreen zipCodeFieldFill(String zipCode) {
        sendKeysToElement(zipCodeField, zipCode);
        return this;
    }
    public CartScreen continueButtonClick() {
        continueButton.click();
        return this;
    }
    public CartScreen finishButtonClick() {
        clickElement(finishButton);
        return this;
    }
    public String thankYouForOrderMessageText() {
        return thankYouForOrderMessage.getText();
    }
}
