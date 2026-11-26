package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private WebDriver driver;
    private By figBox = By.className("figure");
    private By figCaption = By.className("figcaption");

    public HoversPage(WebDriver driver){
        this.driver = driver;
    }
    public Figure hoverOverFig(int index){
        Actions actions = new Actions(driver);
        WebElement figure = driver.findElements(figBox).get(index-1);
        actions.moveToElement(figure).perform();
        return new Figure(figure.findElement(figCaption));
    }
    public class Figure{
        private WebElement caption;
        private By name = By.tagName("h5");
        private By link = By.tagName("a");

        public Figure(WebElement caption){
            this.caption = caption;
        }
        public Boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }
        public String getFigName(){
            return caption.findElement(name).getText();
        }
        public String getLinkText(){
            return caption.findElement(link).getText();
        }
        public String getLinkURL(){
            return caption.findElement(link).getAttribute("href");
        }

    }
}
