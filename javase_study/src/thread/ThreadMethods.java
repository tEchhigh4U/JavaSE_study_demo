package thread;

public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.activeCount());
            }
        };
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.activeCount());
            }
        };

        t1.setName("this is thread of number 10");
        t0.start();
        t1.start();

        // - > wait for a thread to be done to execute

        Thread t2 = new Thread() {
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
        };
        t2.setName("this is a joint thread of number 12");
        t2.start();


        // t2線程中的代碼執行完成後，才可以執行下面的代碼
        t2.join(); // t2線程插隊到main線程中，且必須要等t2線程中的代碼執行完畢，才會讓main線程繼續執行
        System.out.println("程序執行完成！");
    }
}
