package io;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class FastjsonDemo {
    public static void main(String[] args) {
//        ObjectToStringConvertor();
        String str = "[{\"age\":26,\"name\":\"Cherry Lai\"},{\"age\":18,\"name\":\"Peter Liu\"}]";
        List<Student> students = JSON.parseArray(str, Student.class);
        System.out.println(students);
        System.out.println(students.get(0).age);

        str = "{\"name\":\"Cherry Lai\",\"age\":26}"; // be careful of ":" instead of using "="
        System.out.println(JSON.parseObject(str, Student.class).name);

    }

    public static void ObjectToStringConvertor() {
        Student s1 = new Student();
        s1.name = "Cherry Lai";
        s1.age = 26;
//        String str = JSON.toJSONString(s1);
//        System.out.println(str);

        Student s2 = new Student();
        s2.name = "Peter Liu";
        s2.age = 18;
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        String str = JSON.toJSONString(list);
        System.out.println(str);
    }
}
