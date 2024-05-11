package thread;

public class RunnableDemo {
    public static void main(String[] args) {
        RDemo demo = new RDemo();
        Thread t1 = new Thread(demo, "thread 1");
        Thread t2 = new Thread(demo, "thread 2");
        Thread t3 = new Thread(demo, "thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

    private static class RDemo implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + ":" + i);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
