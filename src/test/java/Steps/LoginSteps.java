package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import qa.factory.DriverFactory;

public class LoginSteps {
    private static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginPage.getLoginPageTitle();
        System.out.println("Page title is : " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(loginPage.isForgotPassLinkExist());
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUserName(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String pass) {
        loginPage.enterPassword(pass);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLogin();
    }

    @Then("it should display invalid message {string}")
    public void itShouldDisplayInvalidMessage(String expCredReqMsg) {
        Assert.assertTrue(loginPage.getCredentialRequiredMessage().contains(expCredReqMsg));
    }

    @And("user click on create an account button")
    public void userClickOnCreateAnAccountButton() {
        loginPage.clickOnRegButton();
    }

    @Then("it should display invalid email message {string}")
    public void itShouldDisplayInvalidEmailMessage(String invalidEmailMsg) {
        Assert.assertTrue(loginPage.getEmailRequiredMessage().contains(invalidEmailMsg));
    }

    @When("user enters email address {string}")
    public void userEntersEmailAddress(String emailAdd) {
        loginPage.enterRegEmail(emailAdd);
    }
}
