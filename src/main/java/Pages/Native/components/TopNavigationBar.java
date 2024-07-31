package Pages.Native.components;

import Pages.BaseScreen;
import Pages.WebView.WebViewHandle;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopNavigationBar extends BaseScreen {




    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView\n")
    private WebElement cartButton;
    @AndroidFindBy(xpath = "//div[@class='login_logo']")
    private WebElement mainHeader;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='open menu']\n")
    private WebElement hamburgerMenu;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"sort button\"]/android.widget.ImageView\n")
    private WebElement sortButton;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"nameDesc\"]/android.widget.ImageView\n")
    private WebElement sortProductsDesc;

    protected WebDriverWait wait;
    private WebViewHandle webView;
    private static final int TIMEOUT = 5;

    public TopNavigationBar(AndroidDriver driver) {
        super(driver);

    }
    public boolean isCartButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(cartButton));
        return true;
    }
    public TopNavigationBar hamburgerMenuClick() {
        webView = new WebViewHandle(driver);
        webView.switchBackToNative();
        hamburgerMenu.click();
        return this;
    }
    public TopNavigationBar sortButtonClick() {
        clickElement(sortButton);
        return this;
    }
    public TopNavigationBar sortProductsAscOrDesc() {
        clickElement(sortProductsDesc);
        return this;
    }
    }

