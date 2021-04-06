package step_definitions;




import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import managers.WebDriver_Manager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

        if(scenario.isFailed())
        {
            String screenshotName = scenario.getName().replaceAll("", "_");
            try {

                File sourcePath = ((TakesScreenshot) testContext.getWebdriver_manager().getDriver()).getScreenshotAs(OutputType.FILE);

                File destinationPath = new File(System.getProperty("user.dir")+"/target/cucumber-reports/screenshots/"+screenshotName+".png");

                Files.copy(sourcePath.toPath(), Path.of(destinationPath.getAbsolutePath()));


                //Reporter.addScreenCaptureFromPath(destinationPath.toString());
                Reporter.getExtentHtmlReport();

            }catch(IOException e) {

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


