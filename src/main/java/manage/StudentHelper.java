package manage;

import dto.Student;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StudentHelper extends HelperBase {

    public StudentHelper(WebDriver webDriver) {
        super(webDriver);
    }


    public void selectFormMenu() {
        webDriver.findElement(By.xpath("//*[text()='Forms']")).click();
        webDriver.findElement(By.xpath("//span[text()='Practice Form']")).click();
    }

    public void fillStudentForm(Student student) {
        if(isFormPresent()) {
            type(By.id("firstName"), student.getFirstName());
            type(By.id("lastName"), student.getLastName());
            type(By.id("userEmail"), student.getEmail());
            genderButtonClick(student.getGender());
            type(By.id("userNumber"), student.getMobile());
            dateSelector(student.getDateOfBirth());
            subjectAutoComplete(student.getSubjects());
            hobbiesCheckBox(student.getHobbies());
            attackPhoto(student.getPicture());
            textAreaInput(student.getCurrentAddress());
            stateAndCityAutoComplete(student.getState(), student.getCity());

        }

    }

    private void attackPhoto(String picture) {
        webDriver.findElement(By.id("uploadPicture")).sendKeys(picture);
    }

    public boolean isFormPresent() {
        return new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h5"), "Student Registration Form"));
    }

    private void genderButtonClick(String genderOption) {
        switch (genderOption) {
            case "male":
                webDriver.findElement(By.xpath("//label[.='Male']")).click();
                break;
            case "female":
                webDriver.findElement(By.xpath("//label[.='Female']")).click();
                break;
            case "other":
                webDriver.findElement(By.xpath("//label[.='Other']")).click();
                break;
            default:
                System.out.println("wrong option was picked");
        }

    }

    private void dateSelector(String dateOfBirth) {
        webDriver.findElement(By.id("dateOfBirthInput")).click();
        String splitter[] = dateOfBirth.split(" ");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Integer.parseInt(splitter[1]) - 1);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLLL", Locale.ENGLISH);
        String monthResult = dateFormat.format(date);

        new Select(webDriver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"))).selectByVisibleText(monthResult);
        new Select(webDriver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"))).selectByValue(splitter[2]);

        List<WebElement> elements = webDriver.findElements(By.cssSelector("div[aria-label*='" + monthResult + "']"));
        elements.get(Integer.parseInt(splitter[1])).click();
    }

    private void subjectAutoComplete(String[] subjects) {
        for (String text : subjects) {
            type(By.id("subjectsInput"), text);
            webDriver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
        }
    }

    private void hobbiesCheckBox(String[] hobbies) {
        for (String hobby: hobbies) {
            webDriver.findElement(By.xpath("//label[text()='" + hobby + "']")).click();
        }
    }

    private void stateAndCityAutoComplete(String state, String city) {
        webDriver.findElement(By.xpath("//div[text()='Select State']")).click();
        Actions act = new Actions(webDriver);
        act.moveToElement(webDriver.findElement(By.xpath("//div[starts-with(text(),'" + state +"')]"))).click().perform();
        webDriver.findElement(By.xpath("//div[text()='Select City']")).click();
        act.moveToElement(webDriver.findElement(By.xpath("//div[starts-with(text(),'" + city +"')]"))).click().perform();

//        webDriver.findElement(By.xpath("//div[text()='Select State']")).click();

//        String locator = "//*[text()='"+ state +"']";
//        webDriver.findElement(By.xpath(locator));

    }
    private void textAreaInput(String text) {
        WebElement element = webDriver.findElement(By.id("currentAddress"));
        element.sendKeys(Keys.TAB);
        element.clear();
        element.sendKeys(text);
    }

    public void submitForm() {
        hideFooter();
        webDriver.findElement(By.id("submit")).click();
    }

    private void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    public boolean isSubmitFormPresent() {
        return webDriver.findElement(By.id("example-modal-sizes-title-lg")).getText().contains("Thanks for submitting the form");
    }
}
