package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FrameTests extends BaseTests {
    @Test
    public void leftFrameTest(){
        String leftText = homePage.clickNestedFrame().getLeftFrameText();
        assertTrue(leftText.contains("LEFT"),"Incorrect left frame Text");
    }
    @Test
    public void bottomFrameTest(){
        String bottomText = homePage.clickNestedFrame().getBottomFrameText();
        assertTrue(bottomText.contains("BOTTOM"),"Incorrect Bottom frame Text");
    }
}
