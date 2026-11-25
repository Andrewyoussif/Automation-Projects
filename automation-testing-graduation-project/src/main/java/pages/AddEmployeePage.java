package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AddEmployeePage extends BasePage {
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By saveButton = By.xpath("//button[normalize-space()='Save']");
    private final By firstNameError = By.xpath("//input[@name='firstName']/ancestor::div[contains(@class,'oxd-input-group')]//span[contains(@class,'oxd-input-field-error-message')]");
    private final By personalDetailsHeader = By.xpath("//h6[normalize-space()='Personal Details']");

    @Step("Wait for the Add Employee page")
    public AddEmployeePage waitForPage() {
        waitForUrlContains("/pim/addEmployee");
        waitVisible(firstName);
        return this;
    }

    @Step("Check the First Name and Last Name fields are displayed")
    public boolean areNameFieldsDisplayed() {
        return isDisplayed(firstName) && isDisplayed(lastName);
    }

    @Step("Enter first name '{0}'")
    public AddEmployeePage enterFirstName(String value) {
        type(firstName, value);
        return this;
    }

    @Step("Enter last name '{0}'")
    public AddEmployeePage enterLastName(String value) {
        type(lastName, value);
        return this;
    }

    @Step("Click Save")
    public void clickSave() {
        click(saveButton);
    }

    @Step("Read the First Name validation error")
    public String getFirstNameError() {
        return getText(firstNameError);
    }

    @Step("Check the Personal Details page is displayed")
    public boolean isPersonalDetailsDisplayed() {
        waitForUrlContains("/pim/viewPersonalDetails");
        return isDisplayed(personalDetailsHeader);
    }
}
