package js;

import base.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class JsExecuterTests extends BaseTests {
   @Test
   @Severity(SeverityLevel.CRITICAL)
   public void scrollToTableTestByJsExecuter(){
       var table = homePage.clickLargeAndDeepDOM();
       table.moveToTableByJsExecuter();

   }
   @Test
   @Severity(SeverityLevel.CRITICAL)
   public void scrollToTableTestByActionsClass(){
       var table = homePage.clickLargeAndDeepDOM();
       table.moveToTableByActionsClass();

   }
}
