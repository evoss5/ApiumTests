package Pages.WebView;

import Pages.BaseScreen;
import Pages.Native.NativeDeviceActions;
import io.appium.java_client.android.AndroidDriver;

import java.util.Set;

public class WebViewHandle extends BaseScreen {

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

// TODO: 19.07.2024 zrobic klase utils  oraz exceptions**


