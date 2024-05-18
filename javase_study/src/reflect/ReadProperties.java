package reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReadProperties {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
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
    public static void readFromProperties(String path, String clsPath) throws IOException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName(clsPath);
        readFromProperties(path, cls);

    }

    public static void readFromProperties(String path, Class cls) throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // create instance 創建對象
        Object o = cls.newInstance();
        // 那如果沒有默認構造方法，該怎麼辦呢？
//        Constructor constructor = cls.getDeclaredConstructor(行參列表的類型) // 形參列表的類型，會造成通用性降低
//        Constructor constructor = cls.getDeclaredFields(); // 獲取默認構造方法
        readFromProperties(path, o);
    }

    public static Object readFromProperties(String path, Object object) throws IOException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(path);
        // 加載文本中的數據到prop對象中
        prop.load(fis);
        Class cls = object.getClass();
        for (String name : prop.stringPropertyNames()) {
//            System.out.println(name);

            // 參數
            Object value = prop.get(name);
//            System.out.println(name + " : " + prop.getProperty(name));
            Field declaredField = cls.getDeclaredField(name);

            // 暴力破解
            declaredField.setAccessible(true);
            declaredField.set(object, prop.get(name));

            // 通過set方法來賦值
            // 拼接方法名稱
            String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
//            System.out.println("methodName: " + methodName + ", value(type): " + value.getClass());

            // 得到方法對象
            Method method = cls.getDeclaredMethod(methodName, value.getClass());
//            System.out.println("------" + method.getName() + "------");

            // 調用方法
            method.invoke(object, value);
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
