package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListPage extends BasePage {
    private final By employeeNameInput = By.xpath("//label[normalize-space()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");
    private final By addEmployeeTab = By.xpath("//a[normalize-space()='Add Employee']");
    private final By resultRows = By.cssSelector(".oxd-table-body .oxd-table-card");
    private final By noRecords = By.xpath("//span[normalize-space()='No Records Found']");
    private final By recordsCount = By.xpath("//span[contains(normalize-space(),'Record') and contains(normalize-space(),'Found')]");

    @Step("Wait for the Employee List page")
    public EmployeeListPage waitForPage() {
        waitForUrlContains("/pim/viewEmployeeList");
        waitVisible(searchButton);
        return this;
    }

    @Step("Search for employee '{0}'")
    public EmployeeListPage searchByName(String name) {
        type(employeeNameInput, name);
        // let the autocomplete dropdown close, it is not needed for a plain name search
        click(By.xpath("//h5[normalize-space()='Employee Information']"));
        click(searchButton);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(resultRows),
                ExpectedConditions.visibilityOfElementLocated(noRecords)));
        return this;
    }

    @Step("Read the first name of the first employee in the list")
    public String getFirstRowFirstName() {
        By cell = By.cssSelector(".oxd-table-body .oxd-table-card:first-child .oxd-table-cell:nth-child(3) div");
        return getText(cell).split(" ")[0];
    }

    @Step("Read the result rows")
    public List<String> getResultRowsText() {
        List<String> rows = new ArrayList<>();
        for (WebElement e : driver.findElements(resultRows)) {
            rows.add(e.getText().replace("\n", " ").trim());
        }
        return rows;
    }

    @Step("Check that the 'No Records Found' message is displayed")
    public boolean isNoRecordsDisplayed() {
        return isDisplayed(noRecords);
    }

    @Step("Click the 'Add Employee' tab")
    public void clickAddEmployee() {
        click(addEmployeeTab);
    }
}
