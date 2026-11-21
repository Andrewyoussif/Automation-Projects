package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SelUtils;

public class JavaScriptAlertsPage {
    WebDriver driver;
    private By result = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAlertByText(String text ){
        new SelUtils(driver).clickAlertByText(text);
    }
    public String getAlertText(){
        return new SelUtils(driver).getAlertText();
    }
    public void acceptAlert(){
         new SelUtils(driver).acceptAlert();
    }
    public void dismissAlert(){
         new SelUtils(driver).dismissAlert();
    }
    public void setAlerttext(String text){
         new SelUtils(driver).setAlertText(text);
    }
    public String getResult( ){
         return driver.findElement(result).getText();
    }

}
