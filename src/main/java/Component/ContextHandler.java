package Component;

import Screen.BaseScreen;
import io.appium.java_client.android.AndroidDriver;

import java.util.Set;

public class ContextHandler extends BaseScreen {

    public ContextHandler(AndroidDriver driver) {
        super(driver);
    }

    public ContextHandler switchToWebView() {
        switchContext("WEBVIEW");
        return this;
    }

    public ContextHandler switchToNative() {
        switchContext("NATIVE_APP");
        return this;
    }
    // TODO: 19.08.2024 Zrobić jedną prywatną metodę oraz dwie publiczne na zmianę kontekstu (zrobione)

    private void switchContext(String contextType) {
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            if (contextType.equals("WEBVIEW") && (contextName.contains("WEBVIEW_") || contextName.contains("WEBVIEW_com.xxxxxx.android.mobile.xxxxx"))) {
                driver.context(contextName);
                return;
            } else if (contextType.equals("NATIVE_APP") && contextName.equals("NATIVE_APP")) {
                driver.context("NATIVE_APP");
                return;
            }
        }
    }

}



