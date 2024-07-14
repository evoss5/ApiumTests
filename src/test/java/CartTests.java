import Pages.CartPage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    public AndroidDriver driver;
    public CartPage cart;

    @Test
    public void removeItemsFromCart() {
        home.chooseProductToBuy("Sauce Labs Backpack");
        home.scrollDownToText("Add To Cart");
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.removeItem();
        Assert.assertTrue(cart.isNoItemsInCartMessageVisible(), "There are still some items in Cart");
    }
    @Test
    public void addProductToCart() {
        home.chooseProductToBuy("Sauce Labs Backpack");
        home.scrollDownToText("Add To Cart");
        home.addToCartClick();
    }
    @Test
    public void increaseNumberOfItemsBought() {
        home.chooseProductToBuy("Sauce Labs Backpack");
        home.scrollDownToText("Add To Cart");
        home.increaseNumberOfProductsBought();
        Assert.assertNotEquals(home.checkIfNumberOfProductsIsNotEvenOne(), 1);
        // TODO: 14.07.2024 Sprawdzić jeszcze raz asercję
    }

}
