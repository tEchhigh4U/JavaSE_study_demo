package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashsetDemo {
    public static void main(String[] args) {
        // Hashset不能添加重複的數據, 無序排列的，即不會按照我們添加的順序保存
        Set hs = new HashSet();
        hs.add(100);
        hs.add(10);
        hs.add(20);
        hs.add(30);
        hs.add("40");
        hs.add(new Object());

        // 通過迭代器遍歷集合
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }

        System.out.println();
        System.out.println(hs.size());
        hs.remove(new Object());
        hs.add("new Object");
        hs.remove("new Object");
        System.out.println(hs);

//        hs.clear(); // 清空set
//        System.out.println(hs);
//        System.out.println(hs.isEmpty());

        //        for (Object o : hs) {
//            System.out.println(o);
//        }


    }
}
