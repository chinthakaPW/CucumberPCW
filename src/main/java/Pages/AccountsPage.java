package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {
    private WebDriver driver;

    //1. By Locators:
    private By accountSections = By.cssSelector("div#center_column span");

    //2. Constructor of the page class:
    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")));
    }

    //3. Page Actions: features(behavior) of the page the form of methods:
    public int getAccountsSectionCount() {
        return driver.findElements(accountSections).size();
    }

    public String getAccountsPageTitle() {
        return driver.getTitle();
    }

    public List<String> getAccountsSectionList() {
        List<String> accountList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements(accountSections);

        for (WebElement e : accountsHeaderList) {
            String text = e.getText();
            System.out.println(text);
            accountList.add(text);
        }

        return accountList;
    }
}
