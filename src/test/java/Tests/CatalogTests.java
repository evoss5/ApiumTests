package Tests;

import Pages.Native.NativeDeviceActions;
import Pages.Native.components.ProductList;
import Pages.Native.components.TopNavigationBar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTests extends BaseTest{


    public NativeDeviceActions natives;
    public TopNavigationBar topNavigationBar;


    @Test
    public void checkProductsHighlight() {
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        natives = new NativeDeviceActions(driver);
        natives.scrollToElementByText("Product Highlights");
        Assert.assertEquals(home.productHighlightsGetText(), "Product Highlights", "There is not Product Highlights text");
    }
    @Test
    public void checkIfYouCanSetRating() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        home.setRating(2);
        Assert.assertTrue(home.setRatingGetText(2), "The rating is not set");
    }
    @Test
    public void sortProductsByDesc() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        topNavigationBar.sortButtonClick("Descending");
    }
}
