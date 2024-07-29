package Pages.Native.components;

import Pages.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ResetAppStatePopup extends BaseScreen {
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']\n")
    public WebElement resetAppStateWindowConfirmation;
    @AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']\n")
    private WebElement resetAppDoneConfirmation;


    public ResetAppStatePopup(AndroidDriver driver) {
        super(driver);
    }
    public ResetAppStatePopup resetAppStateWindowConfirmationClick() {
        clickElement(resetAppStateWindowConfirmation);
        return this;
    }
    public String resetAppGetText() {
        return resetAppDoneConfirmation.getText();
    }
}
