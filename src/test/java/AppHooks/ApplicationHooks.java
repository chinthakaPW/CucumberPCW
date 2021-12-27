package AppHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import qa.factory.DriverFactory;

import java.util.Properties;

import static java.lang.Thread.sleep;

public class ApplicationHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    Properties prop;

    @Before(value = "@skip_scenario", order = 0)
    public void skip_scenario(Scenario scenario) {
        System.out.println("Skipped scenario is : " + scenario.getName());
        Assume.assumeTrue(false);
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = System.getProperty("systeminfo.browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    @After(order = 0)
    public void quitBrowser() throws InterruptedException {

        driver.close();
        sleep(1000);
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String ssName = scenario.getName().replaceAll("", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", ssName);
        }
    }
}
