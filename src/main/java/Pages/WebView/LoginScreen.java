package Pages.WebView;

import Pages.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginScreen extends BaseScreen {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
    public LoginScreen userNameFieldFill(String username) {
        sendKeysToElement(userNameField, username);
        return this;
    }
    public LoginScreen passwordField(String password) {
        sendKeysToElement(passwordField, password);
        return this;
    }
    public HomeScreen loginButtonClick() {
        clickElement(loginButton);
        return new HomeScreen(driver);
    }
    public boolean isLoginButtonClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        return true;
    }

}
