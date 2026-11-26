package ui;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import utils.JsonReader;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Feature("UI")
public class UiTests extends BaseTest {

    private void login() {
        String user = JsonReader.get().get("validUser").get("username").asText();
        String pass = JsonReader.get().get("validUser").get("password").asText();
        new LoginPage().login(user, pass);
    }

    @Test(description = "TC10: Verify the footer branding link")
    @Description("Check the footer text and that the link opens orangehrm.com in a new tab")
    public void footerBrandingLink() {
        LoginPage login = new LoginPage();
        Assert.assertTrue(login.getFooterText().contains("OrangeHRM, Inc"), "Footer should contain 'OrangeHRM, Inc'");
        String url = login.clickFooterLinkAndGetNewTabUrl();
        Assert.assertTrue(url.contains("orangehrm.com"), "New tab URL should contain orangehrm.com but was: " + url);
    }

    @Test(description = "TC11: Verify sidebar menu UI")
    @Description("Log in and check the sidebar has all expected menu items")
    public void sidebarMenuItems() {
        login();
        List<String> actual = new DashboardPage().getSidebarItems();
        List<String> expected = new ArrayList<>();
        JsonReader.get().get("sidebarItems").forEach(n -> expected.add(n.asText()));
        for (String item : expected) {
            Assert.assertTrue(actual.contains(item), "Sidebar should contain '" + item + "' but was " + actual);
        }
    }
}
