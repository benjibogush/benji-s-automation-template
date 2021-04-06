package managers;

import org.openqa.selenium.WebDriver;
import page_objects.AddEmployeePage;
import page_objects.EmployeeListPage;
import page_objects.LoginPage;


public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginPage;
	private AddEmployeePage empPage;
	private EmployeeListPage empListPage;



	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public LoginPage getLoginPage()
	{
		return (loginPage == null)? loginPage = new LoginPage(driver):loginPage;
	}

	public AddEmployeePage getAddEmployeePage() {
		return (empPage == null)? empPage = new AddEmployeePage(driver): empPage;
	}

	public EmployeeListPage getEmployeeListPage() {
		return (empListPage == null)? empListPage = new EmployeeListPage(driver): empListPage;
	}



}
