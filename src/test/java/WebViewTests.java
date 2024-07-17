import Pages.NativeDeviceActions;
import Pages.WebViewHandle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebViewTests extends BaseTest {
    public WebViewHandle webView;
    public NativeDeviceActions natives;


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

}