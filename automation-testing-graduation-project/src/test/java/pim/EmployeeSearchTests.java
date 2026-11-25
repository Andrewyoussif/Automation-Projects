package pim;

import base.BaseTest;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.JsonReader;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Feature("PIM - Employee Search")
public class EmployeeSearchTests extends BaseTest {

    private EmployeeListPage openEmployeeList() {
        String user = JsonReader.get().get("validUser").get("username").asText();
        String pass = JsonReader.get().get("validUser").get("password").asText();
        new LoginPage().login(user, pass);
        new DashboardPage().openMenu("PIM");
        return new EmployeeListPage().waitForPage();
    }

    @Test(description = "TC4: Search for an employee")
    @Description("Search for a known employee and check the name appears in the results")
    public void searchExistingEmployee() {
        // The public demo data changes, so take a name that exists right now from the list
        EmployeeListPage list = openEmployeeList();
        String name = list.getFirstRowFirstName();
        list.searchByName(name);
        List<String> rows = list.getResultRowsText();
        Assert.assertFalse(rows.isEmpty(), "Results table should not be empty");
        Assert.assertTrue(rows.get(0).toLowerCase().contains(name.toLowerCase()),
                "Results should contain '" + name + "' but was: " + rows.get(0));
    }

    @Test(description = "TC5: Search for a non-existing employee")
    @Description("Search for a random name and check 'No Records Found' is displayed")
    public void searchNonExistingEmployee() {
        String name = JsonReader.get().get("nonExistingEmployee").asText();
        EmployeeListPage list = openEmployeeList().searchByName(name);
        Assert.assertTrue(list.isNoRecordsDisplayed(), "'No Records Found' should be displayed");
    }
}
