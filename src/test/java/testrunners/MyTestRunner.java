package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/parallel/LoginPage.feature"},
        glue = {"parallel", "AppHooks"},
        plugin = {"pretty",
                "html:target/MyReports/cucumber-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"


        }

)

public class MyTestRunner {

}
