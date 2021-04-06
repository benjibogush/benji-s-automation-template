package page_objects;

import data_providers.PropReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page_utils.Wait;
import testDataTypes.loginData;

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

    public void enter_credentials(loginData user) {
        txt_username.sendKeys(user.username);
        txt_password.sendKeys(user.password);
    }

    public void click_login() {
        btn_login.click();
        Wait.untilJqueryIsDone(driver);
    }

}
