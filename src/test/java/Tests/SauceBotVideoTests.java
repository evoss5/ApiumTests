package Tests;

import Pages.Native.components.LeftMenuBar;
import Pages.Native.components.SauceVideo;
import Pages.Native.components.TopNavigationBar;
import org.testng.annotations.Test;

public class SauceBotVideoTests extends BaseTest {

    public LeftMenuBar leftMenuBar;
    public SauceVideo sauceVideo;

    @Test
    public void getYoutubeWindowFullscreen() {
        topNavigationBar = new TopNavigationBar(driver);
        topNavigationBar.hamburgerMenuClick();
        leftMenuBar = new LeftMenuBar(driver);
        leftMenuBar.sauceBoVideoButtonClick();
        sauceVideo = new SauceVideo(driver);
        sauceVideo.fullScreenClick();
        sauceVideo.dotButtonClick();

    }


}
