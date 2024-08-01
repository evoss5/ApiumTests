package Page.Native.component;

import Page.BaseScreen;
import Page.WebView.ContextHandler;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

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

    private ContextHandler webView;

    public TopNavigationBar(AndroidDriver driver) {
        super(driver);

    }
    public boolean isCartButtonVisible() {
        isElementVisible(cartButton);
        return true;
    }
    public TopNavigationBar hamburgerMenuClick() {
        webView = new ContextHandler(driver);
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

