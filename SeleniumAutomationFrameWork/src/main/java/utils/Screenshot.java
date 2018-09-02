package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Skatukam on 02/27/2018.
 */
public class Screenshot {
    public static WebDriver driver;

    /** @return file where the screenshot was written */
    public static File takeScreenshot(String filepath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot ) driver;
        if (takesScreenshot == null)
            return null;

        OutputType<byte[]> target = OutputType.BYTES;
        byte screenshotAsPngBytes[] = takesScreenshot.getScreenshotAs(target);
        File targetFile = new File(filepath+ ".png");
        try {
            saveScreenshot(targetFile, screenshotAsPngBytes);

            return targetFile;
        } catch (IOException e) {
            //Log.debug("Exception thrown while taking screenshot." ,e);
            return null;
        }

    }



    protected static void saveScreenshot(File target, byte screenshotAsPngBytes[])
            throws IOException {
        OutputStream os = new FileOutputStream(target);
        os.write(screenshotAsPngBytes);
        os.close();
    }
}


