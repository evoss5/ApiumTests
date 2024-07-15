import Pages.CartScreen;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    public AndroidDriver driver;
    public CartScreen cart;
    public Service service;

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
    @Test
    public void proceedToCheckout() {
        home.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy("Sauce Labs Backpack");
        home.scrollDownToText("Add To Cart");
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();

    }
    @Test
    public void checkIfYouCanProceedToPaymentIfSomeDataIsNotFilled() {
        home.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy("Sauce Labs Backpack");
        home.scrollDownToText("Add To Cart");
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();
        cart.nameFieldFill("Evoss5");
        cart.addressLineFill("Poznanska 13");
        cart.cityFieldFill("Konin");
        home.scrollDownToText("Zip Code");
        cart.goToPaymentButtonClick();
        Assert.assertEquals(cart.IsProvideYourCountryMessageIsDisplayed(), "Please provide your country.", "Provide your country message does not popup");
    }

    @Test
    public void checkIfYouCanProceedToPaymentMethod() {
        home.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy("Sauce Labs Backpack");
        home.scrollDownToText("Add To Cart");
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();
        cart.nameFieldFill("Evoss5");
        cart.addressLineFill("Poznanska 13");
        cart.cityFieldFill("Konin");
        home.scrollDownToText("Zip Code");
        cart.zipCodeFieldFill("62-100");
        service = new Service(driver);
        String ramndomCountry = service.getRandomValue(service.countries());
        cart.countryFieldFill(ramndomCountry);
        cart.goToPaymentButtonClick();
        Assert.assertTrue(cart.isPaymentMessageMethodMessageVisible(), "Enter Payment Mehod Message is not visible");
    }

    @Test
    public void CheckIfYouCanProceedWholeTransaction() {
        home.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy("Sauce Labs Backpack");
        home.scrollDownToText("Add To Cart");
        home.addToCartClick();
        cart = home.goToCartPage();
        cart.proceedToCheckoutButtonClick();
        cart.nameFieldFill("Evoss5");
        cart.addressLineFill("Poznanska 13");
        cart.cityFieldFill("Konin");
        home.scrollDownToText("Zip Code");
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
        home.hamburgerMenuClick();
        login = home.goToLoginPage();
        login.logInAsExistingUser();
        login.loginButtonClick();
        Assert.assertTrue(home.isMainBannerVisible());
        home.chooseProductToBuy("Sauce Labs Backpack");
        home.chooseProductsColor("red");
    }
}



