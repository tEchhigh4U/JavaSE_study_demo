package reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class ReadProperties {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        Message msg = new Message();
        String path = "/Users/Williamhui/Code/Self Learn Materials/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/reflect/message.properties";
        readFromProperties(path, msg);
        System.out.println(msg);

        Jdbc jdbcObject = new Jdbc();
        String jdbcPath = "/Users/Williamhui/Code/Self Learn Materials/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/reflect/jdbc.properties";
        readFromProperties(jdbcPath, jdbcObject);
        System.out.println(jdbcObject);
    }

    // Refactor the same function with class param
    public static void readFromProperties(String path, String cls) throws IOException, NoSuchFieldException, IllegalAccessException {

    }

    public static void readFromProperties(String path, Class cls) throws IOException, NoSuchFieldException, IllegalAccessException {

    }

    public static Object readFromProperties(String path, Object object) throws IOException, NoSuchFieldException, IllegalAccessException {
        Class cls = object.getClass();
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(path);
        // 加載文本中的數據到prop對象中
        prop.load(fis);
        for (String name : prop.stringPropertyNames()) {
//            System.out.println(name);
            System.out.println(name + " : " + prop.getProperty(name));
            Field declaredField = cls.getDeclaredField(name);
            declaredField.setAccessible(true);
            declaredField.set(object, prop.get(name));
        }
        return object;
    }

    public static void t1() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/Williamhui/Code/Self Learn Materials/Software Testing Complete Course_paid course/Web Automation Test_Java/JaveSE_study_demo/javase_study/src/reflect/message.properties");

        // 加載文本中的數據到prop對象中
        prop.load(fis);
        Message msg = new Message();
        msg.setMsgFrom(prop.getProperty("msgFrom", ""));
        msg.setMsgTo(prop.getProperty("msgTo", ""));
        msg.setMsgContent(prop.getProperty("msgContent", ""));
        System.out.println(msg);
    }
}
