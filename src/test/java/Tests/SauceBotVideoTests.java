package Tests;

import Page.Native.component.SauceVideo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceBotVideoTests extends BaseTest {

    public SauceVideo sauceVideo;

    @Test
    public void getYoutubeWindowFullscreen() throws InterruptedException {
        sauceVideo = home.goToSauceVideo();
        sauceVideo.fullScreenClick();
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        sauceVideo.exitFullscreenButtonClick();
    }
    @Test
    public void forwardVideo() {
        sauceVideo = home.goToSauceVideo();
        sauceVideo.videoForwardButtonClick();

    }
    @Test
    public void stopVideo() {
        sauceVideo = home.goToSauceVideo();
        sauceVideo.videoStopButtonClick();
        Assert.assertTrue(sauceVideo.isPlayButtonVisible(), "Play button is not visible");
    }
    @Test
    public void muteSound() {
        sauceVideo = home.goToSauceVideo();
        sauceVideo.videoVolumeUpClick();
        Assert.assertTrue(sauceVideo.isMuteSoundIconVisible(), "Sound is not mute");
    }

    // TODO: 01.08.2024 asercja z czasem(15 sekund)
}

