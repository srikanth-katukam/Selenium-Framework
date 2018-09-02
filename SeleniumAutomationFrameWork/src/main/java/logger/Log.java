package logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static com.relevantcodes.extentreports.LogStatus.*;

/**
 * Created by Skatukam on 02/27/2018.
 */
public class Log {
    static ExtentReports extentReports=new ExtentReports(".\\Reports\\ExecutionReport.html",true);
    static ExtentTest extentTest=extentReports.startTest("Logs");

    public static void info(String message){
        extentTest.log(INFO,message);
        reportLog();
    }
    public static void info(String message,Exception e){
        extentTest.log(INFO,message,e);
        reportLog();
    }
    public static void error(String message){
        extentTest.log(ERROR,Log.class.getCanonicalName(),message);
        reportLog();
    }
    public static void error(String message,Exception e){
        extentTest.log(ERROR,Log.class.getCanonicalName(),e);
        reportLog();
    }
    public static void fail(String message){
        extentTest.log(FAIL,message);
        reportLog();
    }
    public static void skip(String message){
        extentTest.log(SKIP,message);
    }
    public static void pass(String message){
        extentTest.log(PASS,message);
        reportLog();
    }
    public static void unknown(String message){
        extentTest.log(UNKNOWN,message);
        reportLog();
    }
    public static void warning(String message){
        extentTest.log(WARNING,message);
        reportLog();
    }
    public static void reportLog()
    {
        extentReports.endTest(extentTest);
        extentReports.flush();
    }


}
