package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import qa.util.DeleteReportFiles;
import qa.util.ZipUtils;

import java.io.IOException;

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
        return super.scenarios();
    }

    @BeforeClass
    public void beforeTestStart() {
        ZipUtils zipUtils = new ZipUtils();
        zipUtils.zipDirectory("test_reports/zip");

        DeleteReportFiles deleteReportFiles = new DeleteReportFiles();
        deleteReportFiles.deleteAllFilesFromDirectory("test_reports/html_report", ".html");
        deleteReportFiles.deleteAllFilesFromDirectory("test_reports/html_report", ".png");
        deleteReportFiles.deleteAllFilesFromDirectory("test_reports/zip", ".zip");
    }

    @AfterSuite
    public void zippingTheFolder() throws IOException {
        ZipUtils zipUtils = new ZipUtils();
        zipUtils.zipTheFile("test_reports/html_report/", "test_reports/zip/HTML_Report.zip");
    }
}
