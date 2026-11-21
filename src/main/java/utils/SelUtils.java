package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelUtils {
    private WebDriver driver;
    public SelUtils(WebDriver driver){
        this.driver = driver;
    }
    public void clickAlertByText(String text ){
        driver.findElement(By.xpath("//button[text()='"+text+"']")).click();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public void setAlertText(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public void chooseFile(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
    public void clickLinkByLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    public Select getDropDown(By Locator){
        return new Select(driver.findElement(Locator));
    }
    public String getMessage(By locator){
        return driver.findElement(locator).getText();
    }
    public void chooseFromDropDownByVisibleText(By locator , String option){
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(option);
    }
    public void setText(By locator , String text){
        driver.findElement(locator).sendKeys(text);
    }
    public void switchToFrameByName(String frameName){
        driver.switchTo().frame(frameName);
    }
    public void switchToDefaultFrame(){
        driver.switchTo().defaultContent();
    }
    public void clickButton(By locator){
        driver.findElement(locator).click();
    }
    public void scrollToObject(By Locator){
        var js = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(Locator);
        String script = "arguments[0].scrollIntoView();";
        js.executeScript(script,element);
    }
}
