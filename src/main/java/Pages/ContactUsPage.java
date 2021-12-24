package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ContactUsPage {
    private WebDriver driver;
    private Select select;

    //1. By Locators:
    private By subjectHeading = By.name("id_contact");
    private By email = By.id("email");
    private By orderRef = By.name("id_order");
    private By product = By.id("313603_order_products");
    private By uploadFile = By.id("fileUpload");
    private By messageText = By.id("message");
    private By sendButton = By.id("submitMessage");
    private By successMessg = By.xpath("//*[@id=\"center_column\"]/p");

    //2. Constructor of the page class:
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page Actions: features(behavior) of the page the form of methods:
    public String getContactUsPageTitle() {
        return driver.getTitle();
    }

    public void fillContactUsForm(String heading, String emailId, String orderReference, String prod, String filePath, String message) {
        File file = new File(filePath);

        Select selectHeading = new Select(driver.findElement(subjectHeading));
        selectHeading.selectByVisibleText(heading);
        driver.findElement(email).sendKeys(emailId);
        driver.findElement(uploadFile).sendKeys(file.getAbsolutePath());
        driver.findElement(messageText).sendKeys(message);
    }

    public void clickSend() {
        driver.findElement(sendButton).click();
    }

    public String getSuccessMessg() {
        return driver.findElement(successMessg).getText();
    }
}
