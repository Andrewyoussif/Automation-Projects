package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SelUtils;

public class InputsPage {
    private WebDriver driver;
    private By Header = By.xpath("//h3");

    public InputsPage(WebDriver driver){
        this.driver = driver;
    }
    public String getHeader(){
        return new SelUtils(driver).getMessage(Header);
    }
}
