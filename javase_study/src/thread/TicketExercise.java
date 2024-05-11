package thread;

public class TicketExercise {
    public static void main(String[] args) {
        sell();
    }

    // 火車站有3個服務窗口，一起賣150張票，賣完即止，一張票只能賣一次。買完後，主線程提示車票售罄。
    public static void sell() {

        // 創建一個runnable對象，執行run方法
        Runnable runnable = new Runnable() {
            int ticket = 150;

            @Override
            public void run() {
                while (true) {
                    // 有另外一個問題：性能降低
                    synchronized (this) { // 更加靈活，可以讓方法中一些代碼加上同步鎖
                        if (ticket < 1) {
//                            System.out.println(Thread.currentThread().getName() + " has been sold out all tickets.");
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + " has brought " + ticket-- + " th tickets.");
                        try {
                            Thread.sleep(2);
                        } catch (InterruptedException e) {
                            throw new RuntimeException();
                        }
                    }
                }
            }
        };

        new Thread(runnable, "window 1").start();
        new Thread(runnable, "window 2").start();
        new Thread(runnable, "window 3").start();
    }


}
