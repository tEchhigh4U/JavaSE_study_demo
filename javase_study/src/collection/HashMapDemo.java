package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put("name", "peter");
        hm.put("age", 18);
//        hm.put(new Object(), 100); // 100能不能通過get獲取，因為new Object只是一次性拿到的
        System.out.println(hm);

        System.out.println(hm.get("age"));
        System.out.println(hm.containsKey("age"));
        System.out.println(hm.containsValue("peter"));
        System.out.println(hm.getOrDefault("age", 20));

        // 遍歷
        Set set = hm.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = hm.get(key);
            System.out.println(key + "=" + value);
        }

        System.out.println("==========================");

        // EntrySet
        Set set1 = hm.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
