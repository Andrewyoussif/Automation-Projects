package login;

import com.fasterxml.jackson.databind.JsonNode;
import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import utils.JsonReader;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

@Feature("Login")
public class LoginTests extends BaseTest {

    @DataProvider(name = "validUser")
    public Object[][] validUser() {
        JsonNode u = JsonReader.get().get("validUser");
        return new Object[][]{{u.get("username").asText(), u.get("password").asText()}};
    }

    @DataProvider(name = "invalidUsers")
    public Object[][] invalidUsers() {
        JsonNode list = JsonReader.get().get("invalidLogins");
        Object[][] data = new Object[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).get("username").asText();
            data[i][1] = list.get(i).get("password").asText();
        }
        return data;
    }

    @Test(dataProvider = "validUser", description = "TC1: Login with valid credentials")
    @Description("Login with a valid user and check the dashboard opens")
    public void validLogin(String username, String password) {
        LoginPage login = new LoginPage();
        login.login(username, password);
        login.waitForUrlContains("/dashboard/index");
        Assert.assertTrue(login.getCurrentUrl().contains("/dashboard/index"), "URL should contain /dashboard/index");
        Assert.assertEquals(new DashboardPage().getHeaderText(), "Dashboard", "Dashboard header");
    }

    @Test(dataProvider = "invalidUsers", description = "TC2: Login with invalid credentials")
    @Description("Login with wrong credentials and check the error message")
    public void invalidLogin(String username, String password) {
        LoginPage login = new LoginPage();
        login.login(username, password);
        Assert.assertEquals(login.getErrorMessage(), "Invalid credentials");
    }

    @Test(description = "TC3: Login with empty fields")
    @Description("Click Login with empty fields and check both Required messages")
    public void emptyLogin() {
        LoginPage login = new LoginPage();
        login.clickLogin();
        List<String> errors = login.getFieldErrors();
        Assert.assertEquals(errors.size(), 2, "Two validation messages expected");
        for (String e : errors) {
            Assert.assertEquals(e, "Required");
        }
    }
}
