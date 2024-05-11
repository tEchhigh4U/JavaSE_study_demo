package base;

public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.random());
        System.out.println(Math.abs(-10)); // 整數結果
        System.out.println(Math.ceil(1.12)); // double數
        System.out.println((int) Math.floor(1.12)); // casting -> 整數結果
        System.out.println((int) Math.ceil(1.12)); // casting -> 整數結果
        System.out.println(Math.round(1.12)); //整數結果
    }
}
