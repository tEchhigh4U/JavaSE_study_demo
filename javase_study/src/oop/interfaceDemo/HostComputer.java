package oop.interfaceDemo;

public class HostComputer {
    public void externalKeyboard(IUsb usb) {
        // 調用接口usb中的connect方法
        usb.connect();
    }

    ;

}
