package thread.demo;

public class Producers extends Thread {

    Bread bread;

    public Producers(Bread bread) {
        this.bread = bread;
    }

    @Override
    public void run() {
        synchronized (bread) {
            while (true) {
                bread.produce();

                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (bread.getCount() >= 20) {
                    // 喚醒另外一個線程去
                    try {
                        bread.notify();
                        bread.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
