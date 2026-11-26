package alerts;

import base.BaseTests;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertTests extends BaseTests {
    @Test
    @Epic("Js")
    @Story("Alert")
    @Description("This Method Test the Alert")
    @Severity(SeverityLevel.CRITICAL)
    public void alertTest(){
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.clickAlertByText("Click for JS Alert");
        assertEquals(alertPage.getAlertText(),"I am a JS Alert","Incorrect Alert Message");
        alertPage.acceptAlert();
        assertEquals(alertPage.getResult(),"You successfully clicked an alert","Incorrect result Alert Message");
    }
    @Test
    @Epic("Js")
    @Story("Confirm")
    @Description("This Method Test the Confirm")
    @Severity(SeverityLevel.NORMAL)
    public void confirmTest(){
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.clickAlertByText("Click for JS Confirm");
        assertEquals(alertPage.getAlertText(),"I am a JS Confirm","Incorrect Confirm Message");
        alertPage.dismissAlert();
        assertEquals(alertPage.getResult(),"You clicked: Cancel","Incorrect result Confirm Message");
    }
    @Test
    @Epic("Js")
    @Story("Prompt")
    @Description("This Method Test the Prompt")
    @Severity(SeverityLevel.MINOR)
    public void promptTest(){
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.clickAlertByText("Click for JS Prompt");
        assertEquals(alertPage.getAlertText(),"I am a JS prompt","Incorrect Prompt Message");
        alertPage.setAlerttext("Andrew");
        alertPage.acceptAlert();
        assertEquals(alertPage.getResult(),"You entered: Andrew","Incorrect result Prompt Message");
    }
}
