package base;

public class CirculationExercises {
    public static void main(String[] args) {
//        exercise1();
//        exercise2();
//        exercise3();
        exercise4();
    }

    public static void exercise4() {
        // 取出百位，十位和個位
        for (int i = 100; i <= 999; i++) {
            int hundredsDigit = i / 100;
            int tensDigit = i % 100 / 10;
            int unitDigit = i % 10;
            if (i == hundredsDigit * hundredsDigit * hundredsDigit + tensDigit * tensDigit * tensDigit + unitDigit * unitDigit * unitDigit) {
                System.out.println("水仙花數是： " + i);
            }
        }
    }

    public static void exercise3() {
        for (int i = 1; i <= 150; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " foo\t"); // \t 製表符號， 4個空格
            }
            if (i % 5 == 0) {
                System.out.print(i + " biz\t");
            }
            if (i % 7 == 0) {
                System.out.print(i + " baz\t");
            }
            System.out.println(); //換行
        }
    }

    public static void exercise1() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) { //判斷奇數
                // sum = sum + i
                sum += i;
            }
        }
        System.out.println("1-100之間所有奇數之和： " + sum);
    }

    // 打印1-100所有是7的倍數的整數的個數及總和
    public static void exercise2() {
        int sum = 0; // sum of numbers
        int count = 0; //number of count
        for (int i = 1; i < 100; i++) {
            if (i % 7 == 0) {
                sum += i;
                count++;
            }
        }
        System.out.println("1-100所有是7的倍數的整數的個數是: " + count + " 及總和: " + sum);
    }
}
