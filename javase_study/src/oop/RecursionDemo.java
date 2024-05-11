package oop;

//public class RecursionDemo {
//    // 通過遞歸來實現，自減到0
//    public void deduction(int i){
//        if(i == 0){
//            return;
//        }
//        i--;
//        if(i > 0){
//            deduction(i);
//        }
//    }
//
//    public static void main(String[] args) {
//        RecursionDemo demo = new RecursionDemo();
//        demo.deduction(100);
//    }
//}

public class RecursionDemo {
    public static void main(String[] args) {
        RecursionDemo demo = new RecursionDemo();
        demo.deduction(100);
    }

    /**
     * Recursively decrements the value of i until it reaches 0.
     *
     * @param i the integer to be decremented
     */
    public void deduction(int i) {
        if (i <= 0) {
            System.out.println("END");
            return;  // Base case: stop the recursion when i is 0 or less
        }
        System.out.println(i);
        deduction(i - 1);  // Recursive call with decremented value
    }
}
