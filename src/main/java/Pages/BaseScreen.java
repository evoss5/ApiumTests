package Pages;

import Pages.Native.NativeDeviceActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;


public class BaseScreen {
    protected AndroidDriver driver;
    protected NativeDeviceActions natives;
    protected WebDriverWait wait;
    private static final int TIMEOUT = 5;


    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickElement(WebElement element) {
        int i = 0;
        while(true) {
            try{
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                break;
            }catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                i++;
            }
            if(i >= 2) {
                throw new RuntimeException("Maxmium tries reached");
            }
        }
    }
    public void sendKeysToElement(WebElement element, String text) {
        int i = 0;
        while (true) {
            try{
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.clear();
                element.sendKeys(text);
                break;
            }catch (ElementNotInteractableException | StaleElementReferenceException e) {
                i++;
            }
            if(i >=2) {
                throw new RuntimeException("Maximum tries reached");
            }
        }
    }
    public void sendKeysToElement(WebElement element, String text, String text2) {
        int i = 0;
        while (true) {
            try{
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.clear();
                element.sendKeys(text);
                break;
            }catch (ElementNotInteractableException | StaleElementReferenceException e) {
                i++;
            }
            if(i >=2) {
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
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    }
    }

