package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //1. By Locators:
    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPassLink = By.xpath("//*[@id=\"login_form\"]/div/p[1]/a");
    private By credReq = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");

    private By regButton = By.id("SubmitCreate");
    private By invalidEmail = By.xpath("//*[@id=\"create_account_error\"]/ol/li");
    private By regEmailAdd = By.id("email_create");

    //2. Constructor of the page class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page Actions: features(behavior) of the page the form of methods:
    public String getLoginPageTitle() {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.titleContains("My account - My Store"));
        return driver.getTitle();
    }

    public String getCredentialRequiredMessage() {
        return driver.findElement(credReq).getText();
    }

    public boolean isForgotPassLinkExist() {
        return driver.findElement(forgotPassLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }

    public void clickOnRegButton() {
        driver.findElement(regButton).click();
    }

    public String getEmailRequiredMessage() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidEmail));
        return driver.findElement(invalidEmail).getText();
    }

    public void enterRegEmail(String regEmail) {
        driver.findElement(regEmailAdd).sendKeys(regEmail);
    }

    //Hybrid method
    public AccountsPage doLogin(String un, String ps) {
        driver.findElement(emailId).sendKeys(un);
        driver.findElement(password).sendKeys(ps);
        driver.findElement(signInButton).click();
        return new AccountsPage(driver);
    }
}
