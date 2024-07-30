package Tests;

import Pages.Native.CartScreen;
import Pages.Native.NativeDeviceActions;
import Pages.Native.components.ProductList;
import Pages.Native.components.TopNavigationBar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    public CartScreen cart;
    public Service service;
    public NativeDeviceActions natives;
    public TopNavigationBar topNavigationBar;


    @Test
    public void removeItemsFromCart() {
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.removeItem();
        Assert.assertTrue(cart.isNoItemsInCartMessageVisible(), "There are still some items in Cart");
    }

    @Test
    public void addProductToCart() {
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());;
        home.addToCartClick();
        Assert.assertEquals(home.checkIfNumberOfProductsIsNotEvenOne(), 1);
    }

    @Test
    public void increaseNumberOfItemsBought() {
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        home.increaseNumberOfProductsBought();
        Assert.assertNotEquals(home.checkIfNumberOfProductsIsNotEvenOne(), 1);
        // TODO: 14.07.2024 Sprawdzić jeszcze raz asercję
    }

    @Test
    public void proceedToCheckout() {
        login = home.goToLoginScreen();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();
        Assert.assertTrue(cart.isGoToPaymentButtonVisible(), "Go to Payment button is not visible");

    }

    @Test
    public void checkIfYouCanProceedToPaymentIfSomeDataIsNotFilled() {
        login = home.goToLoginScreen();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();
        cart.nameFieldFill("Evoss5");
        cart.addressLineFill("Poznanska 13");   // TODO: 24.07.2024 adres obowiązkowy i opcjonalny 
        cart.cityFieldFill("Konin");
        cart.zipCodeFieldFill("62-100");
        cart.goToPaymentButtonClick();
        Assert.assertEquals(cart.IsProvideYourCountryMessageIsDisplayed(), "Please provide your country.", "Provide your country message does not popup");
    }

    @Test
    public void checkIfYouCanProceedToPaymentMethod() {
        login = home.goToLoginScreen();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();
        cart.nameFieldFill("Evoss5");
        cart.addressLineFill("Poznanska 13");
        cart.cityFieldFill("Konin");
        cart.zipCodeFieldFill("62-100");
        service = new Service(driver);
        String randomCountry = service.getRandomValue(service.countries());
        cart.countryFieldFill(randomCountry);
        cart.goToPaymentButtonClick();
        Assert.assertTrue(cart.isPaymentMessageMethodMessageVisible(), "Enter Payment Mehod Message is not visible");
    }

    @Test
    public void checkIfYouCanProceedWholeTransaction() {
        login = home.goToLoginScreen();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();
        cart.nameFieldFill("Evoss5");
        cart.addressLineFill("Poznanska 13");
        cart.cityFieldFill("Konin");
        cart.zipCodeFieldFill("62-100");
        service = new Service(driver);
        String randomCountry = service.getRandomValue(service.countries());
        cart.countryFieldFill(randomCountry);
        cart.goToPaymentButtonClick();
        Assert.assertTrue(cart.isPaymentMessageMethodMessageVisible(), "Enter Payment Method Message is not visible");
        cart.fullnameFieldFill("Evo Evo");
        cart.paymentCardFieldFill(service.getRandomValue(service.cardNumbers()));
        cart.expirationCardFieldFill(service.expirationDate());
        cart.securityCardFieldFill(service.randomSecurityCode());
        cart.reviewOrderButtonClick();
        cart.placeOrderButtonClick();
        Assert.assertTrue(cart.isCheckoutCompleteMessageVisible(), "Checkout complete message is not visible");
    }

    @Test
    public void checkIfColorOfTheProductsIsChanged() throws InterruptedException {
        login = home.goToLoginScreen();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        home.chooseProductsColor("red");
    }

    @Test
    public void lockAndUnlockPhone() {
        natives = new NativeDeviceActions(driver);
        natives.lockDevice();
        natives.unlockDevice();
    }

    @Test
    public void checkIfTheAppIsClosingDown() {
        home.apiCallsButtonClick();
        natives = new NativeDeviceActions(driver);
        natives.closeApp();
    }

}


