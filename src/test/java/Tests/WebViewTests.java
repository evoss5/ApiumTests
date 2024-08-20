package Tests;

import Screen.WebView.CartScreen;
import Screen.WebView.HomeScreen;
import Screen.WebView.LoginScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebViewTests extends BaseTest {
    public LoginScreen loginWeb;
    public HomeScreen homeWeb;
    public CartScreen cartWeb;




    @Test
    public void changeContextIntoWebView() {
        home.goToWebView();
        home.urlFieldFill();
        loginWeb = home.goToSiteButtonClick();
        String context = driver.getContext();
        Assert.assertTrue(loginWeb.isLoginButtonClickable(), "Login button is not clickable");
    }

    @Test
    public void loginToThePage() {
        home.goToWebView();
        home.urlFieldFill();
        loginWeb = home.goToSiteButtonClick();
        loginWeb.userNameFieldFill("standard_user");
        loginWeb.passwordField("secret_sauce");
        homeWeb = loginWeb.loginButtonClick();
        Assert.assertTrue(homeWeb.isSwagLabsBannerVisible());
    }

    @Test
    public void addProductToTheCart() {
        home.goToWebView();
        home.urlFieldFill();
        loginWeb = home.goToSiteButtonClick();
        loginWeb.userNameFieldFill("standard_user");
        loginWeb.passwordField("secret_sauce");
        homeWeb = loginWeb.loginButtonClick();
        homeWeb.addProductToTheCartClick();
        Assert.assertTrue(homeWeb.isProductShownInTheCart(), "Product is not in the cart");
        Assert.assertTrue(homeWeb.isCartButtonVisible());
    }

    @Test
    public void sortProducts() {
        home.goToWebView();
        home.urlFieldFill();
        loginWeb = home.goToSiteButtonClick();
        loginWeb.userNameFieldFill("standard_user");
        loginWeb.passwordField("secret_sauce");
        homeWeb = loginWeb.loginButtonClick();
        homeWeb.sortProductsBy();
        Assert.assertTrue(homeWeb.isSauceLabsBackpackIconVisible());
    }

    @Test
    public void goToTheFooterOfThePage() {
        home.goToWebView();
        home.urlFieldFill();
        loginWeb = home.goToSiteButtonClick();
        loginWeb.userNameFieldFill("standard_user");
        loginWeb.passwordField("secret_sauce");
        homeWeb = loginWeb.loginButtonClick();
        homeWeb.goToTheBottomOfThePage();
        Assert.assertTrue(homeWeb.isSauceLabsBackpackIconVisible());
    }

    @Test
    public void finishOrderProduct() {
        home.goToWebView();
        home.urlFieldFill();
        loginWeb = home.goToSiteButtonClick();
        loginWeb.userNameFieldFill("standard_user");
        loginWeb.passwordField("secret_sauce");
        homeWeb = loginWeb.loginButtonClick();
        cartWeb = homeWeb.cartButtonClick();
        cartWeb.checkoutButtonClick();
        cartWeb.firstNameFieldFill("Evo");
        cartWeb.lastNameFieldFill("Piasek");
        cartWeb.zipCodeFieldFill("62-510");
        cartWeb.continueButtonClick();
        cartWeb.finishButtonClick();
        Assert.assertEquals(cartWeb.thankYouForOrderMessageText(), "Thank you for your order!", "Message is not visible");
    }

    @Test
    public void checkIfTheCartIsNotEmpty() {
        home.goToWebView();
        home.urlFieldFill();
        loginWeb = home.goToSiteButtonClick();
        loginWeb.userNameFieldFill("standard_user");
        loginWeb.passwordField("secret_sauce");
        homeWeb = loginWeb.loginButtonClick();
        homeWeb.addProductToTheCartClick();
        Assert.assertNotEquals(homeWeb.numberOfProducts(), "0", "There are not products in the cart");
    }

    @Test
    public void logOutFromAccount() {
        home.goToWebView();
        home.urlFieldFill();
        loginWeb = home.goToSiteButtonClick();
        loginWeb.userNameFieldFill("standard_user");
        loginWeb.passwordField("secret_sauce");
        home.logOutFromAccount();
        home.logOutAcceptButtonClick();
        Assert.assertTrue(home.isSuccessfulyLoggedOutMessageVisible(), "The message is not visible");
    }

    @Test
    public void switchContextToWebView() {
        home.goToWebView();

    }

}
