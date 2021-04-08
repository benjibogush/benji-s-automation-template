package page_objects;

import data_providers.PropReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

    WebDriver driver;
    PropReader propReader;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        propReader = new PropReader();
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "menu_recruitment_viewRecruitmentModule")
    private WebElement recruitmentPage;

    @FindBy(how = How.ID, using = "isim")
    private WebElement firstName;


    @FindBy(how = How.ID, using = "btnAdd")
    private WebElement addButton;

   public void  navigate_to_recruitment_page(){
       recruitmentPage.click();
   }

    public void clickAddButton() {
        addButton.click();
    }

    public void enterUserInfo(){firstName.sendKeys("bluh bluh");}
}
