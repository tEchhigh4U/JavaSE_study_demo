package thread;

public class TicketReferenceDemo {
    public static void main(String[] args) {
        sell();
    }

    // 火车站有3个服务窗口，一起卖100张票，卖完即止，一张票只能卖一次。买完后，主线程提示车票售罄。
    public static void sell() {
        // 创建三个独立的Runnable对象，每个对象有自己的锁
        Runnable runnable1 = createRunnable();
        Runnable runnable2 = createRunnable();
        Runnable runnable3 = createRunnable();

        // 启动三个线程
        new Thread(runnable1, "window 1").start();
        new Thread(runnable2, "window 2").start();
        new Thread(runnable3, "window 3").start();
    }

    // 创建一个Runnable对象，并定义其run方法
    private static Runnable createRunnable() {
        return new Runnable() {
            private int ticket = 100; // 初始票数为100

            @Override
            public void run() {
                while (true) {
                    synchronized (this) {
                        if (ticket < 1) { // 如果票数小于1，跳出循环
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + " has brought " + ticket-- + "th ticket.");
                        try {
                            Thread.sleep(5); // 模拟售票过程中的时间消耗
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };
    }
}
