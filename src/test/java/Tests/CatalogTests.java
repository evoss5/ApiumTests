package Tests;

import Page.Native.component.ProductList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTests extends BaseTest{




    @Test
    public void checkProductsHighlight() {
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        Assert.assertEquals(home.productHighlightsGetText(), "Product Highlights", "There is not Product Highlights text");
    }
    @Test
    public void checkIfYouCanSetRating() {
        login = home.goToLoginScreen();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        home.setRating(2);
        Assert.assertTrue(home.setRatingGetText(2), "The rating is not set");
    }
    @Test
    public void sortProductsByDesc() {
        login = home.goToLoginScreen();
        login.logInAsExistingUser();
        login.loginButtonClick(); // TODO: 06.08.2024 przejście do HomeScreena, zmienić wywoływanie klas typu TopNavigationBar, WebView, żeby były w metodach w screenach a nie w BaseTest
        home.sortProductButtonClick();
    }
}
