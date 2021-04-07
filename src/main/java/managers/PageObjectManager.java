package managers;

import org.openqa.selenium.WebDriver;
import page_objects.AddEmployeePage;
import page_objects.EmployeeListPage;
import page_objects.LoginPage;
import page_objects.RecruitmentPage;


public class PageObjectManager {

	private final WebDriver driver;
	private LoginPage loginPage;
	private AddEmployeePage empPage;
	private EmployeeListPage empListPage;
	private RecruitmentPage recruitmentPage;
	//private Xpage xpage;


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

	public RecruitmentPage getRecruitmentPage(){
		return (recruitmentPage == null) ? recruitmentPage = new RecruitmentPage(driver) : recruitmentPage;
	}

//	public XPage getXPage(){
//		return (xpage == null) ? xpage = new XPage(driver) : xpage;
//	}



}
