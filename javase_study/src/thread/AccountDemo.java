package thread;

public class AccountDemo {
    public static void main(String[] args) throws InterruptedException {
//        t2();
        t3();
    }

    public static void t3() {
        // example： A,B兩個用戶分別給同一個帳號存錢3次，每次存1000塊，查看餘額數量
        Runnable runnable = new Runnable() {
            int balance = 0;

            @Override
            public void run() { //
                synchronized (this) { // 更加靈活，可以讓方法中一些代碼加上同步鎖
                    for (int i = 0; i < 3; i++) {
                        balance += 1000;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException();
                        }
                        System.out.println("Current balance is " + balance);
                    }
                }
            }
        };

        new Thread(runnable, "Account 1").start();
        new Thread(runnable, "Account 2").start();
    }

    ;


    public static void t2() {
        // example： A,B兩個用戶分別給同一個帳號存錢3次，每次存1000塊，查看餘額數量
        Runnable runnable = new Runnable() {
            int balance = 0;

            @Override
            public synchronized void run() {// run方法中的代碼都是同步代碼
                for (int i = 0; i < 3; i++) {
                    balance += 1000;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                    System.out.println("Current balance is " + balance);
                }
            }
        };

        new Thread(runnable, "Account 1").start();
        new Thread(runnable, "Account 2").start();
    }

    public static void t1() {
        // example： A,B兩個用戶分別給同一個帳號存錢3次，每次存1000塊，查看餘額數量
        Runnable runnable = new Runnable() {
            int balance = 0;

            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    balance += 1000;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                    System.out.println("Current balance is " + balance);
                }
            }
        };

        new Thread(runnable, "Account 1").start();
        new Thread(runnable, "Account 2").start();
    }
}