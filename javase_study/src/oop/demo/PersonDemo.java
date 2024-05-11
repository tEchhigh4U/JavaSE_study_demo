package oop.demo;

import oop.Person;

public class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "william";
//        person.age = 25;
//        person.gender = "male";
        System.out.println("我的名稱是： " + p.name);
        p.setAccountBalance(1000);
        System.out.println("存款是： " + p.getAccountBalance());
    }
}
