package step_definitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import page_objects.LoginPage;
import page_objects.RecruitmentPage;

public class RecruitmentSteps {

    TestContext testContext;
    RecruitmentPage recruitmentPage;


    public RecruitmentSteps(TestContext Context) {
        testContext = Context;
        recruitmentPage = testContext.getPageObjectManager().getRecruitmentPage();
    }

    @Given("admin navigates to recruitment page")
    public void admin_navigates_to_recruitment_page() {
        recruitmentPage.navigate_to_recruitment_page();
    }

    @And("click to add a {string}")
    public void click_to_add_a(String user) {
        recruitmentPage.clickAddButton();
    }

    @Then("user logs off")
    public void user_logs_off() {
        recruitmentPage.enterUserInfo();
      // testContext.getWebdriver_manager().getDriver().quit();
    }

}
