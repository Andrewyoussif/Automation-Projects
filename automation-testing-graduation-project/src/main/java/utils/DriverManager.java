package utils;

import utils.ConfigReader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    // One WebDriver per thread so parallel tests don't share a browser
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void initDriver() {
        String browser = ConfigReader.get("browser").toLowerCase();
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));
        WebDriver d;
        switch (browser) {
            case "firefox":
                d = new FirefoxDriver();
                break;
            case "edge":
                d = new EdgeDriver();
                break;
            default:
                ChromeOptions options = new ChromeOptions();
                if (headless) {
                    options.addArguments("--headless=new");
                }
                options.addArguments("--window-size=1920,1080", "--no-sandbox", "--disable-dev-shm-usage");
                d = new ChromeDriver(options);
        }
        if (headless) {
            d.manage().window().setSize(new Dimension(1920, 1080));
        } else {
            d.manage().window().maximize();
        }
        driver.set(d);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
