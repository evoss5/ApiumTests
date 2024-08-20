package Tests;

import Component.ProductList;
import Screen.Native.CartScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    public CartScreen cart;




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
    public void addRandomProductToCart() {
        home.randomProductClick();
        home.addToCartClick();
        cart = home.goToCartPage();

    }

    @Test
    public void increaseNumberOfItemsBought() {
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        home.increaseNumberOfProductsBought();
        Assert.assertNotEquals(home.checkIfNumberOfProductsIsNotEvenOne(), 1);
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
        cart.addressLineFill("Poznanska 13");
        cart.cityFieldFill("Konin");
        cart.zipCodeFieldFill("62-100");
        cart.goToPaymentButtonClick();
        Assert.assertEquals(cart.isProvideYourCountryMessageIsDisplayed(), "Please provide your country.", "Provide your country message does not popup");
    }

    @Test
    public void checkIfYouCanProceedToPaymentMethod() {
        login = home.goToLoginScreen();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.randomProductClick();
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();
        cart.nameFieldFill("Evoss5");
        cart.addressLineFill("Poznanska 13");
        cart.cityFieldFill("Konin");
        cart.zipCodeFieldFill("62-100");
        commonMethods = new CommonMethods();
        String randomCountry = commonMethods.getRandomValue(commonMethods.countries());
        cart.countryFieldFill(randomCountry);
        cart.goToPaymentButtonClick();
        Assert.assertTrue(cart.isPaymentMessageMethodMessageVisible(), "Enter Payment Method Message is not visible");
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
        commonMethods = new CommonMethods();
        String randomCountry = commonMethods.getRandomValue(commonMethods.countries());
        cart.countryFieldFill(randomCountry);
        cart.goToPaymentButtonClick();
        Assert.assertTrue(cart.isPaymentMessageMethodMessageVisible(), "Enter Payment Method Message is not visible");
        cart.fullnameFieldFill("Evo Evo");
        cart.paymentCardFieldFill(commonMethods.getRandomValue(commonMethods.cardNumbers()));
        cart.expirationCardFieldFill(commonMethods.expirationDate());
        cart.securityCardFieldFill(commonMethods.randomSecurityCode());
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
        natives.lockDevice();
        natives.unlockDevice();
    }

    @Test
    public void checkIfTheAppIsClosingDown() {
        home.apiCallsButtonClick();
        natives.closeApp();
    }

    @Test
    public void addRandomProductToCart2() {
        String product = commonMethods.getRandomValue(commonMethods.product());
        home.randomProductClick2(product);
        home.addToCartClick();
        cart = home.goToCartPage();
        Assert.assertTrue(cart.isProductInCart().contains(product)); // TODO: 20.08.2024 Poprawić, ma być dynamiczny xpath
    }
}


