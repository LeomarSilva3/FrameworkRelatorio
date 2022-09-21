package extentReport;

import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ExtentManager {
    static ExtentReports extent;
    final static String filePath = ".html";

    public static String getDataHora(){
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy_hh.mm");
        return formatter.format(calendar.getTime());
    }

    public static String captureEvidence(WebDriver driver){
        TakesScreenshot newScreen = (TakesScreenshot) driver;
        String print = newScreen.getScreenshotAs(OutputType.BASE64);
        return "data:image/jpg;base64, " + print;
    }

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            extent = new ExtentReports("utils/reports/report_" + getDataHora() + filePath, true );
        }
        extent.loadConfig(new File("report-config.xml"));
        return extent;
    }
}
