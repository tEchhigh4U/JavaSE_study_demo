package oop;

public class ConstructorDemo {
    // public可以讓類和類以外的地方都可以拿到deposit的數據
    public static int deposit = 1000;  //所有ConstructorDemo類的對象或者類本身都可以讀取同一個數據
    String str;

    // 每一個類都會提供一個無參的構造方法，當參見自定義方法時，則不會提供默認的無參構造方法
    public ConstructorDemo() {
        this("Make use of ConstructorDemo that has the same name"); //調用其他構造方法
        System.out.println("ConstructorDemo");
    }

    public ConstructorDemo(String str) {
        super(); //隱藏第一行的代碼，就算不寫，也會有。作用是調用父類的構造方法
        // 要求傳入name參數，怎麼使用都有programmer做決定
        System.out.println(str);
        this.str = str; //this關鍵字可以區分屬性和局部變量，形參同名的情況
        return; // return也是隱藏的
    }

    public static void main(String[] args) {
        ConstructorDemo cd1 = new ConstructorDemo();
        cd1.str = "Look at me";
        System.out.println(cd1.str);
        System.out.println(cd1.deposit);

        ConstructorDemo cd2 = new ConstructorDemo("start");
        cd2.str = "Dont look at me";

        // deposit是靜態屬性，可以直接在靜態方法中使用
        // 更改deposit的數據
        cd1.deposit = 2000; //因為所有對象共用一個內存地址
//        System.out.println(str); // 因為str是實例，必須通過實例來調用
        System.out.println("cd1 deposit is: HKD " + cd1.deposit);
        System.out.println("cd2 deposit is: HKD " + cd2.deposit);
        System.out.println("Construction deposit is: " + ConstructorDemo.deposit);


    }
}
