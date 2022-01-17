package qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static String USERNAME = "chinthakawithana_3LOKRD";
    public static String ACCESSKEY = "q6Gi6MoZjtsKsXMQzEoc";
    public static String URL = "https://"+USERNAME+":"+ACCESSKEY+"@hub.browserstack.com/wd/hub";


    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    //This method is used to initialize the ThreadLocal driver on the basis of given browser
    public WebDriver init_driver(String browser) throws MalformedURLException {
        String bro = browser;
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
        } else if (bro.equals("browserstack")) {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "11");
            caps.setCapability("browser", "Edge");
            caps.setCapability("browser_version", "latest");

            URL bsURL = new URL(URL);
            tlDriver.set(new RemoteWebDriver(bsURL,caps));
        }else {
            System.out.println("Please pass the correct browser value : " + bro);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    //This is used to get the driver with ThreadLocal
    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
