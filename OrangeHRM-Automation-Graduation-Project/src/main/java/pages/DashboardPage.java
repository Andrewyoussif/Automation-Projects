package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends BasePage {
    private final By header = By.cssSelector(".oxd-topbar-header-breadcrumb-module");
    private final By menuItems = By.cssSelector(".oxd-main-menu-item--name");

    @Step("Read the page header")
    public String getHeaderText() {
        return getText(header);
    }

    @Step("Read the sidebar menu items")
    public List<String> getSidebarItems() {
        List<String> names = new ArrayList<>();
        for (WebElement e : waitAll(menuItems)) {
            names.add(e.getText().trim());
        }
        return names;
    }

    @Step("Open sidebar menu '{0}'")
    public void openMenu(String name) {
        click(By.xpath("//span[contains(@class,'oxd-main-menu-item--name') and normalize-space()='" + name + "']"));
    }
}
