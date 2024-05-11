package collection;

public class Student implements Comparable<Student> {
    String name;

    // what is the difference between Integer and int for this data "score" here?
    Integer score;
    //    int score;

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
