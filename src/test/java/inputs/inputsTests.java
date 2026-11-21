package inputs;

import base.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.InputsPage;

import static org.testng.Assert.assertEquals;

public class inputsTests extends BaseTests {
    @Test
    @Severity(SeverityLevel.MINOR)
    public void inputsTest(){
        InputsPage inputsPage = homePage.clickInputsLink();
        String header = inputsPage.getHeader();
        assertEquals(header, "Inputs",
                "The Header is Incorrect");
    }
}
