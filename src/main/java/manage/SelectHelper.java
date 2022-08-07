package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectHelper extends HelperBase {

    public SelectHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectItemWidgets() {
        webDriver.findElement(By.cssSelector(".category-cards div:nth-child(4)")).click();
        clickSelectMenu();
    }

    public void clickSelectMenu() {
        webDriver.findElement(By.xpath("//span[text()='Select Menu']")).click();
    }

    public void selectOptionTest(String text) {
        webDriver.findElement(By.id("withOptGroup")).click();
        String locator = "//*[text()='" + text + "']";
        webDriver.findElement(By.xpath(locator)).click();
    }
}
