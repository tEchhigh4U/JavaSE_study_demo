package thread;

public class TicketObjectSynchronizedDemo {
    static int count = 100;

    public static void main(String[] args) {
        Object lock = new Object();
        new Thread("Window 1") {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (count < 0) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + " has brought the " + count-- + " th ticket.");

                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }.start();

        new Thread("Window 2") {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        if (count < 0) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + " has brought the " + count-- + " th ticket.");

                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }.start();
    }
}
