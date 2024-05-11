package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileDemo {
    public static void main(String[] args) {
        File f = new File("/Users/Williamhui/Code/self-learn/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test.txt");
        File f2 = new File("/Users/Williamhui/Code/self-learn/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test2.txt");
        try {
            if (f2.exists()) {
                f2.createNewFile();
                System.out.println("f2 file path: " + f2.getAbsoluteFile());
                System.out.println("f2 absolute path: " + f2.getAbsolutePath());

                System.out.println("f2 exists: " + f2.exists());

                // 獲取文件所在的目錄
                System.out.println("f2 name: " + f2.getName()); // need to know
                System.out.println("f2 parent file: " + f2.getParent()); // need to know
                System.out.println("f2 isAbsolute: " + f2.isAbsolute());
                System.out.println("f2 isDirectory: " + f2.isDirectory()); // 判斷路徑是否是一個目錄

                // 獲取當前目錄下的所在目錄及文件名稱
                System.out.println(Arrays.toString(f2.getParentFile().list()));
                System.out.println(Arrays.toString(f2.getParentFile().list(new FilenameFilter() {

                    @Override
                    public boolean accept(File dir, String name) {
                        return false;
                    }
                })));
                // 如果接口只有一個方法，或者有多個方法，但只需要重寫一個方法，就可以使用lambda寫法
                System.out.println(Arrays.toString(f2.getParentFile().list((dir, name) -> {
                    return name.endsWith(".java");
                })));
                System.out.println(Arrays.toString(f2.getParentFile().listFiles()));
            } else {
//                f2.delete();
                System.out.println("f2 file exists!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        File f3 = new File("/Users/Williamhui/Code/self-learn/Software Testing Complete Course_paid course/1/2/3");
        f3.mkdirs(); // create multiple layers of directories
//        f3.mkdir(); // create single layer of directory
        f3.renameTo(new File("/Users/Williamhui/Code/self-learn/Software Testing Complete Course_paid course/testing"));

        // 將software testing complete course file中所有的。java文件名稱打印出來，需要使用遞歸來


    }
}
