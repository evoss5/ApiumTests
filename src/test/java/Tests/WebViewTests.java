package Tests;

import Pages.Native.NativeDeviceActions;
import Pages.Native.components.TopNavigationBar;
import Pages.WebView.CartScreen;
import Pages.WebView.HomeScreen;
import Pages.WebView.LoginScreen;
import Pages.WebView.WebViewHandle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebViewTests extends BaseTest {
    public WebViewHandle webView;
    public NativeDeviceActions natives;
    public LoginScreen loginWeb;
    public TopNavigationBar topNavigationBar;
    public HomeScreen homeWeb;
    public CartScreen cartWeb;


    @Test
    public void changeContextIntoWebView() {
        home.goToWebView();
        home.urlFieldFill();
        loginWeb = home.goToSiteButtonClick();
        String context = driver.getContext();
        System.out.println("Obecny context to : " + context);
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
        webView = new WebViewHandle(driver);
        webView.switchBackToNative();
        topNavigationBar = new TopNavigationBar(driver);
        Assert.assertTrue(topNavigationBar.isCartButtonVisible());
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
        webView = new WebViewHandle(driver);
        webView.switchBackToNative();
        webView.scrollDown(10);
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
        webView = new WebViewHandle(driver);
        webView.switchBackToNative();
        natives = new NativeDeviceActions(driver);
        natives.swipeManyTimes2(2);
        webView.switchToWebView();
        Assert.assertNotEquals(homeWeb.numberOfProducts(), "0", "There are not products in the cart");
    }

    @Test
    public void logOutFromAccount() {
        home.goToWebView();
        home.urlFieldFill();
        loginWeb = home.goToSiteButtonClick();
        loginWeb.userNameFieldFill("standard_user");
        loginWeb.passwordField("secret_sauce");
        webView = new WebViewHandle(driver);
        webView.switchBackToNative();
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        home.logOutFromAccount();
        home.logOutAcceptButtonClick();
        Assert.assertTrue(home.isSuccessfulyLoggedOutMessageVisible(), "The message is not visible");
    }
    @Test
    public void switchContextToWebView() {
        home.goToWebView();

    }

}
