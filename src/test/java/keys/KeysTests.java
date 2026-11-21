package keys;

import base.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KeysTests extends BaseTests {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void messageTextTest(){
        var keypage= homePage.clickKeyPresses();
        keypage.setText("a");
        assertEquals(keypage.getMessage(),"You entered: A"
                ,"incorrect message");
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void capitalTextTest(){
        var keypage= homePage.clickKeyPresses();
        keypage.setText(Keys.chord(Keys.SHIFT,"q"));
        assertEquals(keypage.getMessage(),"You entered: Q"
                ,"incorrect message");
    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void deleteTextTest(){
        var keypage= homePage.clickKeyPresses();
        keypage.setText("a"+Keys.BACK_SPACE);
        assertEquals(keypage.getMessage(),"You entered: BACK_SPACE"
                ,"incorrect message");
    }

}
