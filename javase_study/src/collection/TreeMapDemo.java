package collection;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        tm.put(2, "value2");
        tm.put(8, "value8");
        tm.put(5, "value5");
        tm.put(10, "value10");
        System.out.println(tm);
    }
}
