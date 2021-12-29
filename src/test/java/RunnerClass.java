


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"steps"},
        features = {"src/test/resources/FeatureFiles"},
        tags = {"@smoke"},
        junit = "--step-notifications"
)
public class RunnerClass {
}


