package collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

public class HashTableDemo {
    public static void main(String[] args) throws IOException {
        Hashtable ht = new Hashtable();
//        ht.put(null,"null is not allowed to become the key");
        ht.put(2, "value2");
        ht.put(8, "value8");
        ht.put(5, "value5");
        ht.put(10, "value10");
        System.out.println(ht);

        Properties prop = new Properties();
        prop.load(new FileInputStream("/Users/Williamhui/Code/self-learn/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/collection/jdbc.properties"));
        System.out.println(prop);
        System.out.println(prop.get("user"));
        System.out.println(prop.get("password"));

        prop.setProperty("url", "william.com");
        System.out.println(prop);
        prop.store(new FileOutputStream("/Users/Williamhui/Code/self-learn/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/collection/jdbc.properties"), null);
    }
}
