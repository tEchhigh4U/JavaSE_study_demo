package oop.demo;

public class ExceptionDemo {
    public static void main(String[] args) {
//        demo1();
        try {
            demo2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void demo2() throws Exception {
        int i = 200;
        if (i == 200) {
            System.out.println("Friendly reminder, program has problem.");
            throw new Exception("Demo is a problem.");
        }
    }

    public static void demo1() {
        String s = "200";
        s = "input error"; // Intentionally set to a non-integer value to simulate an error
        try {
            // 認為下面的代碼可能會有異常，準備來捕獲
            System.out.println(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            // 當try中的代碼出現異常時，就會執行catch中的代碼
            e.printStackTrace();
            System.out.println("程序出現異常，請在catch中處理");
        }
        System.out.println("Application exits.");
    }
}
