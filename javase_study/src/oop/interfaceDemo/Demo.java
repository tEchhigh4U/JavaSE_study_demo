package oop.interfaceDemo;

public class Demo {
    public static void main(String[] args) {

        // 匿名內部類對象
        // 不需要起名字，多數情況下是一次使用
        new IUsb() {

            @Override
            public void connect() {

            }
        };
    }
}
