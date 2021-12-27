package Steps;

import Pages.AccountsPage;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import qa.factory.DriverFactory;

import java.util.List;
import java.util.Map;

public class AccountsPageSteps {
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    AccountsPage accountsPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credTable) {
        List<Map<String, String>> credList = credTable.asMaps();
        String uName = credList.get(0).get("username");
        String pass = credList.get(0).get("password");

        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountsPage = loginPage.doLogin(uName, pass);
    }

    @Given("user is on account page")
    public void user_is_on_account_page() {
        accountsPage.getAccountsPageTitle();
    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable) {
        List<String> expAccountsSectionsList = sectionsTable.asList();
        System.out.println("Expected account sections list : " + expAccountsSectionsList);

        List<String> actualSectionsList = accountsPage.getAccountsSectionList();
        System.out.println("Actual account sections list : " + actualSectionsList);

        Assert.assertTrue(expAccountsSectionsList.containsAll(actualSectionsList));
    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expSectionCount) {
        Assert.assertTrue(accountsPage.getAccountsSectionCount() == expSectionCount);
    }
}
