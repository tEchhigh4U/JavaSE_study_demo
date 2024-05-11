package base;

public class MethodDemo {
    public static void main(String[] args) {
        // static方法是可以直接使用static方法的
        // static方法是不可以直接使用實例方法
        demo1();
//        demo2();
        // 創建MethodDemo類的實例
        MethodDemo md = new MethodDemo(); //創建了一個名為md的實例
        md.demo1(); // md即可以調用md實例中的靜態方法
        md.demo2(); // 也可以調用md實例中的實例方法

    }

    public static void demo1() {

    }

    public void demo2() {
    }
}
