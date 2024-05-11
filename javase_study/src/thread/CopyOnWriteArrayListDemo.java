package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayListDemo copyOnWriteArrayListDemo = new CopyOnWriteArrayListDemo();
//        copyOnWriteArrayListDemo.example1();
//        copyOnWriteArrayListDemo.example2();
        copyOnWriteArrayListDemo.example3();
    }

    public void example1() {
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // Thread 1: 通過Iterator遍歷List
        new Thread(() -> {
            for (int item : list) {
                System.out.println("遍歷元素是： " + item);

                // 調慢程序運行的速度
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            list.remove(4);
            System.out.println("list remove element of '4'.");
        }).start();
    }

    public void example2() {
        // 測試容器
        final List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // Thread 1: 通過Iterator遍歷List
        new Thread(() -> {
            for (int item : list) {
                System.out.println("遍歷元素是： " + item);

                // 調慢程序運行的速度
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            list.remove(4);
            System.out.println("list remove element of '4'.");
        }).start();
    }

    public void example3() {
        // 測試容器
        final Set<Integer> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }

        // Thread 1: 通過Iterator遍歷List
        new Thread(() -> {
            for (int item : set) {
                System.out.println("遍歷元素是： " + item);

                // 調慢程序運行的速度
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            set.remove(4);
            System.out.println("list remove element of '4'.");
        }).start();
    }
}
