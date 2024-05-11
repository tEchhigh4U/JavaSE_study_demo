package oop.interfaceDemo;

public interface IBluetooth {
    void BTConnect();

    default void init() {
        System.out.println("這是接口中default修飾的方法");
    }
}
