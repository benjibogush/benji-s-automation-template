package managers;


import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriver_Manager {

	private static WebDriver driver;
	private static DriverType browserName;
	private static EnvironmentType environmentName;
	private static final String CHROME_DRIVER_PROPERTY ="webdriver.chrome.driver";


	public WebDriver_Manager() {
		environmentName = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
		browserName = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
	}

	public WebDriver getDriver(){
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {

		switch(environmentName) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;

			}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("Creating Remote driver is not yet implemented");
	}

	private WebDriver createLocalDriver() {

		switch(browserName) {
		case FIREFOX :
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case CHROME :
			//System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;


		}

		if(FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize()) driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitWait(), TimeUnit.SECONDS);
		return driver;
	}

	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
