package oop;

public class OuterClass {
    static double money;
    private int age = 29;

    public static void main(String[] args) {
        // 創建外部類的實例
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClassOfOuterClass = outerClass.new InnerClass();
        // 調用內部類的show（）方法
        innerClassOfOuterClass.show();

        // 在另外一個類中創建實例的寫法
        System.out.println("在另外一個類中創建實例的寫法");
        OuterClass.StaticInnerClass staticInnerClassOfOuterClass = new OuterClass.StaticInnerClass();
        staticInnerClassOfOuterClass.show();

        // 在本類中創建實例的方法
        StaticInnerClass staticInnerClassOfOuterClassShow = new StaticInnerClass();
        System.out.println("在本類中創建實例的寫法");
        staticInnerClassOfOuterClassShow.show();
    }

    static class StaticInnerClass {
        public void show() {
//            System.out.println(age);
            System.out.println("請留意金額： " + money);
        }
    }

    class InnerClass {
        public void show() {
            System.out.println(age);
        }
    }
}
