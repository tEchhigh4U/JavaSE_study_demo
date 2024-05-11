package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        // vector是線程安全的，方法基本上都支持同步
        Vector v = new Vector();
        v.add(20);
        v.add(12);
        v.add(8);
        v.add(1);
        System.out.println(v);
        System.out.println(v.size());

        System.out.println(v.elementAt(0));

        // 枚舉
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + " ");
        }
    }
}
