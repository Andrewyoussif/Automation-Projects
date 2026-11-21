package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.SelUtils;

public class LargeAndDeepDOMPage {
    private WebDriver driver;
    private By tableLocator = By.id("large-table");
    private By headerTableLocator = By.xpath("//td[@class='column-30'][contains(.,'20.30')]");
    public LargeAndDeepDOMPage(WebDriver driver){
        this.driver = driver;
    }

    public void moveToTableByJsExecuter(){
        new SelUtils(driver).scrollToObject(tableLocator);

    }

    public void moveToTableByActionsClass(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(headerTableLocator)).perform();

    }
}
