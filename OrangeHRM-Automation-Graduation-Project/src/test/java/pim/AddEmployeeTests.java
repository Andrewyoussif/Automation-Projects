package pim;

import com.fasterxml.jackson.databind.JsonNode;
import base.BaseTest;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.JsonReader;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Feature("PIM - Add Employee")
public class AddEmployeeTests extends BaseTest {

    private AddEmployeePage openAddEmployee() {
        String user = JsonReader.get().get("validUser").get("username").asText();
        String pass = JsonReader.get().get("validUser").get("password").asText();
        new LoginPage().login(user, pass);
        new DashboardPage().openMenu("PIM");
        new EmployeeListPage().waitForPage().clickAddEmployee();
        return new AddEmployeePage().waitForPage();
    }

    @Test(description = "TC6: Open Add Employee page")
    @Description("Open Add Employee from the PIM menu and check the name fields")
    public void openAddEmployeePage() {
        AddEmployeePage page = openAddEmployee();
        Assert.assertTrue(page.getCurrentUrl().contains("/pim/addEmployee"));
        Assert.assertTrue(page.areNameFieldsDisplayed(), "First Name and Last Name should be displayed");
    }

    @Test(description = "TC7: Add employee with an empty required field")
    @Description("Enter only the last name and check the First Name 'Required' error")
    public void addEmployeeWithoutFirstName() {
        AddEmployeePage page = openAddEmployee();
        page.enterLastName(JsonReader.get().get("newEmployee").get("lastName").asText());
        page.clickSave();
        Assert.assertEquals(page.getFirstNameError(), "Required");
    }

    @Test(description = "TC8: End-to-end add a new employee")
    @Description("Add an employee, check Personal Details opens, then find the employee in the list")
    public void addEmployeeEndToEnd() {
        JsonNode emp = JsonReader.get().get("newEmployee");
        // unique last name so the search only matches this run's employee
        String first = emp.get("firstName").asText();
        String last = emp.get("lastName").asText() + System.currentTimeMillis() % 100000;

        AddEmployeePage page = openAddEmployee();
        page.enterFirstName(first).enterLastName(last);
        page.clickSave();
        Assert.assertTrue(page.isPersonalDetailsDisplayed(), "Personal Details page should open");

        new DashboardPage().openMenu("PIM");
        EmployeeListPage list = new EmployeeListPage().waitForPage().searchByName(first + " " + last);
        List<String> rows = list.getResultRowsText();
        Assert.assertFalse(rows.isEmpty(), "New employee should appear in the results");
        Assert.assertTrue(rows.get(0).contains(first) && rows.get(0).contains(last),
                "Row should contain the new employee but was: " + rows.get(0));
    }
}
