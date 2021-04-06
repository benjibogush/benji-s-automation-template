package cucumber;

import managers.PageObjectManager;
import managers.WebDriver_Manager;

public class TestContext {
	private PageObjectManager pageObjectManager;
	private WebDriver_Manager webdriver_manager;
	public ScenarioContext scenarioContext;

	public TestContext() {
		webdriver_manager = new WebDriver_Manager();
		pageObjectManager = new PageObjectManager(webdriver_manager.getDriver());
		scenarioContext = new ScenarioContext();
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}



	public WebDriver_Manager getWebdriver_manager() {
		return webdriver_manager;
	}



	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}



}
