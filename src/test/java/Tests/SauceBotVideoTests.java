package Tests;

import Page.Native.component.SauceVideo;
import org.testng.annotations.Test;

public class SauceBotVideoTests extends BaseTest {

    public SauceVideo sauceVideo;

    @Test
    public void getYoutubeWindowFullscreen() {
        sauceVideo = home.goToSauceVideo();
        sauceVideo.fullScreenClick();
    }
    @Test
    public void forwardVideo() {
        sauceVideo = home.goToSauceVideo();
        sauceVideo.fullScreenClick();
        sauceVideo.videoForwardButtonClick();
    }
    @Test
    public void stopVideo() {
        sauceVideo = home.goToSauceVideo();
        sauceVideo.fullScreenClick();
        sauceVideo.videoStopButtonClick();
    }
    @Test
    public void muteSound() {
        sauceVideo = home.goToSauceVideo();
        sauceVideo.fullScreenClick();
        sauceVideo.videoVolumeUpClick();
    }

    //todo dodać asercje
    // TODO: 01.08.2024 asercja z czasem(15 sekund)
}
