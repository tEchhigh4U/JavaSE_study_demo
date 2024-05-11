package oop.demo;

import java.util.Scanner;

public class WrapperClassDemo {
    public static void main(String[] args) {
        int i = 10;

        // i = null //需要一個整型數據，但目前還沒有值
        Integer ig = null;
        if (ig == null) {
            ig = 100; // 自動裝箱和自動拆箱
        }
        int j = ig; //自動拆箱

        // 將String中的數字轉換成真正的數字
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        Integer ii = new Integer(n); // 轉化成整型的數字
        Integer.parseInt(n); // 轉換為整型的數字
        Integer.valueOf(n); // 轉換為整型的數字
        System.out.println(ii.doubleValue());

    }
}
