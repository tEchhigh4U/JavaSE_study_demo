package oop.exercise;

public class Employee {
    private String code; // 員工號
    private String name; // 姓名
    private double salary; // 薪水
    private String department; // 部門

    public Employee(String code) {
        this(code, "null", 0, null);
//        this.code = code;
//        this.name = "null";
//        this.salary = 0.0;
//        this.department = null;
    }

    public Employee(String code, String name) {
        this(code, name, 1000, "logistics");
//        this.code = code;
//        this.name = "null";
//        this.salary = 1000;
//        this.department = "logistics";
    }

    public Employee(String code, String name, double salary, String department) {
        this.code = code;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Employee() {
        this("", "", 0, "");
    }

    public static void main(String[] args) {
        Employee peter = new Employee("HK01", "Peter Cheung", 12.500, "after sale");
        System.out.println(peter.getInfo());
    }

    public String getInfo() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
