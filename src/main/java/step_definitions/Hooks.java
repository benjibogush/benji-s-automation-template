package step_definitions;


import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class Hooks {

    TestContext testContext;
    Reporter reporter;

    public Hooks(TestContext context) {

        testContext = context;

    }

    @Before
    public void beforeSteps() {

//         Reporter.assignAuthor("Selenium Cucumber - Yashika Jayasinghe");
         //Reporter.log("Test Started");
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {

        if(scenario.isFailed()){

            try{
                byte[] screenshot = ((TakesScreenshot) testContext.getWebdriver_manager().getDriver()).getScreenshotAs(OutputType.BYTES);
                File screenshot_with_scenario_name = ((TakesScreenshot) testContext.getWebdriver_manager().getDriver()).getScreenshotAs(OutputType.FILE);
                FileHandler.copy(screenshot_with_scenario_name,
                        new File("./target/" + "scenario.getName()" + ".png"));
                System.out.println(scenario.getName());
                scenario.attach(screenshot, "image/png", "snap");
            }

            catch (WebDriverException | IOException somePlatformsDontSupportScreenshots){
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }

        }


//    @After(order = 0)
//    public void tearDown(Scenario scenario) {
//        if (true) {
//            if (scenario.isFailed()) {
//                byte[] screenshot = ((TakesScreenshot) testContext.getWebdriver_manager()).getScreenshotAs(OutputType.BYTES);
//                scenario.embed(screenshot, "image/jpeg", "failure_image");
//
//            }
//
//        }
//    }

    @After(order = 1)
    public void afterSteps() {
        System.out.println("AfterScenario");
      //  testContext.getWebdriver_manager().closeBrowser();
    }

}


