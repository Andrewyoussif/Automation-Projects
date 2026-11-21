package dropDown;

import base.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.DropDownPage;

import java.util.List;

import static org.testng.Assert.*;

public class DropDownTests extends BaseTests {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void verifyOption(){
        DropDownPage dropdown = homePage.clickDropDown();
        String option = "Option 1";
        dropdown.chooseFromDropDown(option);
        List<String> options = dropdown.getOptionFromDropDown();
        assertTrue(options.contains(option),"The options is not correct");
        assertEquals(options.size(),1,"The Number of Elements is not correct");
    }
}
