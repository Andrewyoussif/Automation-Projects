package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AddUserPage extends BasePage {
    private final By addButton = By.xpath("//button[normalize-space()='Add']");

    @Step("Click Add")
    public AddUserPage clickAdd() {
        click(addButton);
        waitForUrlContains("/admin/saveSystemUser");
        return this;
    }

    @Step("Check that the field '{0}' is displayed on the form")
    public boolean isFieldDisplayed(String label) {
        return isDisplayed(By.xpath("//label[normalize-space()='" + label + "']"));
    }
}
