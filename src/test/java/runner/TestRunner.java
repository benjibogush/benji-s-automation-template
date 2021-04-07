package runner;


import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import managers.FileReaderManager;

import org.testng.annotations.AfterClass;

import java.io.File;


@CucumberOptions(
       // features = "src/main/resources/feature_files/Feature1_login.feature",
        features = "src/main/resources/feature_files",
        glue = {"step_definitions"},
        plugin = {"pretty", "json:target/cucumber.json",}    //html:target/cucumber-html-reports
        ,tags = {"@AddUser"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void writeExpentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigFileReader().getReportConfigPath()));
    }
}
