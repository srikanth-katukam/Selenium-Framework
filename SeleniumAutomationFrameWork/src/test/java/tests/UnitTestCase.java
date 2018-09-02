package tests;

import factory.BrowserFactory;
import factory.DataProvider;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Element;
import logger.Log;
import utils.Button;

/**
 * Created by Skatukam on 02/27/2018.
 */
public class UnitTestCase {
    WebDriver driver;
    //WebDriver driver1;
      Button button=new Button();
    private static final String ROUNDTRIP="RoundTrip";
    @BeforeTest
    public void setUp()
    {
        Log.info("Browser instantiated.");
        System.out.println("Print : Browser instantiated.");
        driver= BrowserFactory.getBrowser("chrome");
        //driver1= BrowserFactory.getBrowser("chrome");
        BrowserFactory.loadApplication(DataProvider.getConfig().appURL());
        //driver.get(DataProvider.getConfig().appURL());
    }
    @Test
    public void clickRoundTrip()
    {
        button.click(ROUNDTRIP);
        //driver.findElement(By.id(ROUNDTRIP)).click();
        Log.info("Clicked on Rountrip Box");
       // driver=element.getDriver();
        driver.quit();

    }
    @After
    public void tear()
    {
        driver.quit();
    }
}
