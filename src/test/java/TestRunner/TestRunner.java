package TestRunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;
import qa.util.DeleteReportFiles;

@CucumberOptions(
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:test_reports/json_report/Test_Automation.json",
                "timeline:test_reports/thread_wise_report",
                "rerun:target/rerun-scenarios/failed_scenarios_rerun.txt"},
        monochrome = false,
        glue = {"Steps", "AppHooks"},
        features = {"src/test/resources/Features"}
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

        //HTML report screenshots clearing
        DeleteReportFiles deleteReportFiles = new DeleteReportFiles();
        deleteReportFiles.deleteAllFilesFromDirectory();

        return super.scenarios();
    }
}
