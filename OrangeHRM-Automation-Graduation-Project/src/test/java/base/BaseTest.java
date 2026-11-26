package base;

import utils.ConfigReader;
import utils.DriverManager;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class BaseTest {
    protected final Logger log = LogManager.getLogger(getClass());

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.initDriver();
        DriverManager.getDriver().get(ConfigReader.get("base.url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE && DriverManager.getDriver() != null) {
            log.error("Test failed: {} - {}", result.getName(), result.getThrowable());
            byte[] png = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot on failure", new ByteArrayInputStream(png));
        } else {
            log.info("Finished test: {} (status {})", result.getName(), result.getStatus());
        }
        DriverManager.quitDriver();
    }
}
