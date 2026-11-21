package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SelUtils;
import utils.WindowManager;

public class MultipleWindowsPage {
    private WebDriver driver;

    public MultipleWindowsPage(WebDriver driver){
        this.driver = driver;
    }
    public NewWindowPage clickHereLink(){
        new SelUtils(driver).clickLinkByLinkText("Click Here");
        return new NewWindowPage(driver);
    }
}
