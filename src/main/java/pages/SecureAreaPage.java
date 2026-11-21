package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    private By alertMessage = By.id("flash");

    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }
    public String getAlertMessage(){
        String message =  driver.findElement(alertMessage).getText();
        return message;
    }

}
