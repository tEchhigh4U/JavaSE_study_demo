package thread;

public class CommunicationDemo {
    public static void main(String[] args) {
        Object object = new Object();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // 同步鎖的應用
                synchronized (object) {
                    while (true) {
                        try {
                            // 必須要通過作為鎖的對象來調用notify()和wait()
                            object.notify();
                            System.out.println(Thread.currentThread().getName() + " wakes up");
                            object.wait();
                            System.out.println(Thread.currentThread().getName() + " sleeps");
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }
}
