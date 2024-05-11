package thread;

public class ThreadDemo {
    public static void main(String[] args) {
        // main也是一個線程，稱為主線程
        DemoThread demo1 = new DemoThread();
        DemoThread demo2 = new DemoThread();
        DemoThread demo3 = new DemoThread();
        // 啟動線程
        demo1.start();
        demo2.start();
        demo3.start();
    }

    private static class DemoThread extends Thread {
        @Override
        public void run() { //run() 不能拋出異常
            for (int i = 0; i < 10; i++) {
                // 獲取當前線程
                System.out.println(Thread.currentThread() + " - " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

