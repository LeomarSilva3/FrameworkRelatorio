package baseTest;

import com.relevantcodes.extentreports.LogStatus;
import enums.UrlsEnum;
import extentReport.ExtentManager;
import extentReport.ExtentTestManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {
    public static WebDriver webDriver;
    static String path = "D:\\Projetos\\FrameworkAtomacaoReport\\drivers\\chromedriver.exe";

    @BeforeMethod
    public WebDriver startTest(Method method){
        if(webDriver == null){
            createDriver();
            ExtentTestManager.startTest(method.getName());
        }
        return webDriver;
    }

    public void createDriver(){
        try {
            if (webDriver == null) {
                if (path.contains("chrome")) {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("headless");
                    System.setProperty("webdriver.chrome.driver", path);
                    webDriver = new ChromeDriver(chromeOptions);
                    webDriver.get(UrlsEnum.EXEMPLO_URL.getUrl());
                    webDriver.manage().window().maximize();

                } else if (path.contains("gecko")) {
                    //configuração do FirefoxDriver

                } else if (path.contains("edge")) {
                    //configuração do EdgeDrive

                }

            }
        }catch(Exception e){
                e.printStackTrace();
            }
    }

    public void killDriver(){
        if(webDriver != null){
            webDriver.quit();
            webDriver = null;
        }
    }

    @AfterMethod
    protected  void  finishDriver(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());

        }else{
            ExtentTestManager.getTest().log(LogStatus.PASS, "!! Test Passou !!" + ExtentTestManager.getTest().
                    addBase64ScreenShot(ExtentManager.
                            captureEvidence(webDriver)));
        }
        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        ExtentManager.getReporter().flush();

        killDriver();
    }
}
