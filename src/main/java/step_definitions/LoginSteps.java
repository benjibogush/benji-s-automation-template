package step_definitions;


import cucumber.TestContext;
import io.cucumber.java.en.Given;
import managers.FileReaderManager;
import page_objects.LoginPage;
import testDataTypes.loginData;


public class LoginSteps {

    TestContext testContext;
    LoginPage loginPage;

    public LoginSteps(TestContext Context) {

        testContext = Context;
        loginPage = testContext.getPageObjectManager().getLoginPage(); // initialize loginPage object using the manager
    }



    @Given("the Admin <{string}> is in login Page")
    public void theAdminIsInLoginPage(String arg0) {
        loginPage.navigate_to_loginPage();
        loginData users = FileReaderManager.getInstance().getJsonDataReader().getUserByName(arg0);
        loginPage.enter_credentials(users);
        loginPage.click_login();
        System.out.println(arg0);

    }

    @Given("user can navigate to password reset module")
    public void userCanNavigateToPasswordResetModule() {
        System.out.println(testContext.getWebdriver_manager().getDriver().getTitle());
    }
}
