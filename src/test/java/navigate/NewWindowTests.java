package navigate;

import base.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NewWindowTests extends BaseTests {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void newWindowTest(){
        var window = homePage.clickMultipleWindows().clickHereLink();
        getWindowManager().switchToWindow("New Window");
        assertEquals(window.getHeaderText(),"New Window","Incorrect header text");
    }
}
