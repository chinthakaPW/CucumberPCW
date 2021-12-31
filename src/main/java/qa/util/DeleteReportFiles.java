package qa.util;

import java.io.File;

public class DeleteReportFiles {
    public void deleteAllFilesFromDirectory(String delDirectory,String fileType) {
        String directory = delDirectory;

        File folder = new File(directory);
        File fList[] = folder.listFiles();

        for (File f : fList) {
            if (f.getName().endsWith(fileType)) {
                f.delete();
            }
        }
    }
}
