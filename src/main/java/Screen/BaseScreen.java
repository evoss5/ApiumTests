package Screen;

import Component.DeviceAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.logging.Logger;


public class BaseScreen {
    protected AndroidDriver driver;
    protected DeviceAction natives;
    protected WebDriverWait wait;
    private static final int TIMEOUT = 10;
    private static final Logger logger = Logger.getLogger(BaseScreen.class.getName());




    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void clickElement(WebElement element) {
        int i = 0;
        while (true) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                i++;
            }
            if (i >= 2) {
                throw new RuntimeException("Maxmium tries reached");
            }
        }
    }
    public String elementGetText(WebElement element) {
        int i = 0;
        while(true){
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                element.getText();
                break;
            } catch (StaleElementReferenceException | NoSuchElementException e) {
                i++;
            }
            if (i >= 2) {
                throw new RuntimeException("Maximum tries reached");
            }
        }
        return element.getText();
    }

    public void sendKeysToElement(WebElement element, String text) {
        int i = 0;
        while (true) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.clear();
                element.sendKeys(text);
                break;
            } catch (ElementNotInteractableException | StaleElementReferenceException e) {
                i++;
            }
            if (i >= 2) {
                throw new RuntimeException("Maximum tries reached");
            }
        }
    }

    public void sendKeysToElement(WebElement element, String text, String text2) {
        int i = 0;
        while (true) {
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.clear();
                element.sendKeys(text);
                break;
            } catch (ElementNotInteractableException | StaleElementReferenceException e) {
                i++;
            }
            if (i >= 2) {
                throw new RuntimeException("Maximum tries reached");
            }
        }
    }

    public void tapElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.click(element);
    }

    public void takeScreenshot() {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }


    public boolean isElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            logger.warning("Element is not visible:  + e.getMessage()");
            return false;
        }
    }
    public boolean isElementClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (ElementNotInteractableException | NoSuchElementException | StaleElementReferenceException e) {
            logger.warning("Element is not clickable: " + e.getMessage());
            return false;
        }
    }
    public boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            logger.warning("Element is not present:  + e.getMessage()");
            return false;
        }
    }


}