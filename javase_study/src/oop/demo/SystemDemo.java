package oop.demo;

import java.util.Arrays;

public class SystemDemo {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = new int[a.length];
//        System.arraycopy(a, 0, b, 0, a.length);
        System.arraycopy(a, 0, b, 0, 3);
        System.out.println(Arrays.toString(b)); //[1, 2, 3, 0, 0, 0, 0, 0, 0, 0]
    }

}
