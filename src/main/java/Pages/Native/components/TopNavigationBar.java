package Pages.Native.components;

import Pages.WebView.WebViewHandle;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopNavigationBar{



    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView\n")
    private WebElement cartButton;

    @AndroidFindBy(xpath = "//div[@class='login_logo']")
    private WebElement mainHeader;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"open menu\"]\n")
    private WebElement humbergerMenu;

    public AndroidDriver driver;
    protected WebDriverWait wait;
    private WebViewHandle webView;
    private static final int TIMEOUT = 5;

    public TopNavigationBar(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean isCartButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(cartButton));
        return true;
    }
    public TopNavigationBar hamburgerMenuClick() {
        webView = new WebViewHandle(driver);
        webView.switchBackToNative();
        humbergerMenu.click();
        return this;
    }
    }

