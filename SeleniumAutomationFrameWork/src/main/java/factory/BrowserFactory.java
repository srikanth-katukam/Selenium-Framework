package factory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.security.InvalidParameterException;

/**
 * Created by Skatukam on 02/27/2018.
 */
public class BrowserFactory {
    static WebDriver driver;
    public static WebDriver getBrowser(String browserName)
    {
        ExtentReports extentReports=new ExtentReports(".\\Reports\\Report.html", true);
        ExtentTest extentTest=extentReports.startTest("Reports1");
        if(browserName.equalsIgnoreCase("firefox"))
        {
            extentTest.log(LogStatus.INFO,"Firefox browser launched");
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("chrome"))
        {
            extentTest.log(LogStatus.INFO,"chrome browser launched");
            System.setProperty("webdriver.chrome.driver", DataProvider.getConfig().chromePath());
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("ie"))
        {
            extentTest.log(LogStatus.INFO,"chrome browser launched");
            System.setProperty("webdriver.ie.driver", DataProvider.getConfig().iePath());
            driver = new ChromeDriver();
        }
        else throw new InvalidParameterException("unknown browser: " + browserName);
        return driver;
    }
    /* Pass the driver object */
    public static WebDriver getDriver(){
        return driver;
    }
    public static void loadApplication(String url){
        driver.get(url);
    }

}
