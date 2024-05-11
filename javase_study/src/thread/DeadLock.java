package thread;

public class DeadLock {

    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(String[] args) {

        //Thread 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1) {
                    //System.out.println("111");
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {
                        System.out.println("222");
                    }
                }
            }
        }).start();

        //Thread 2
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o2) {
                    //System.out.println("333");
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (o1) {
                        System.out.println("444");
                    }
                }
            }
        }).start();
    }
}
