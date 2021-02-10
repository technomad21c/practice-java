//https://www.journaldev.com/845/java-filenamefilter-example

package com.journaldev.files;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilterExample {
    public static void main(String[] args) {
        String dir = "src/com/journaldev/files";
        String ext =  ".txt";
        findFiles(dir, ext);
    }

    private static void findFiles(String dir, String ext) {
        File file = new File(dir);

        if (!file.exists()) {
            System.out.println(dir + "Directory doesn't exists");
        }
//        File[] listFiles = file.listFiles(new MyFileNameFilter(ext));

        File[] listFiles = file.listFiles((d, name) -> {
           return name.toLowerCase().endsWith(ext);
        });

        if (listFiles.length == 0) {
            System.out.println(dir + "doesn't have any file with extension " + ext);
        } else {
            for (File f : listFiles) {
                System.out.println("File: " + dir + File.separator + f.getName());
            }
        }
    }

    public static class MyFileNameFilter implements FilenameFilter {
        private String extension;

        public MyFileNameFilter(String extension) {
            this.extension = extension.toLowerCase();
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(extension);
        }
    }
}
