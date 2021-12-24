package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccountPage {
    private WebDriver driver;

    //1. By Locators:
    private By pageTitle = By.id("noSlide");

    //2. Constructor of the page class:
    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page Actions: features(behavior) of the page the form of methods:
    public String getCreateAnAccountPageTitle() {
        return driver.getTitle();
    }

    public String getCreateAccountPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).getText();
    }
}
