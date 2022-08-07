package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends TestBase {
    @BeforeMethod
    public void preCondition() {

    }

    @Test
    public void alertTest() {
        app.getAlert().navigateToAlert();
    }
}
