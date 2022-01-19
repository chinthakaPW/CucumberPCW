package AppHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.factory.DriverFactory;
import qa.util.ConfigReader;

import java.net.MalformedURLException;
import java.util.Properties;

public class ApplicationHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(value = "@skip_scenario", order = 0)
    public void skip_scenario(Scenario scenario) {
        System.out.println("Skipped scenario is : " + scenario.getName());
        Assume.assumeTrue(false);
    }

    @Before(order = 1)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 2)
    public void launchBrowser() throws MalformedURLException {
        String bsUrl = "https://" + prop.getProperty("browser_stack_username") + ":" + prop.getProperty("browser_stack_accesskey") + "@hub.browserstack.com/wd/hub";
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName, bsUrl);
    }

    @After(order = 0)
    public void quitBrowser() {
        this.driver.close();
        this.driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String ssName = scenario.getName().replaceAll("", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", ssName);
        }
    }

    @DataProvider(name = "browserStackTestData")
    public Object[][] getData() {
        Object[][] testData = new Object[][]{
                {Platform.MAC, "chrome", "62.0"}
        };
        return testData;
    }
}
