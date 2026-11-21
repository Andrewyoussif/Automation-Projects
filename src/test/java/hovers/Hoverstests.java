package hovers;

import base.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Hoverstests extends BaseTests {
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void Hoverstests(){
        int index = 1;
        var hoverPage= homePage.clickHovers();
        var fig = hoverPage.hoverOverFig(index);
        assertTrue(fig.getFigName().contains("user"+index),"The name is incorrect");
        assertTrue(fig.isCaptionDisplayed(),"The fig isn't displayed");
        assertTrue(fig.getLinkText().contains("View profile"),"The Text is incorrect");
        assertTrue(fig.getLinkURL().contains("users/"+index),"The URL is incorrect");

    }
}
