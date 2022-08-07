package tests;

import manage.ApplicationManager;
import org.testng.annotations.*;

public class TestBase {

    static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void appSetup() throws InterruptedException {
        app.init();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        app.stop();
    }



}
