package qa.util;

import java.io.File;

public class DeleteReportFiles {
    public void deleteAllFilesFromDirectory(String delDirectory) {
        String directory = delDirectory;

        File folder = new File(directory);
        File fList[] = folder.listFiles();

        for (File f : fList) {
            if (f.getName().endsWith(".png")) {
                f.delete();
            } else if (f.getName().endsWith(".html")) {
                f.delete();
            } else if (f.getName().endsWith(".zip")) {
                f.delete();
            }
        }
    }
}
