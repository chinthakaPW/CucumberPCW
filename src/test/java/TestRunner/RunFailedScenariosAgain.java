package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import qa.util.DeleteReportFiles;

@CucumberOptions(
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:test_reports/json_report/failed_rerun/Test_Automation.json",
                "timeline:test_reports/thread_wise_report/failed_rerun",
                "rerun:target/rerun-scenarios/failed_scenarios_rerun.txt"},
        monochrome = false,
        glue = {"Steps", "AppHooks"},
        features = {"@target/rerun-scenarios/failed_scenarios_rerun.txt"}
)

public class RunFailedScenariosAgain extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        //HTML report screenshots clearing
        DeleteReportFiles deleteReportFiles = new DeleteReportFiles();
        deleteReportFiles.deleteAllFilesFromDirectory();

        return super.scenarios();
    }
}
