package Screen.Native;

import Screen.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Username input field']\n")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Password input field']\n")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Login button']\n")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Password-error-message']\n")
    private WebElement passwordErrorMessage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='bob@example.com']\n")
    private WebElement anExistingUserLoginData;
    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
    public LoginScreen usernameFieldFill(String username) {
        sendKeysToElement(usernameField, username);
        return this;
    }
    public LoginScreen passwordFieldFill(String password) {
        sendKeysToElement(passwordField, password);
        return this;
    }
    public LoginScreen loginButtonClick() {
        clickElement(loginButton);
        return this;
    }
    public boolean IsPasswordErrorMessageVisible() {
        return isElementVisible(passwordErrorMessage);
    }
    public LoginScreen logInAsExistingUser() {
        clickElement(anExistingUserLoginData);
        return this;
    }
    public LoginScreen clickSthButton() {
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        return this;
    }
}
