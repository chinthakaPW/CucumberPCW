package Steps;

import Pages.ContactUsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import qa.factory.DriverFactory;
import qa.util.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ContactUsSteps {
    private static String title;
    private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

    @Given("user navigates to contact us page")
    public void user_navigates_to_contact_us_page() {
        DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
    }

    @Then("user gets the title of the contact us page")
    public void user_gets_the_title_of_the_contact_us_page() {
        title = contactUsPage.getContactUsPageTitle();
        System.out.println("Page title is : " + title);
    }

    @When("user fills the form from given sheetname {string} and rownumber {int}")
    public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData("data/automation.xlsx", sheetName);

        String heading = testData.get(rowNumber).get("subjectheading");
        String email = testData.get(rowNumber).get("email");
        String orderRef = testData.get(rowNumber).get("orderref");
        String prod = testData.get(rowNumber).get("product");
        String filePath = testData.get(rowNumber).get("filepath");
        String message = testData.get(rowNumber).get("message");

        contactUsPage.fillContactUsForm(heading, email, orderRef, prod, filePath, message);
    }

    @When("user clicks on send button")
    public void user_clicks_on_send_button() {
        contactUsPage.clickSend();
    }

    @Then("it shows a successful message {string}")
    public void it_shows_a_successful_message(String expMsg) {
        Assert.assertEquals(expMsg, contactUsPage.getSuccessMessg());
    }
}
