package oop.interfaceDemo;

public class Keyboard implements IUsb, IBluetooth {

    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard();
        keyboard.init();
    }

    @Override
    public void connect() {
        System.out.println("Keyboard is now being connected by USB.");
    }

    @Override
    public void BTConnect() {
        System.out.println("Keyboard is now being connected by Bluetooth.");
    }

    @Override
    public void init() {
        IUsb.super.init(); // Use USB's init method, or choose Bluetooth's or your own.
        // IBluetooth.super.init();
    }


}
