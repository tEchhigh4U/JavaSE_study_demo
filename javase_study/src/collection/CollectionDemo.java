package collection;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        Set hs = new HashSet();
        hs.add(100);
        hs.add(30);
        hs.add(10);
        hs.add(20);
        hs.add(60);
        System.out.println(Collections.min(hs));
        System.out.println(Collections.max(hs));

        // 多態的使用
        List al = new ArrayList();
        al.add(30);
        al.add(20);
        al.add(18);
        al.add(2);

        System.out.println(al);
        Collections.reverse(al);
        System.out.println(al);

        // shuffle
        Collections.shuffle(al);
        System.out.println(al);

        // sort
        Collections.sort(al);
        System.out.println(al);

        // swap
        Collections.swap(al, 0, 3);
        System.out.println(al);

        List<Student> list = new ArrayList<>();
        Student s = new Student();
        s.name = "chan da man";
        s.score = 80;
        list.add(s);

        Student s2 = new Student();
        s2.name = "chan man";
        s2.score = 82;
        list.add(s2);

        System.out.println("Before sorting --> " + list);
        Collections.sort(list);

        System.out.println("After sorting --> " + list);
    }
}
