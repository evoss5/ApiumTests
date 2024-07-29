package Pages.WebView;

import Pages.BaseScreen;
import Pages.Native.NativeDeviceActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;
import java.util.Set;

public class WebViewHandle extends BaseScreen {
    private final Random random = new Random();

    @FindBy(xpath = "//footer[@class='footer']")
    private WebElement footer;


    public WebViewHandle(AndroidDriver driver) {
        super(driver);
    }

    public WebViewHandle switchToWebView() {
        Set<String> contextNames = driver.getContextHandles();
        String lastContextView = (String) contextNames.toArray()[contextNames.size() - 1];

        if (lastContextView.contains("WEBVIEW_") || lastContextView.contains("WEBVIEW_com.xxxxxx.android.mobile.xxxxx")) {
            driver.context(lastContextView);
        }
        return this;
    }

    public WebViewHandle switchBackToNative() {
        Set<String> contextNames = driver.getContextHandles();
        String lastContextView = (String) contextNames.toArray()[contextNames.size() - 1];
        if (lastContextView.contains("WEBVIEW_")) {
            driver.context("NATIVE_APP");
        }
        return this;
    }
      public WebViewHandle scrollDown(int numberOfTimes) {
        natives = new NativeDeviceActions(driver);
        natives.swipeManyTimes(numberOfTimes);
        return this;
    }


}

// TODO: 19.07.2024  zrobić jedną metode to switach contextu
// TODO: 19.07.2024 zrobic klase utils  oraz exceptions**


