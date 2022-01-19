package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccountsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //1. By Locators:
    private By accountSections = By.cssSelector("div#center_column span");
    private By grabAccountSection = By.xpath("//*[@id=\"center_column\"]/div");

    //2. Constructor of the page class:
    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. Page Actions: features(behavior) of the page the form of methods:
    public int getAccountsSectionCount() {
        return driver.findElements(accountSections).size();
    }

    public String getAccountsPageTitle() {
        wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.titleContains("My account - My Store"));
        return driver.getTitle();
    }

    public List<String> getAccountsSectionList() {
        List<String> accountList = new ArrayList<>();
        wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.titleContains("My account - My Store"));
        List<WebElement> accountsHeaderList = driver.findElements(accountSections);
//.visibilityOfElementLocated(grabAccountSection)
        for (WebElement e : accountsHeaderList) {
            String text = e.getText();
            System.out.println(text);
            accountList.add(text);
        }

        return accountList;
    }
}
