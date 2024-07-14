package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Username input field\"]\n")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]\n")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login button\"]\n")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Password-error-message\"]\n")
    private WebElement passwordErrorMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"bob@example.com\"]\n")
    private WebElement anExistingUserLoginData;
    public LoginPage(AndroidDriver driver) {
        super(driver);
    }
    public LoginPage usernameFieldFill(String username) {
        sendKeysToElement(usernameField, username);
        return this;
    }
    public LoginPage passwordFieldFill(String password) {
        sendKeysToElement(passwordField, password);
        return this;
    }
    public LoginPage loginButtonClick() {
        clickElement(loginButton);
        return this;
    }
    public boolean IsPasswordErrorMessageVisible() {
        return passwordErrorMessage.isDisplayed();
    }
    public LoginPage logInAsExistingUser() {
        clickElement(anExistingUserLoginData);
        return this;
    }
}
