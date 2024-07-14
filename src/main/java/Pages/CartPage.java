package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Remove Item\"]\n")
    private WebElement removeItemButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"No Items\"]\n")
    private WebElement noItemsInCartMessage;
    public CartPage(AndroidDriver driver) {
        super(driver);
    }
    public CartPage removeItem() {
        clickElement(removeItemButton);
        return this;
    }
    public boolean isNoItemsInCartMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(noItemsInCartMessage));
        return true;
    }


}
