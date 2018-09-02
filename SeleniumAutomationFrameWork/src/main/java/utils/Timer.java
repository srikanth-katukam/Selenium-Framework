package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Skatukam on 02/27/2018.
 */
/**
 * TimeTool utility for Chon, who is lazy to remember things.  :-) */
public class Timer {
    /** Return the current time in "MMM dd,yyyy HH:mm:ss" format. */
    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
        return sdf.format(new Date().getTime());
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
