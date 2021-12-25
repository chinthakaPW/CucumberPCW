package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import qa.util.DeleteReportFiles;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"Steps", "AppHooks"},
        monochrome = false,
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:test_reports/json_report/Test_Automation.json",
                "rerun:target/rerun-scenarios/failed_scenarios_rerun.txt"}
)

public class OneByOneRunner {

    //HTML report screenshots clearing
    //DeleteReportFiles deleteReportFiles = new DeleteReportFiles();
        //deleteReportFiles.deleteAllFilesFromDirectory();
}
