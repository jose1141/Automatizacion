package support;

//import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class util extends hooks {
    public WebDriverWait wait;
    //public WebDriver driver;

    public util() {
        if (driver == null) { setUp();}
//        wait = new WebDriverWait(driver, 2);


        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);

    }

    public static void screenshot() throws IOException {
        Date Date = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("ddMMyyyy_HHmmss");
        String ruta="target\\screenshot\\"+fecha.format(Date)+"_screenshot.jpg";
        File file = ((TakesScreenshot) hooks.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(ruta));
    }

}
