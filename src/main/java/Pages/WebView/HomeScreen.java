package Pages.WebView;

import Pages.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class HomeScreen extends BaseScreen {
    private Random random = new Random();

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
    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }
    public HomeScreen addProductToTheCartClick() {
        clickElement(addProductToCart);
        return this;
    }
    public boolean isProductShownInTheCart() {
        wait.until(ExpectedConditions.visibilityOf(removeButton));
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        return true;
    }
    public HomeScreen sortProductsBy() {
        wait.until(ExpectedConditions.visibilityOf(sortButton));
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
        return productsNumberInCart.getText();
    }
}
