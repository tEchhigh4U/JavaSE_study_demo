package reflect;

import java.lang.reflect.Field;

public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Message msg = new Message();
        System.out.println(msg);
        t1(msg);
        //Compare with the previous object
        System.out.println(msg);
    }

    public static void t1(Object object) throws ClassNotFoundException, IllegalAccessException {
//        Class cls = Class.forName("reflect.Message");
        Class cls = object.getClass();
//        System.out.println(cls);

        // 獲取Class對應的s屬性值
        Field[] declaredFields = cls.getDeclaredFields();
        System.out.println(object);

        for (Field declaredField : declaredFields) {
            // 打印屬性對象的名稱
            System.out.println(declaredField.getName());
            // 因為屬性一般都是私有的，所以需要暴力破解
            declaredField.setAccessible(true);
            declaredField.set(object, declaredField.getName() + " --- ");
        }

        System.out.println(object);
    }
}
