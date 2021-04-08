package page_objects;

import data_providers.PropReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static page_utils.BrowserUtils.clickOn;
import static page_utils.BrowserUtils.getTextValue;

public class HomePage {

    WebDriver driver;
    PropReader propReader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        propReader = new PropReader();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[contains(text(),'Welcome Admin')]")
    public WebElement admin;
    @FindBy(xpath = "//h2")
    public WebElement header;

    public String UserType() {
        return getTextValue(driver, admin, 10);
    }

    public HomePage hoverToElement(String hoverText) {
        WebElement element = driver.findElement(By.xpath("//a[contains(@class,'l2_link parent') or contains(@class,'l1_link')]/span[text()='" + hoverText + "']/.."));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        return this;
    }

    public HomePage hoverAndClickToElement(String hoverText) {
        WebElement element = driver.findElement(By.xpath(" //span[text()='" + hoverText + "']/.."));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).click().perform();
        return this;
    }

    public List<WebElement> iframeFieldInfo() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame(0);
        List<WebElement> elements = driver.findElements(By.xpath("//*[@type='text' or @type='button' or @class='drpDown']"));

        return elements;
    }

    public HomePage validateGeneralInfoFields() {
        for (WebElement el : iframeFieldInfo()) {
            if (el.isEnabled()) {
                System.out.println("failed");
            } else {
                System.out.println("pass");
            }
        }
        driver.switchTo().parentFrame();
        return this;
    }

    public String getIframeFieldType(String fieldName) {
        String result = "not found";
        for (WebElement el : iframeFieldInfo()) {
            if (el.getAttribute("name").contains(fieldName) ||el.getAttribute("id").contains(fieldName) ) {

                if (!el.isEnabled()) {
                    result = "disabled";
                }
                else{
                    result="enabled";
                }
            }
        }
        driver.switchTo().parentFrame();
        return result;
    }

    public HomePage clickButton(String button){
        driver.switchTo().frame(0);
        WebElement element=driver.findElement(By.xpath("//input[@value='"+button+"']"));
        clickOn(driver,element,5);
        driver.switchTo().parentFrame();
        return this;
    }

    public String getHeaderText(){
        driver.switchTo().frame(0);
        String text= getTextValue(driver,header,10);
        driver.switchTo().parentFrame();
        return text;
    }

}
