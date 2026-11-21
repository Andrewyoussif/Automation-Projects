package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SelUtils;

public class KeyPressesPage {
    private WebDriver driver;
    private By inputField = By.id("target");
    private By message = By.id("result");
    public KeyPressesPage(WebDriver driver){
        this.driver = driver;
    }
    public void setText(String text){
        new SelUtils(driver).setText(inputField,text);
    }
    public String getMessage(){
        return new SelUtils(driver).getMessage(message);
    }
}
