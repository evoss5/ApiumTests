import Pages.NativeDeviceActions;
import Pages.WebViewHandle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebViewTests extends BaseTest {
    public WebViewHandle webView;
    public NativeDeviceActions natives;
    public Service service;


    @Test
    public void changeContextIntoWebView() {
        home.hamburgerMenuClick();
        webView = home.goToWebView();
        webView.urlFieldFill();
        webView.goToSiteButtonClick();
        webView.switchToWebView();
        String context = driver.getContext();
        System.out.println("Obecny context to : " + context);
    }

    @Test
    public void loginToThePage() {
        home.hamburgerMenuClick();
        webView = home.goToWebView();
        webView.urlFieldFill();
        webView.goToSiteButtonClick();
        webView.switchToWebView();
        webView.userNameFieldFill("standard_user");
        webView.passwordField("secret_sauce");
        webView.loginButtonCLick();
    }
    @Test
    public void addProductToTheCart() {
        home.hamburgerMenuClick();
        webView = home.goToWebView();
        webView.urlFieldFill();
        webView.goToSiteButtonClick();
        webView.switchToWebView();
        webView.userNameFieldFill("standard_user");
        webView.passwordField("secret_sauce");
        webView.loginButtonCLick();
        webView.addProductToTheCartClick();
        Assert.assertTrue(webView.isProductShownInTheCart(), "Product is not in the cart");
        natives = new NativeDeviceActions(driver);
        webView.switchBackToNative();
        String context = driver.getContext();
        System.out.println(context);
        natives.navigateHomeButton();

    }
    @Test
    public void sortProducts() {
        home.hamburgerMenuClick();
        webView = home.goToWebView();
        webView.urlFieldFill();
        webView.goToSiteButtonClick();
        webView.switchToWebView();
        webView.userNameFieldFill("standard_user");
        webView.passwordField("secret_sauce");
        webView.loginButtonCLick();
        webView.sortProductsBy();
    }
    @Test
    public void goToTheFooterOfThePage() {
        home.hamburgerMenuClick();
        webView = home.goToWebView();
        webView.urlFieldFill();
        webView.goToSiteButtonClick();
        webView.switchToWebView();
        webView.userNameFieldFill("standard_user");
        webView.passwordField("secret_sauce");
        webView.loginButtonCLick();
        webView.switchBackToNative();
        webView.scrollDownToFooter();
    }
    @Test
    public void finishOrderProduct() {
        home.hamburgerMenuClick();
        webView = home.goToWebView();
        webView.urlFieldFill();
        webView.goToSiteButtonClick();
        webView.switchToWebView();
        webView.userNameFieldFill("standard_user");
        webView.passwordField("secret_sauce");
        webView.loginButtonCLick();
        webView.cartButtonClick();
        webView.checkoutButtonClick();
        webView.firstNameFieldFill("Evo");
        webView.lastNameFieldFill("Piasek");
        webView.zipCodeFieldFill("62-510");
        webView.continueButtonClick();
        webView.finishButtonClick();
        Assert.assertEquals(webView.thankYouForOrderMessageText(), "Thank you for your order!", "Message is not visible");
    }

    @Test
    public void checkIfTheCartIsNotEmpty() {
        home.hamburgerMenuClick();
        webView = home.goToWebView();
        webView.urlFieldFill();
        webView.goToSiteButtonClick();
        webView.switchToWebView();
        webView.userNameFieldFill("standard_user");
        webView.passwordField("secret_sauce");
        webView.loginButtonCLick();
        webView.addProductToTheCartClick();
        webView.switchBackToNative();
        natives = new NativeDeviceActions(driver);
        natives.swipeManyTimes2(2);
        webView.switchToWebView();
        Assert.assertNotEquals(webView.numberOfProducts(), "0", "There are not products in the cart");
    }
    @Test
    public void logOutFromAccount() {
        home.hamburgerMenuClick();
        webView = home.goToWebView();
        webView.urlFieldFill();
        webView.goToSiteButtonClick();
        webView.switchToWebView();
        webView.userNameFieldFill("standard_user");
        webView.passwordField("secret_sauce");
        webView.switchBackToNative();
        home.hamburgerMenuClick();
        home.logOutFromAccount();
        home.logOutAcceptButtonClick();
        Assert.assertTrue(home.isSuccessfulyLoggedOutMessageVisible(), "The message is not visible");
    }
    }
