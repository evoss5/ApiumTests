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
        natives = new NativeDeviceActions(driver);
        natives.scrollToElementByText("Add To Cart");
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.removeItem();
        Assert.assertTrue(cart.isNoItemsInCartMessageVisible(), "There are still some items in Cart");
    }

    @Test
    public void addProductToCart() {
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        natives = new NativeDeviceActions(driver);
        natives.scrollToElementByText("Add To Cart");
        home.addToCartClick();
    }

    @Test
    public void increaseNumberOfItemsBought() {
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        natives = new NativeDeviceActions(driver);
        natives.scrollToElementByText("Add To Cart");
        home.increaseNumberOfProductsBought();
        Assert.assertNotEquals(home.checkIfNumberOfProductsIsNotEvenOne(), 1);
        // TODO: 14.07.2024 Sprawdzić jeszcze raz asercję
    }

    @Test
    public void proceedToCheckout() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        natives = new NativeDeviceActions(driver);
        natives.scrollToElementByText("Add To Cart");
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();

    }

    @Test
    public void checkIfYouCanProceedToPaymentIfSomeDataIsNotFilled() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        natives = new NativeDeviceActions(driver);
        natives.scrollToElementByText("Add To Cart");
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();
        cart.nameFieldFill("Evoss5");
        cart.addressLineFill("Poznanska 13");   // TODO: 24.07.2024 adres obowiązkowy i opcjonalny 
        cart.cityFieldFill("Konin");
        natives.scrollToElementByText("Zip Code");
        cart.goToPaymentButtonClick();
        Assert.assertEquals(cart.IsProvideYourCountryMessageIsDisplayed(), "Please provide your country.", "Provide your country message does not popup");
    }

    @Test
    public void checkIfYouCanProceedToPaymentMethod() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        natives = new NativeDeviceActions(driver);
        natives.scrollToElementByText("Add To Cart");
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();
        cart.nameFieldFill("Evoss5");
        cart.addressLineFill("Poznanska 13");
        cart.cityFieldFill("Konin");
        natives.scrollToElementByText("Zip Code"); // TODO: 24.07.2024  zrobić metodę na kliknięcie zipCode i wrzucić tam metodę scroll 
        cart.zipCodeFieldFill("62-100");
        service = new Service(driver);
        String randomCountry = service.getRandomValue(service.countries());
        cart.countryFieldFill(randomCountry);
        cart.goToPaymentButtonClick();
        Assert.assertTrue(cart.isPaymentMessageMethodMessageVisible(), "Enter Payment Mehod Message is not visible");
    }

    @Test
    public void checkIfYouCanProceedWholeTransaction() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy(ProductList.SAUCE_LABS_BACKPACK.getProductName());
        natives = new NativeDeviceActions(driver);
        natives.scrollToElementByText("Add To Cart");
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();
        cart.nameFieldFill("Evoss5");
        cart.addressLineFill("Poznanska 13");
        cart.cityFieldFill("Konin");
        natives.scrollToElementByText("Zip Code");
        cart.zipCodeFieldFill("62-100");
        service = new Service(driver);
        String ramndomCountry = service.getRandomValue(service.countries());
        cart.countryFieldFill(ramndomCountry);
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
    public void checkIfColorOfTheProductsIsChanged() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
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
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        home.apiCallsButtonClick();
        natives = new NativeDeviceActions(driver);
        natives.closeApp();
    }


}
// TODO: 24.07.2024 UIAutomatin version, wersja android, i telefon

