package oop;

public class SingletonDemo {

    public static void main(String[] args) {
        //Singleton s = new Singleton(); //無法創建了
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        // 返回true就證明是創件了兩個對象是同一個對象，意味著同一個對象在同一個內存地址上（即使在代碼裡面是不同的名字）
        System.out.println(s1 == s2);
    }
}
