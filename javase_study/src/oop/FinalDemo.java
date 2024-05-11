package oop;

public class FinalDemo {
    private static final int j = 40; // 類常量
    private final int i = 20; // 定義了一個常量
    // 以上數據都是常量，不能修改

    public static void main(String[] args) {
        FinalDemo fd = new FinalDemo();
//        fd.i = 30; // i是常量，不能被修改 // 也就是final修飾的屬性不能被修改
        final int k = 100;
//        k = 120;
    }

    public final void init() {
        System.out.println("這是被final修飾的方法");
    }
}

//class AnotherFinalDemo extends FinalDemo{
////    public final void init(){
////        System.out.println("這是被final修飾的方法");
////    }
//    // 被final修飾的方法不能夠被重寫
//}