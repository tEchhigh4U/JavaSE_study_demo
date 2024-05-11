package io;

import java.io.*;

public class FileReaderOrWriter {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        readFile();
//        writeFile();
//        copy("/Users/Williamhui/Code/Self Learn Materials/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test.txt","/Users/Williamhui/Code/Self Learn Materials/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test3.txt");
//        copyWithBuffer();
//        oos();
//        ois();
        fileReader();
    }

    public static void readFile() throws IOException {
        File f = new File("/Users/Williamhui/Code/self-learn/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test.txt");
        FileInputStream fis = new FileInputStream(f);
        byte[] b = new byte[15];
//        fis.read(b,0,11);
//        System.out.println(new String(b)); // String
//        int length = fis.read(b); // 返回實際讀取的內容的長度
////        System.out.println(Arrays.toString(b)); //Arrays
//        System.out.println(new String(b, 0, length)); // String

        int length;
        while ((length = fis.read(b)) != -1) {
            System.out.println(new String(b, 0, length));
        }

//        int length = fis.read(b);
//        while (length != -1) {
//            System.out.println(new String(b, 0, length));
//        }

        fis.close();
    }

    public static void writeFile() throws IOException {
        File f = new File("/Users/Williamhui/Code/self-learn/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test2.txt");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write("你好，這是FileOutputStream寫入的內容!!!!No worries, you can write it into the text.".getBytes());
        fos.close();
    }

    public static void copy(String srcPath, String descPath) throws IOException {
        long t1 = System.currentTimeMillis();
//        File src = new File("/Users/Williamhui/Code/self-learn/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test.txt");
        File src = new File(srcPath);
//        File des = new File("/Users/Williamhui/Code/self-learn/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test3.txt");
        File desc = new File(descPath);
        FileInputStream fis = new FileInputStream(src);

        FileOutputStream fos = new FileOutputStream(desc);
        byte[] bytes = new byte[15];
        int length;
        while ((length = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, length); //防止最後一次多讀了
        }
        long t2 = System.currentTimeMillis();
        System.out.println("It takes " + (t2 - t1) + " sec(s) to finish the process of copy.");
        fis.close();
        fos.close();
    }

    public static void copyWithBuffer(String srcPath, String descPath) throws IOException {
        long t1 = System.currentTimeMillis();
        File src = new File(srcPath);
        File des = new File(descPath);
        FileInputStream fis = new FileInputStream(src);
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream(des);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] b = new byte[15];
        int length;
        while ((length = fis.read(b)) != -1) {
            bos.write(b, 0, length); //防止最後一次多讀了
        }
        long t2 = System.currentTimeMillis();
        System.out.println("It takes " + (t2 - t1) + " sec(s) to finish the process of copy with buffer.");
        bis.close();
        bos.close();
    }

    // 寫入對象到文件中
    public static void oos() throws IOException {
        Student student = new Student();
        student.name = "Peter Chan";
        student.age = 18;

        File f = new File("/Users/Williamhui/Code/Self Learn Materials/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test4.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.close();
    }

    public static void ois() throws IOException, ClassNotFoundException {
        File f = new File("/Users/Williamhui/Code/Self Learn Materials/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test4.txt");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student s = (Student) ois.readObject();
        System.out.println(s);
        ois.close();
    }

    public static void fileReader() throws IOException {
        // Using try-with-resources to ensure that resources are closed properly
        try (FileReader fr = new FileReader("/Users/Williamhui/Code/Self Learn Materials/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test2.txt");
             FileWriter fw = new FileWriter("/Users/Williamhui/Code/Self Learn Materials/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test5.txt")) {

            int length;
            char[] chars = new char[15];
            while ((length = fr.read(chars)) != -1) {
                fw.write(chars, 0, length);
            }
        } // FileReader and FileWriter are automatically closed here, even if an exception is thrown
    }
}
