package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SelUtils;

public class FileUploadPage {
    private WebDriver driver;
    private By chooseFileButton = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");
    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }
    public void chooseFile(String text){
        new SelUtils(driver).chooseFile(chooseFileButton,text);

    }
    public void clickUpload( ){
        driver.findElement(uploadButton).click();
    }
    public String getUploadedFiles( ){
        return driver.findElement(uploadedFiles).getText();
    }


}
