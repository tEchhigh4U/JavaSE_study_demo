package thread;

// 线程安全问题产生的主要原因有两个：存在共享资源和多个线程共同操作共享数据。
// 就是当多个线程同时操作同一个可共享的资源时导致出现的一些不必要的问题，此时就出现了线程的安全问题，这个时候就需要使用到线程同步。
// 通过一个非常经典的案例卖票来演示线程安全问题（三个窗口总共卖150张票）
public class TicketRunnableDemo {
    public static void main(String[] args) {
        // TicketRunnable ticket = new TicketRunnable();
        TicketSyn ticketSyn = new TicketSyn();

//        Thread t1 = new Thread(ticket, "Window 1");
//        Thread t2 = new Thread(ticket, "Window 2");
//        Thread t3 = new Thread(ticket, "Window 3");

        Thread t4 = new Thread(ticketSyn, "Window 4");
        Thread t5 = new Thread(ticketSyn, "Window 5");
        Thread t6 = new Thread(ticketSyn, "Window 6");

//        t1.start();
//        t2.start();
//        t3.start();

        t4.start();
        t5.start();
        t6.start();
    }

    // 沒有使用同步方法的 Ticket 對象
    public static class Ticket implements Runnable {
        private int ticket = 150;

        @Override
        public void run() {
            while (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "賣出了一張票，票號為：" + ticket--);

                try {
                    Thread.sleep(100); // 模擬賣票的時間，展示效果更明顯
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class TicketRunnable implements Runnable {

        //定义200张票（临界资源）
        private int ticket = 200;

        private Object object = new Object();

        @Override
        public void run() {

            //1、synchronized (obj)：获取自定义对象的锁，可以是Java非NULL的所有对象
            //2、synchronized (this):获取当前对象锁，此时的this为Ticket ticket = new Ticket();对象
            //3、synchronized (Ticket.class)：获取当前类对象锁，Class clazz=Ticket.class
            synchronized (object) {
                while (ticket > 0) {
                    try {
                        Thread.sleep(10);//让效果明显一点加个sleep
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出了一张票，票号为：" + ticket);
                    ticket--;
                }
            }
        }
    }

//    public static void main(String[] args) {
//        Ticket ticket = new Ticket();
//
//        new Thread(ticket, "Window 1").start();
//        new Thread(ticket, "Window 2").start();
//        new Thread(ticket, "Window 3").start();
//    }

    public static class TicketSyn implements Runnable {

        //定义100张票（临界资源）
        private int ticket = 100;

        @Override
        public void run() {
            sell();
        }

        //定义同步 --- synchronized 方法
        public synchronized void sell() {
            while (ticket > 0) {
                try {
                    Thread.sleep(10);//让效果明显一点加个sleep
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出了一张票，票号为：" + ticket);
                ticket--;
            }
        }
    }
}