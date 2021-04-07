package page_objects;

import data_providers.JsonDataReader;
import data_providers.PropReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page_utils.Wait;
import testDataTypes.LoginData;

public class LoginPage {

    WebDriver driver;
    PropReader propReader;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        propReader = new PropReader();
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"txtUsername\"]")
    private WebElement txt_username;

    @FindBy(how=How.XPATH, using="//*[@id=\"txtPassword\"]")
    private WebElement txt_password;

    @FindBy(how=How.XPATH, using="//*[@id=\"btnLogin\"]")
    private WebElement btn_login;


    public void navigate_to_loginPage() {
        //browser.get("http://localhost/orangehrm41/orangehrm-4.1/symfony/web/index.php/auth/login");
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    // we are adding loginData object manually in this example
    public void enter_credentials() {
        LoginData users = FileReaderManager.getInstance().getJsonDataReader().getUserByName("admin");
        txt_username.sendKeys(users.getUsername());
        txt_password.sendKeys(users.getPassword());
    }
    // we are adding loginData object as a parameter in this example
    public void enter_credentials(LoginData user) {
        txt_username.sendKeys(user.getUsername());
        txt_password.sendKeys(user.getPassword());
    }

    public void click_login() {
        btn_login.click();
        Wait.untilJqueryIsDone(driver);
    }

}
