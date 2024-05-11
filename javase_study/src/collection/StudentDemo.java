package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class StudentDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "chan da man";
        s.score = 80;

        Student s2 = new Student();
        s2.name = "chan man";
        s2.score = 82;

        // to compare scores of two student
//        System.out.println(s.compareTo(s2));

        TreeSet<Student> set = new TreeSet(new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.score - o2.score;
            }
        });
        set.add(s);
        set.add(s2);
        System.out.println(set);

        List<Student> list = new ArrayList<>();

    }
}
