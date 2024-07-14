package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    private static final int TIMEOUT = 5;

    public BasePage(AndroidDriver driver) {
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

    }

