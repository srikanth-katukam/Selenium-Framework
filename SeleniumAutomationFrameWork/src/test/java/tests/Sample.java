package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static utils.Screenshot.driver;

/**
 * Created by Skatukam on 07/13/2018.
 */
public class Sample
{
    @Test()
    public void testsample()
    {
        //WebDriver driver=new FirefoxDriver();
        driver= BrowserFactory.getBrowser("chrome");
        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        //webDriverWait.until();
        /*FluentWait<WebDriver>webDriverFluentWait=new FluentWait<WebDriver>(driver)
                .withTimeout(15,TimeUnit.SECONDS)
                .pollingEvery(5,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
       // WebElement element= webDriverFluentWait.until()*/
WebElement element=driver.findElement(By.id("from_station"));
        element.sendKeys("Hyderabad Decan (HYB)");
        String text=element.getText();
        System.out.println("The text selected is"+text );
        //Alert
        driver.switchTo().alert().sendKeys("Test");
        driver.switchTo().alert().accept();;
        driver.switchTo().alert().dismiss();
        String s = driver.switchTo().alert().getText();
        String windowHandle = driver.getWindowHandle();
        Set list= driver.getWindowHandles();
        //Frames
        driver.switchTo().frame("test");
        driver.switchTo().defaultContent();
        HttpURLConnection httpURLConnection=new HttpURLConnection() {
            @Override
            public void disconnect() {

            }

            @Override
            public boolean usingProxy() {
                return false;
            }

            @Override
            public void connect() throws IOException {

            }
        }
    }
}
