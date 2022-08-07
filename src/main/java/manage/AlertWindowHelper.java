package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertWindowHelper extends HelperBase{


    public AlertWindowHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigateToAlert() {
        webDriver.findElement(By.xpath("//h5[.='Alerts, Frame & Windows']")).click();
        webDriver.findElement(By.xpath("//span[.='Alerts']")).click();
    }
}
