package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.SelUtils;

import java.util.ArrayList;
import java.util.List;

public class DropDownPage {
    private WebDriver driver;
    private By dropDownLocator = By.id("dropdown");

    public DropDownPage(WebDriver driver) {
        this.driver = driver;

    }
//    public void chooseFromDropDown(){
//        Select select = new Select(driver.findElement(dropDownLocator));
//        select.selectByVisibleText("Option 1");
//    }

    public void chooseFromDropDown(String option) {
       new SelUtils(driver).chooseFromDropDownByVisibleText(dropDownLocator, option);


    }
    public List<String> getOptionFromDropDown(){
        Select dropdown = new SelUtils(driver).getDropDown(dropDownLocator);
        List<WebElement> selectedElements = dropdown.getAllSelectedOptions();
        List<String> selectedoptions = new ArrayList<>();
        for (WebElement option : selectedElements) {
            selectedoptions.add(option.getText());
        }
        return selectedoptions;
    }
//    public Select getDropDown(By Locator){
//        return new Select(driver.findElement(Locator));
//    }
}
