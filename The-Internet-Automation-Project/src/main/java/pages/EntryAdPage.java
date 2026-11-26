package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SelUtils;

public class EntryAdPage {
    private WebDriver driver;
    private By closeLocator = By.cssSelector(".modal-footer p");
    private By headerLocator = By.cssSelector(".example h3");

    public EntryAdPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickClose(){
        driver.findElement(closeLocator).click();
    }
    public String getHeader(){
        return new SelUtils(driver).getMessage(headerLocator);
    }
}
