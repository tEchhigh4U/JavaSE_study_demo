package thread.demo;

public class Consumers extends Thread {

    Bread bread;

    public Consumers(Bread bread) {
        this.bread = bread;
    }

    @Override
    public void run() {
        synchronized (bread) {
            while (true) {
                bread.consume();

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (bread.getCount() <= 5) {
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
