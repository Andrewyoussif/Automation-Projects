package login;

import base.BaseTests;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class loginPageTests extends BaseTests {
    @Test
    @Epic("Authentication")
    @Story("Login")
    @Description("This Method Test Valid Login")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        var SecureAreaPage = loginPage.clickLoginButton();
        String message= SecureAreaPage.getAlertMessage();
        assertTrue(message.contains("You logged into a secure area!"),
                "You didn't login successfully");


    }
}
