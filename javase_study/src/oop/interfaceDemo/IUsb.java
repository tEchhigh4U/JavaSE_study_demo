package oop.interfaceDemo;

// 接口的名稱，建議使用i開頭
public interface IUsb {
    // 常量
    // public obstruct修飾的方法

    //    public static final double PI = 3.14159265358979323846;
    double PI = 3.14159265358979323846;

    void connect();
    // public obstruct void show();

    default void init() {
        System.out.println("這是接口中default修飾的方法。");
        connect();
    }
}
