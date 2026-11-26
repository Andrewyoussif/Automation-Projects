package navigate;

import base.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


public class NavigationTests extends BaseTests {
    @Test
    @Severity(SeverityLevel.MINOR)
    public void navigationTests(){
        homePage.clickDynamicLoading().clickEx1();
        getWindowManager().goBack();
        getWindowManager().goForward();
        getWindowManager().refresh();
        getWindowManager().goToURL("http://www.google.com");
    }
}
