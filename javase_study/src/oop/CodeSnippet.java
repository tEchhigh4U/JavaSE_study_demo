package oop;

public class CodeSnippet {
    static {
        // 靜態代碼塊
        // 靜態代碼塊在虛擬機加載類的時候就執行了
        System.out.println("靜態代碼塊1");
    }

    static {
        System.out.println("靜態代碼塊2");
    }

    final int j = 20; // constant
    final int k; // constant
    int i;

    {
        // 普通代碼塊在構造方法之前實行的
        // 普通代碼塊跟對象有關係
        // normal code block
        // 初始化屬性，也可以初始化常量
        System.out.println("普通代碼塊1");
        i = 2;
        k = 20;
    }

    {
        System.out.println("普通代碼塊2");

    }

    public CodeSnippet() {
        System.out.println("構造方法");
    }

    public static void main(String[] args) {
        // 這是類實例化
        // 用完即棄
        new CodeSnippet();

        /*
        1. 在堆內存中分配空間， 產生一個堆中的地址，是否需要保存到變量中
        2. 類的屬性做默認的初始化
        3. 設置對象頭
        4. 執行類中<init>中的方法執行
            1. 先執行super()方法調用父類的構造方法
            2. 類的屬性賦值語句的執行
            3. 執行收集的普通代碼塊
            4. 執行構造方法自定義的代碼
            5. 執行return語句
         */

        // 這也是類的實例化
        // 不過它保存在一個變量中，可以隨時調用
        CodeSnippet codeSnippet = new CodeSnippet();
    }
}
