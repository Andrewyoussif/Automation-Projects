package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SelUtils;

public class nestedFramePage {
    private WebDriver driver;
    private By bodyTextLocator = By.cssSelector("body");

    public nestedFramePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getLeftFrameText(){
        new SelUtils(driver).switchToFrameByName("frame-top");
        new SelUtils(driver).switchToFrameByName("frame-left");
        String leftText = driver.findElement(bodyTextLocator).getText();
        new SelUtils(driver).switchToDefaultFrame();
        return leftText;
    }
    public String getBottomFrameText(){
        new SelUtils(driver).switchToFrameByName("frame-bottom");
        String bottomText = driver.findElement(bodyTextLocator).getText();
        new SelUtils(driver).switchToDefaultFrame();
        return bottomText;
    }
}
