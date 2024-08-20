package Screen.WebView;

import Screen.BaseScreen;
import Component.ContextHandler;
import Component.TopNavigationBar;
import Device.Action.SwipeAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class HomeScreen extends BaseScreen {
    private Random random = new Random();
    public LoginScreen loginWeb;
    public ContextHandler webView;
    public SwipeAction swipeAction;
    public TopNavigationBar topNavigationBar;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addProductToCart;
    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    private WebElement removeButton;
    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortButton;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartButton;
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement productsNumberInCart;
    @FindBy (xpath = "//div[@class='app_logo']")
    private WebElement swagLabsBanner;
    @FindBy(xpath = "//div[@class='inventory_item_name ' and text()='Sauce Labs Backpack']")
    private WebElement sauceLabsBackpackIcon;

    public HomeScreen(AndroidDriver driver) {
        super(driver);
        this.loginWeb = new LoginScreen(driver);
        this.webView = new ContextHandler(driver);
        this.swipeAction = new SwipeAction(driver);
        this.topNavigationBar = new TopNavigationBar(driver);
    }
    public HomeScreen addProductToTheCartClick() {
        clickElement(addProductToCart);
        webView.switchToNative();
        swipeAction.swipeUp(2);
        webView.switchToWebView();
        return this;
    }
    public boolean isProductShownInTheCart() {
        isElementVisible(removeButton);
        isElementClickable(removeButton);
        return true;
    }
    public HomeScreen sortProductsBy() {
        isElementVisible(sortButton);
        Select dropdown = new Select(sortButton);
        int size1 = dropdown.getOptions().size();
        int i = random.nextInt(size1);
        dropdown.selectByIndex(i);
        return this;
    }
    public CartScreen cartButtonClick() {
        clickElement(cartButton);
        return new CartScreen(driver);
    }
    public String numberOfProducts() {

        return elementGetText(productsNumberInCart);
    }
    public boolean isSwagLabsBannerVisible() {
        isElementVisible(swagLabsBanner);
        return true;
    }
    public boolean isSauceLabsBackpackIconVisible() {
        isElementVisible(sauceLabsBackpackIcon);
        return true;
    }
    public CartScreen goToWebCartScreen() {
        loginWeb.loginButtonClick();
        cartButtonClick();
        return new CartScreen(driver);
    }
    public HomeScreen goToTheBottomOfThePage() {
        swipeAction.swipeDown(10);
        return this;
    }
    public boolean isCartButtonVisible() {
        topNavigationBar.isCartButtonVisible();
        return true;
    }
}
