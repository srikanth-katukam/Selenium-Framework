package dataprovider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Skatukam on 02/27/2018.
 */
public class ConfigDataProvider {
Properties properties;
    public ConfigDataProvider()
    {
        File file=new File("./AppConfig/Application.properties");
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            properties=new Properties();
            properties.load(fileInputStream);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String appURL() {
        String url = properties.getProperty("url");
        return url;
    }
    public String chromePath()
    {
        String ChromePath = properties.getProperty("chromePath");
        return ChromePath;
    }
    //Get the browser Path from config.properties file
    public String iePath()
    {
        String IEPath = properties.getProperty("iePath");
        return IEPath;
    }
    public String firefoxPath()
    {
        String firefoxPath = properties.getProperty("firefoxPath");
        return firefoxPath;
    }
}
