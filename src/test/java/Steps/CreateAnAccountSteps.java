package Steps;

import Pages.CreateAnAccountPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import qa.factory.DriverFactory;

public class CreateAnAccountSteps {
    private static String title;
    private CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(DriverFactory.getDriver());

    @Then("register page title should be {string}")
    public void registerPageTitleShouldBe(String expPageTitle) {
        title = createAnAccountPage.getCreateAnAccountPageTitle();
        System.out.println("Page title is : " + title);
        Assert.assertTrue(createAnAccountPage.getCreateAccountPageTitle().contains(expPageTitle));
    }
}
