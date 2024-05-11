package thread;

public class DamenThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread secondary = new Thread(() -> {
            while (true) {
                System.out.println("I am working as a secondary thread!");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        secondary.setDaemon(true); // secondary就是main線程的守護線程。當main線程結束時，secondary線程也會結束。
        secondary.start();

        Thread.sleep(2000);
        System.out.println("Main thread is working now!");
    }
}
