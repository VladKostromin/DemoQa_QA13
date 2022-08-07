package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase {

    @BeforeClass
    public void preCondition() {
        app.getSelect().selectItemWidgets();
        app.getSelect().clickSelectMenu();
    }

    @Test
    public void selectOptionTest() {
        app.getSelect().selectOptionTest("Group 1, option 1");
    }
}
