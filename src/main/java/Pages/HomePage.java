package Pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"open menu\"]\n")
    private WebElement mainHeader;
    @FindBy(xpath = "//android.widget.TextView[@text=\"Log In\"]\n")
    private WebElement logInButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage mainHeaderClick() {
        clickElement(mainHeader);
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
}
