package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add("1");
        al.add(10);
        al.add(30);
        al.add(20);
        al.add(18);
        al.add(2, 15);
        al.add(2);
        System.out.println(al);
        // 捕獲特定位置的元素值
        System.out.println(al.get(1));
        System.out.println(al.indexOf(10));

        System.out.println(al.size());
        System.out.println(al.remove(al.size() - 1));
        System.out.println(al.remove("2"));
        System.out.println(al);
        System.out.println(al.set(3, 22));
        System.out.println(al);
        System.out.println(al.set(0, 2));

        // 排序（由大到小排列）
        al.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(al);

        System.out.println(al.subList(1, 3));

        Object[] objects = al.toArray();
        System.out.println(Arrays.toString(objects));

        // 支持遍歷
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
        System.out.println();
        // 支持迭代
        Iterator it = al.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
