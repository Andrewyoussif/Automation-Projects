package admin;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddUserPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.JsonReader;

@Feature("Admin")
public class AddUserTests extends BaseTest {

    private void login() {
        String user = JsonReader.get().get("validUser").get("username").asText();
        String pass = JsonReader.get().get("validUser").get("password").asText();
        new LoginPage().login(user, pass);
    }

    @Test(description = "TC9: Verify Admin > Add User page")
    @Description("Open Admin > Users > Add and check the form fields")
    public void addUserFormFields() {
        login();
        new DashboardPage().openMenu("Admin");
        AddUserPage page = new AddUserPage().clickAdd();
        for (String field : new String[]{"User Role", "Employee Name", "Username", "Password"}) {
            Assert.assertTrue(page.isFieldDisplayed(field), "Field should be displayed: " + field);
        }
    }
}
