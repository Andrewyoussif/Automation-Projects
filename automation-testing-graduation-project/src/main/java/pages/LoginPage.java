package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LoginPage extends BasePage {
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By errorAlert = By.cssSelector(".oxd-alert-content-text");
    private final By fieldErrors = By.cssSelector(".oxd-input-field-error-message");
    private final By footer = By.cssSelector(".orangehrm-login-footer");
    private final By footerLink = By.xpath("//div[contains(@class,'orangehrm-login-footer')]//a[contains(.,'OrangeHRM, Inc')]");

    @Step("Enter username '{0}'")
    public LoginPage enterUsername(String username) {
        type(usernameInput, username);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        type(passwordInput, password);
        return this;
    }

    @Step("Click Login")
    public void clickLogin() {
        click(loginButton);
    }

    @Step("Login with username '{0}'")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    @Step("Read the error message")
    public String getErrorMessage() {
        return getText(errorAlert);
    }

    @Step("Read the validation messages under the fields")
    public List<String> getFieldErrors() {
        wait.until(ExpectedConditions.numberOfElementsToBe(fieldErrors, 2));
        List<String> texts = new ArrayList<>();
        for (WebElement e : driver.findElements(fieldErrors)) {
            texts.add(e.getText().trim());
        }
        return texts;
    }

    @Step("Scroll to the footer and read its text")
    public String getFooterText() {
        scrollToBottom();
        return getText(footer);
    }

    @Step("Click the 'OrangeHRM, Inc' footer link and switch to the new tab")
    public String clickFooterLinkAndGetNewTabUrl() {
        String original = driver.getWindowHandle();
        click(footerLink);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles = driver.getWindowHandles();
        for (String h : handles) {
            if (!h.equals(original)) {
                driver.switchTo().window(h);
            }
        }
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("about:blank")));
        String url = driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(original);
        return url;
    }
}
