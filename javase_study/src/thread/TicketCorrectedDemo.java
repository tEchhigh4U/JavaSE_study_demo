package thread;

public class TicketCorrectedDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(100); // 创建一个共享的票数对象

        // 创建三个独立的Runnable对象，共享同一个票数对象
        Runnable runnable1 = createRunnable(ticket);
        Runnable runnable2 = createRunnable(ticket);
        Runnable runnable3 = createRunnable(ticket);

        // 启动三个线程
        new Thread(runnable1, "window 1").start();
        new Thread(runnable2, "window 2").start();
        new Thread(runnable3, "window 3").start();
    }

    // 创建一个Runnable对象，并定义其run方法
    private static Runnable createRunnable(Ticket ticket) {
        return new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int remaining = ticket.sell(); // 出售一张票，且使用了實例同步
                    if (remaining == -1) {
                        System.out.println(Thread.currentThread().getName() + "：票已售罄");
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " has brought " + remaining + "th ticket.");
                    }
                    try {
                        Thread.sleep(2); // 模拟售票过程中的时间消耗
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
    }

    private static class Ticket {
        private int count;

        public Ticket(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        // 定義一個同步的方法
        public synchronized int sell() {
            if (count > 0) {
                return count--;
            } else {
                return -1; // 表示票已售罄
            }
        }
    }
}