package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Username input field\"]\n")
    private WebElement usernameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]\n")
    private WebElement passwordField;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login button\"]\n")
    private WebElement loginButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Password-error-message\"]\n")
    private WebElement passwordErrorMessage;
    public LoginPage(WebDriver driver) {
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
}
