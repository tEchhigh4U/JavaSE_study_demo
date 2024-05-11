package oop.demo;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        float a = 1;
        float b = 0.9f;
        System.out.println(a - b); // 精度丟失的問題

        double c = 1;
        double d = 0.9d;
        System.out.println(c - d); // 精度丟失的問題

        BigDecimal b1 = new BigDecimal(0.01); // 精度丟失的問題

        // 推薦的方法
        BigDecimal b2 = new BigDecimal("0.01");
        BigDecimal b3 = BigDecimal.valueOf(0.01);
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);
        System.out.println(b2.equals(b3));

        // 比較值
        BigDecimal b4 = new BigDecimal("0.010");
        System.out.println(b2.equals(b4)); // false, 因為兩個值的精度不一樣，即是小數位的值不一樣
        System.out.println(b2.compareTo(b4));

        b2 = b2.add(b3);  //記得存存在變量裡面
        b2 = b2.add(b4); // 有加法時，有一個更高精度的運算數時，那麼結果以高精度的結果為主
        System.out.println(b2);

        b2 = b2.subtract(BigDecimal.valueOf(0.002));
        System.out.println(b2);

        b2 = b2.multiply(BigDecimal.valueOf(2));
        System.out.println(b2);

//        System.out.println(BigDecimal.valueOf(1).divide(BigDecimal.valueOf(3)));
        System.out.println(BigDecimal.valueOf(1.00).divide(BigDecimal.valueOf(3), BigDecimal.ROUND_UP));
        System.out.println(BigDecimal.valueOf(1.00).divide(BigDecimal.valueOf(3), BigDecimal.ROUND_DOWN));
        System.out.println(BigDecimal.valueOf(1.00).divide(BigDecimal.valueOf(3), BigDecimal.ROUND_CEILING));
//        System.out.println(BigDecimal.valueOf(1).divide(BigDecimal.valueOf(3), BigDecimal.ROUND_UNNECESSARY)); // ERROR
        System.out.println(BigDecimal.valueOf(1.00).divide(BigDecimal.valueOf(3), BigDecimal.ROUND_HALF_DOWN));
        System.out.println(BigDecimal.valueOf(1.00).divide(BigDecimal.valueOf(3), BigDecimal.ROUND_HALF_UP));

        System.out.println(BigDecimal.valueOf(-1.00).divide(BigDecimal.valueOf(3), BigDecimal.ROUND_UP));
        System.out.println(BigDecimal.valueOf(-1.00).divide(BigDecimal.valueOf(3), BigDecimal.ROUND_CEILING));

//        System.out.println(BigDecimal.valueOf(1.00).multiply(BigDecimal.valueOf(1000000000000000))); //integer number too large
        System.out.println(BigDecimal.valueOf(1.00).multiply(BigDecimal.valueOf(1000000000000000L)).toPlainString());
        System.out.println(BigDecimal.valueOf(1.00).multiply(BigDecimal.valueOf(1000000000000000L)).toEngineeringString());
    }
}
