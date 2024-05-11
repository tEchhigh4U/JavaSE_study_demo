package base;

public class CirculationDemo {
    public static void main(String[] args) {
        demo1();
    }


    // print out the 9*9 multiplication table
    public static void demo1() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
                /*
                break; // 只結束j循環
                //
                 */
            }
            System.out.println();
        }
    }
}
