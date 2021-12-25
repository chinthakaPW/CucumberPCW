package qa.util;

import java.io.File;

public class DeleteReportFiles {
    public void deleteAllFilesFromDirectory() {
        String directory = "test_reports/html_report";

        File folder = new File(directory);
        File fList[] = folder.listFiles();

        for (File f : fList) {
            if (f.getName().endsWith(".png")) {
                f.delete();
            }
        }
    }
}
