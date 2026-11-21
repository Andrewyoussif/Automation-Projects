package pages;

import org.openqa.selenium.WebDriver;
import utils.SelUtils;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        new SelUtils(driver).clickLinkByLinkText("Form Authentication");
        return new LoginPage(driver);
    }

    public InputsPage clickInputsLink(){
        new SelUtils(driver).clickLinkByLinkText("Inputs");
        return new InputsPage(driver);
    }
    public DropDownPage clickDropDown(){
        new SelUtils(driver).clickLinkByLinkText("Dropdown");
        return new DropDownPage(driver);
    }
    public HoversPage clickHovers(){
         new SelUtils(driver).clickLinkByLinkText("Hovers");
         return new HoversPage(driver);
    }
    public KeyPressesPage clickKeyPresses(){
        new SelUtils(driver).clickLinkByLinkText("Key Presses");
        return new KeyPressesPage(driver);
    }
    public JavaScriptAlertsPage clickJavaScriptAlerts(){
        new SelUtils(driver).clickLinkByLinkText("JavaScript Alerts");
        return new JavaScriptAlertsPage(driver);
    }
    public FileUploadPage clickFileupload(){
        new SelUtils(driver).clickLinkByLinkText("File Upload");
        return new FileUploadPage(driver);
    }
    public EntryAdPage clickEntryAd(){
        new SelUtils(driver).clickLinkByLinkText("Entry Ad");
        return new EntryAdPage(driver);
    }
    public nestedFramePage clickNestedFrame(){
        new SelUtils(driver).clickLinkByLinkText("Nested Frames");
        return new nestedFramePage(driver);
    }
    public DynamicLoadingPage clickDynamicLoading(){
        new SelUtils(driver).clickLinkByLinkText("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }
    public LargeAndDeepDOMPage clickLargeAndDeepDOM(){
        new SelUtils(driver).clickLinkByLinkText("Large & Deep DOM");
        return new LargeAndDeepDOMPage(driver);
    }
    public MultipleWindowsPage clickMultipleWindows(){
        new SelUtils(driver).clickLinkByLinkText("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }
}
