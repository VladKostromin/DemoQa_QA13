package manage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {

    WebDriver webDriver;
    AlertWindowHelper alert;
    SelectHelper select;
    StudentHelper student;
    String targetUrl = "https://demoqa.com/";



    public void init() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("load-extension=/Users/user/Tools/5.0.2_0");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        webDriver.navigate().to(targetUrl);
        Thread.sleep(5000);
        hideFooter();
        returnToDemoQa();
        alert = new AlertWindowHelper(webDriver);
        select = new SelectHelper(webDriver);
        student = new StudentHelper(webDriver);

    }

    public void stop() {
        webDriver.quit();
    }

    public AlertWindowHelper getAlert() {
        return alert;
    }

    public SelectHelper getSelect() {
        return select;
    }

    public StudentHelper getStudent() {
        return student;
    }

    private void returnToDemoQa() {
        List<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1)).close();
        webDriver.switchTo().window(tabs.get(0));
    }
    private void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

}
