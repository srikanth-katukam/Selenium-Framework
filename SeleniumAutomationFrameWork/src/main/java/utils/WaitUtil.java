package utils;

import logger.Log;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Function;


/**
 * Created by Skatukam on 02/28/2018.
 */

public class WaitUtil implements IConstants {
/**
 * Wait for the element to be present in the DOM, and displayed on the page.
 * And returns the first WebElement using the given method.
 *
 * @param driver
 *            The driver object to be used
 * @param webElement
 *            selector to find the element
 * @return WebElement the first WebElement using the given method, or null
 *         (if the timeout is reached)
 **/
    public static void waitForElementPresent(final WebDriver driver, final WebElement webElement){
        try{
            FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                    .withTimeout(MAX_ELEMENT_WAIT, TimeUnit.SECONDS)
                    .pollingEvery(POLLING_WAIT,TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            final WebElement lelement = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return webElement;
                }
            });
        }catch (Exception e){
            Log.info(String.format("Element %s did not appear in specified time",webElement),e);

        }

    }
    /**
     * Wait for the element to be present in the DOM, and displayed on the page.
     * And returns the first WebElement using the given method.
     *
     * @param driver
     *            The driver object to be used
     * @param webElement
     *            selector to find the element
     * @param timeOutInSeconds
     *            Provide custom timeout to verify the element
     * @return WebElement the first WebElement using the given method, or null
     *         (if the timeout is reached)
     **/
    public static void waitForElementPresent(WebDriver driver, final WebElement webElement,int timeOutInSeconds){
        try{
            FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                    .withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
                    .pollingEvery(POLLING_WAIT,TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);
            WebElement lelement = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver ldriver) {
                    return webElement;
                }
            });
        }catch (Exception e){
            Log.info(String.format("Element %s did not appear in specified time",webElement),e);
        }

    }
    public static boolean isTextPresent(WebDriver driver, final WebElement webElement,String text){
        //waitForElementPresent(driver,webElement);
        try{
            return (webElement.getText()).equals(text);
        }catch (Exception e){
            Log.info(String.format("Text %s is not present",text),e);
            return false;
        }

    }

}
