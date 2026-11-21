package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SelUtils;

import java.time.Duration;

public class ex2Page {
    private WebDriver driver;
    private By startButton = By.cssSelector("#start > button");
    private By message = By.cssSelector("#finish> h4");
    public ex2Page(WebDriver driver){
        this.driver = driver;
    }
    public void clickStartButton(){
        new SelUtils(driver).clickButton(startButton);
    }
    public String getEx2Text(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.presenceOfElementLocated(message));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(message)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        return new SelUtils(driver).getMessage(message);
    }
}
