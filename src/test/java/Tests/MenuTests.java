package Tests;

import Component.LeftMenuBar;
import Component.ResetAppStatePopup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTests extends BaseTest {
    private LeftMenuBar leftMenuBar;
    private ResetAppStatePopup reset;

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
        Assert.assertTrue(leftMenuBar.isQRCodeScannerHeaderVisible(), "QR Scanner Header is not visible");
    }

    @Test
    public void biometricsMenu() {
        leftMenuBar = home.goToBiometricsMenu();
        Assert.assertEquals(leftMenuBar.biometricMesssage(), "Allow login with FingerPrint");
    }
}
