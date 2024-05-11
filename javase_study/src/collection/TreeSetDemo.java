package collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
//        TreeSet ts = new TreeSet();
//        ts.add("aaa");
//        ts.add("bbb");
//        ts.add("ccc");

        TreeSet ts = new TreeSet(new Comparator() {
            @Override
            // negative integer (前一個少於後一個)，0（相等），positive integer
            public int compare(Object o1, Object o2) {
                return (Integer) o2 - (Integer) o1;
//                return (int) o2 - (int) o1;
                // Integer: 支持null
                // int： 不支持null
            }
        });

        ts.add(1);
        ts.add(8);
        ts.add(100);
        ts.add(80);
        ts.add(20);
        System.out.println(ts);
        System.out.println(ts.first());
        System.out.println(ts.last());
        System.out.println(ts.contains(20));

        System.out.println(ts);
        System.out.println(ts.ceiling(30)); // 找出比30小的最近的一個數據
        System.out.println(ts.floor(30)); // 找出比30大的最近的一個數據

        System.out.println(ts.size());
        System.out.println(ts.pollFirst());
        System.out.println(ts);
        System.out.println(ts.size());

        Iterator it = ts.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
    }
}
