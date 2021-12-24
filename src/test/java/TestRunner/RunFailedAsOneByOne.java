package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"@target/rerun-scenarios/failed_scenarios_rerun.txt"},
        glue = {"Steps", "AppHooks"},
        monochrome = false,
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:test_reports/json_report/failed_retun/Test_Automation.json",
                "rerun:target/rerun-scenarios/failed_scenarios_rerun.txt"}
)

public class RunFailedAsOneByOne {
}
