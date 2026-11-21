package uploadFiles;

import base.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UploadFilesTests extends BaseTests {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void uploadFilesTest(){
        var uploadFile = homePage.clickFileupload();
        String path = "D:\\Testing\\";
        String fileName = "Andrew_Youssif Tester CV.pdf";
        uploadFile.chooseFile(path+fileName);
        uploadFile.clickUpload();
        assertEquals(uploadFile.getUploadedFiles(),fileName,"Incorrect File");
    }
}
