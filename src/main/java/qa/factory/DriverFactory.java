package qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    //This method is used to initialize the ThreadLocal driver on the basis of given browser
    public WebDriver init_driver(String browser) {
        String bro = System.getProperty("systeminfo.browser");
        System.out.println("Browser value is : " + bro);

        if (bro.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (bro.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (bro.equals("safari")) {
            WebDriverManager.safaridriver().setup();
            tlDriver.set(new SafariDriver());
        } else {
            System.out.println("Please pass the correct browser value : " + bro);
        }

        getDriver().manage().deleteAllCookies();
        //getDriver().manage().window().maximize();
        return getDriver();
    }

    //This is used to get the driver with ThreadLocal
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
