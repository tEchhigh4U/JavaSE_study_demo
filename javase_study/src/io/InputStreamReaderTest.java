package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/Williamhui/Code/Self Learn Materials/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/io/test.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        char[] c = new char[100];
        int len;
        while ((len = isr.read(c)) != -1) {
            System.out.println(new String(c, 0, len));
        }
    }
}
