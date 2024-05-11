package oop;

// 單例模式
public class Singleton {
    // 餓漢式
    //private static Singleton instance = new Singleton(); //靜態實例

    // 懶漢式
    private static Singleton instance;

    // 變為私有的方法，導致其他類不能有構造方法
    private Singleton() {
    }

    // 以下代碼是針對懶漢式創建靜態實例
    public static Singleton getInstance() {
        // 如果配合多線程使用，就有什麼問題呢？
        //
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
