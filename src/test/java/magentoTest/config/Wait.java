package magentoTest.config;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import magentoTest.AppTest;

import java.time.Duration;
import java.util.List;

public class Wait {
    private final WebDriver driver;

    final JavascriptExecutor js;

    public Wait(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    private void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public void forLoading(int timeout) {
        ExpectedCondition<Object> condition = ExpectedConditions
                .jsReturnsValue("return document.readyState==\"complete\";");
        String timeoutMessage = "Page didn't load after " + timeout + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
        try {
            Thread.sleep(timeout * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement forElementToBeDisplayed(int timeout, By by) {
        String timeoutMessage = by.getClass().getSimpleName() + " wasn't displayed after " + timeout + " seconds.";
        for (int i=0; i < timeout+1;  i++) {
            try{
                ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(driver.findElement(by));
                waitUntilCondition(condition, timeoutMessage, 1);
                WebElement element = driver.findElement(by);
                js.executeScript("arguments[0].scrollIntoView();", element);
                return (element);
            }catch (NoSuchElementException | StaleElementReferenceException e){
                e.printStackTrace();
            }
        }
        throw new NoSuchElementException("cannot find element");
    }

    public List<WebElement> forElementsToBeDisplayed(int timeout, By by) {
        String timeoutMessage = by.getClass().getSimpleName() + " wasn't displayed after " + timeout + " seconds.";
        for (int i=0; i < timeout+1;  i++) {
            try{
                ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(driver.findElement(by));
                waitUntilCondition(condition, timeoutMessage, 1);
                return driver.findElements(by);
            }catch (NoSuchElementException | StaleElementReferenceException e){
                e.printStackTrace();
            }
        }
        throw new NoSuchElementException("cannot find element");
    }

    public void forPresenceOfElements(int timeout, By elementLocator, String elementName) {
        ExpectedCondition<List<WebElement>> condition = ExpectedConditions
                .presenceOfAllElementsLocatedBy(elementLocator);
        String timeoutMessage = elementName + " elements were not displayed after " + timeout
                + " seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }


    public static void main(String args[]){
        System.out.println(System.getProperty("user.dir"));
    }
}
