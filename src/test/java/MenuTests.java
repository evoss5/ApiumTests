import Pages.Native.components.LeftMenuBar;
import Pages.Native.components.TopNavigationBar;
import Pages.WebView.WebViewHandle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTests extends BaseTest{
    public Service service;
    public WebViewHandle webView;
    public TopNavigationBar topNavigationBar;
    public LeftMenuBar leftMenuBar;

    @Test
    public void checkAppInfo() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        leftMenuBar = new LeftMenuBar(driver);
        leftMenuBar.aboutButtonClick();
        Assert.assertTrue(leftMenuBar.isSauceDemoRobotLogoIsVisible(), "Logo is not visible");
    }

    @Test
    public void drawingMenu() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        leftMenuBar = new LeftMenuBar(driver);
        leftMenuBar.drawingButtonClick();
        Assert.assertTrue(leftMenuBar.isClearButtonVisible(), "Button is not visible");
    }
    @Test
    public void resetAppState() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        leftMenuBar = new LeftMenuBar(driver);
        leftMenuBar.resetAppStateButtonClick();
        leftMenuBar.resetAppStateWindowConfirmationClick();
        Assert.assertEquals(leftMenuBar.resetAppGetText(), "App state has been reset.");
    }
}
