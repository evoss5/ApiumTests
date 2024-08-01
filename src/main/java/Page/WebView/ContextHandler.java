package Page.WebView;

import Page.BaseScreen;
import io.appium.java_client.android.AndroidDriver;

import java.util.Set;

public class ContextHandler extends BaseScreen {

    public ContextHandler(AndroidDriver driver) {
        super(driver);
    }

    public ContextHandler switchToWebView() {
        Set<String> contextNames = driver.getContextHandles();
        String lastContextView = (String) contextNames.toArray()[contextNames.size() - 1];

        if (lastContextView.contains("WEBVIEW_") || lastContextView.contains("WEBVIEW_com.xxxxxx.android.mobile.xxxxx")) {
            driver.context(lastContextView);
        }
        return this;
    }

    public ContextHandler switchBackToNative() {
        Set<String> contextNames = driver.getContextHandles();
        String lastContextView = (String) contextNames.toArray()[contextNames.size() - 1];
        if (lastContextView.contains("WEBVIEW_")) {
            driver.context("NATIVE_APP");
        }
        return this;
    }
      public ContextHandler scrollDown(int numberOfTimes) {
//        natives = new NativeDeviceActions(driver);
        natives.swipeManyTimes(numberOfTimes);
        return this;
    }
}

// TODO: 19.07.2024 zrobic klase utils  oraz exceptions**
// TODO: 01.08.2024 Nazwać klasę context handler, przenieść stąd scrollDown


