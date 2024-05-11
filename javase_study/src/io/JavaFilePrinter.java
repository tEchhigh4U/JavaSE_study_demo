package io;

import java.io.File;

public class JavaFilePrinter {
    public static void main(String[] args) {
        String directoryPath = "/Users/Williamhui/Code/self-learn/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo";
        File startDirectory = new File(directoryPath);

        System.out.println("Listing all Java files in " + directoryPath);
        listJavaFiles(startDirectory);
    }

    private static void listJavaFiles(File startDirectory) {
        // 獲取目錄下的所有文件和子目錄
        File[] files = startDirectory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listJavaFiles(file);
                } else {
                    if (file.getName().endsWith(".java")) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
