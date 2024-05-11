package thread;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMapDemo demo = new ConcurrentHashMapDemo();
        demo.example2();
    }

    public void example2() {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Runnable runnable = new Runnable() {
            int count = 100000;

            @Override
            public void run() {
                while (count-- > 0) {
                    concurrentHashMap.put(count, count);
                }
                System.out.println(Thread.currentThread().getName() + " is ended.");
            }
        };

        int time = 5;
        for (int i = 0; i < time; i++) {
            new Thread(runnable, "example 2 add thread --- " + i).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("concurrentHashMap.size() = " + concurrentHashMap.size());
        System.out.println("concurrentHashMap.mappingCount() = " + concurrentHashMap.mappingCount());
    }
}
