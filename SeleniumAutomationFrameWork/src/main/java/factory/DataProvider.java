package factory;

import dataprovider.ConfigDataProvider;
import dataprovider.ExcelDataProvider;

/**
 * Created by Skatukam on 02/27/2018.
 */
public class DataProvider
{
    public static ConfigDataProvider getConfig()
    {
        ConfigDataProvider configDataProvider=new ConfigDataProvider();
        return configDataProvider;
    }
    public static ExcelDataProvider getExcel()
    {
        ExcelDataProvider excelDataProvider=new ExcelDataProvider();
        return excelDataProvider;

    }

}
