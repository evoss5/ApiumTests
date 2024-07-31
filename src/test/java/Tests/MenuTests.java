package Tests;

import Pages.Native.components.LeftMenuBar;
import Pages.Native.components.ResetAppStatePopup;
import Pages.Native.components.TopNavigationBar;
import Pages.WebView.WebViewHandle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTests extends BaseTest {
    public Service service;
    public WebViewHandle webView;
    public TopNavigationBar topNavigationBar;
    public LeftMenuBar leftMenuBar;
    public ResetAppStatePopup reset;

    @Test
    public void checkAppInfo() {
        leftMenuBar = home.goToAboutInfo();
        leftMenuBar.aboutButtonClick();
        Assert.assertTrue(leftMenuBar.isSauceDemoRobotLogoIsVisible(), "Logo is not visible");
    }

    @Test
    public void drawingMenu() {
        leftMenuBar = home.goToDrawingMenu();
        Assert.assertTrue(leftMenuBar.isClearButtonVisible(), "Button is not visible");
    }
    @Test
    public void resetAppState() {
        reset = home.goToResetAppState();
        reset.resetAppStateWindowConfirmationClick();
        Assert.assertEquals(reset.resetAppGetText(), "App State has been reset.");
    }
    @Test
    public void openApiCallsMenu() {
        leftMenuBar = home.goToApiCalls();
        Assert.assertTrue(leftMenuBar.isApiCallsLogoVisible(), "Api Calls Logo is not visible");
    }
    @Test
    public void chooseQRcodeScannerInMenu() {
        leftMenuBar = home.goToQRCodeScanner();
    }
    @Test
    public void biometricsMenu() {
        leftMenuBar = home.goToBiometricsMenu();
        Assert.assertEquals(leftMenuBar.biometricMesssage(), "Allow login with FingerPrint");
    }
}
