package oop.demo;

import java.util.Arrays;

public class StringDemo {
    public static void StringMethodDemo() {
        /*
        如果字符串頻繁地拼接或者刪除等操作，那麼就直接推薦使用下面的兩個類
        StringBuffer: 線程安全，如果考慮到多線程的使用時，就使用它
        StringBuilder: 線程不安全，所以效率比StringBuffer高一些
         */

        StringBuffer sb = new StringBuffer();
        sb.append("Hello");
        sb.append("!");
        sb.deleteCharAt(0);
        System.out.println(sb);
    }

    public static void stringMethod() {
        String hello = "hello,world";
        System.out.println(hello.charAt(0));
        System.out.println(Arrays.toString(hello.toCharArray()));
        System.out.println(hello.contains("o"));
        System.out.println(hello.toLowerCase());
        System.out.println(hello.toUpperCase());
        System.out.println(Arrays.toString(hello.split(",")));
        System.out.println(Arrays.toString(hello.toUpperCase().split(",")));
        System.out.println(hello.indexOf("r"));
        System.out.println(hello.lastIndexOf("r"));
        System.out.println(hello.lastIndexOf("d"));
    }

    public static void main(String[] args) {
//        stringMethod();
        StringMethodDemo();
    }
}
