//package thread;
//
//public class ThreadExercise extends Thread {
//    static int count = 100;
//
//    @Override
//    public void run() {
//        for (int i = 0; i < count; i++) {
//            System.out.println(Thread.currentThread() + " - " + count);
//            count--;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException();
//            }
//        }
//    }
//}
//
//public static void main(String[] args) {
//    ThreadExercise t1 = new ThreadExercise();
//    ThreadExercise t2 = new ThreadExercise();
//    ThreadExercise t3 = new ThreadExercise();
//    t1.start();
//    t2.start();
//    t3.start();
//}
