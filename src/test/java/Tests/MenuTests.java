package Tests;

import Component.LeftMenuBar;
import Component.ResetAppStatePopup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTests extends BaseTest {
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
        Assert.assertTrue(leftMenuBar.isQRCodeScannerHeaderVisible(), "QR Scanner Header is not visible");
    } // TODO: 19.08.2024 zrobić asercję do QR Scanner (zrobione)
    @Test
    public void biometricsMenu() {
        leftMenuBar = home.goToBiometricsMenu();
        Assert.assertEquals(leftMenuBar.biometricMesssage(), "Allow login with FingerPrint");
    }
}
