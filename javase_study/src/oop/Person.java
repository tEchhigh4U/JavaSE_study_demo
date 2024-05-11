package oop;

public class Person {
    public String name;
    protected String gender;
    int age;
    private double accountBalance;

    public static void main(String[] args) {
        // 創建了一個person類的對象，名為p，右邊的p是引用
        Person p = new Person();
        // 設置對象的屬性
        p.name = "william";
        p.age = 25;
        p.gender = "male";
        p.accountBalance = 500;
        System.out.println(p.info());
    }

    public String info() {
        return "Name is: " + name + " , age is: " + age + " , gender is: " + gender;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    // 提供一個方法來修改帳戶金額
    public void setAccountBalance(double accountNewBalance) {
        accountBalance += accountNewBalance;
    }
}
