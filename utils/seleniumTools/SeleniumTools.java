package seleniumTools;

import baseTest.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTools extends BaseTest {

    private int pollingSeconds = 5;
    WebDriverWait wait = new WebDriverWait(webDriver, 5);

    public WebElement getElementId(String id){
        return webDriver.findElement(By.id(id));
    }

    public WebElement getElementXpath(String xpath){
        return webDriver.findElement(By.xpath(xpath));
    }

    public void sendTextId(String id, String text){
        getElementId(id).sendKeys(text);
    }

    public void sendTextXpath(String xpath, String text){
        getElementXpath(xpath).sendKeys(text);
    }

    public void clickElementId(String id){
        getElementId(id).click();
    }

    public void clickElementXpath(String xpath){
        getElementXpath(xpath).click();
    }

    public boolean elementIsClikableId(By id){
        waitElementClickableId(id, 5);
        return true;
    }

    public boolean elementIsClikableXpath(By xpath){
        waitElementClickableXpath(xpath, 5);
        return true;
    }

    public boolean waitElementClickableXpath(By xpath, int seconds) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                    .withTimeout(Duration.ofSeconds(this.pollingSeconds))
                    .pollingEvery(Duration.ofSeconds(this.pollingSeconds))
                    .ignoring(NoSuchElementException.class);

            WebElement element = wait.until((WebDriver webdriver) -> {
                return webdriver.findElement(xpath);
            });
            return element != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean waitElementClickableId(By id, int seconds) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                    .withTimeout(Duration.ofSeconds(this.pollingSeconds))
                    .pollingEvery(Duration.ofSeconds(this.pollingSeconds))
                    .ignoring(NoSuchElementException.class);

            WebElement element = wait.until((WebDriver webdriver) -> {
                return webdriver.findElement(id);
            });
            return element != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getTextId(String id){
        String text = getElementId(id).getText();
        return text;
    }

    public String getTextXpath(String xpath){
        String text = getElementXpath(xpath).getText();
        return text;
    }

    public String verifyAlert(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String message = alert.getText();
        return message;
    }

    public void closeAlert(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
