package extentReport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map extentTestMap = new HashMap();
    static String reportName = getReportName();
    static ExtentReports extent = ExtentManager.getReporter();

    public static String getReportName(){return reportName;}

    public static synchronized ExtentTest getTest(){
        return (ExtentTest) extentTestMap.get((int)(Thread.currentThread().getId()));
    }

    public static synchronized  ExtentTest startTest(String testName){
        ExtentTest test = extent.startTest(testName);
        extentTestMap.put((int)(Thread.currentThread().getId()), test);
        return test;
    }
}
