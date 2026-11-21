package waits;

import base.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WaitsTests extends BaseTests {
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void ex1WaitsTest(){
        var ex1 = homePage.clickDynamicLoading().clickEx1();
        ex1.clickStartButton();
        assertEquals(ex1.getEx1Text(),"Hello World!","Incorrect ex1 text");
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void ex2WaitsTest(){
        var ex2 = homePage.clickDynamicLoading().clickEx2();
        ex2.clickStartButton();
        assertEquals(ex2.getEx2Text(),"Hello World!","Incorrect ex2 text");
    }
}
