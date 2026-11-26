package entryAd;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EntryAdTests extends BaseTests {
    @Test
    public void getHeaderTest(){
        var modal = homePage.clickEntryAd();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        modal.clickClose();
        assertEquals(modal.getHeader(),"Entry Ad","Header is Incorrect");
    }
}
