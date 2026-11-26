package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private By ex1Link = By.partialLinkText("Example 1");
    private By ex2Link = By.partialLinkText("Example 2");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }
    public ex1Page clickEx1(){
        driver.findElement(ex1Link).click();
        return new ex1Page(driver);
    }
    public ex2Page clickEx2(){
        driver.findElement(ex2Link).click();
        return new ex2Page(driver);
    }
}
