package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SelUtils;

public class NewWindowPage {
    private WebDriver driver;
    private By header = By.tagName("h3");
    public NewWindowPage(WebDriver driver){
        this.driver = driver;
    }
    public String getHeaderText(){
        return new SelUtils(driver).getMessage(header);
    }
}
