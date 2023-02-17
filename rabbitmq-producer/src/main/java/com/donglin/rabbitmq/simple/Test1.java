package com.donglin.rabbitmq.simple;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Map<People, Integer> map = new HashMap<People, Integer>(1000);
        int count = 0;
        while (true){
            People p = new People("zhangsan",10);
            map.put(p,1);
            count++;
            if (count % 1000 == 0){
                System.out.println("map size: " + map.size());
                System.out.println("运行"+count+"次后，可用内存剩余"+Runtime.getRuntime().freeMemory()/(1024*1024)+"MB");
            }
        }

    }
}
class People{
    private String name;
    private Integer age;
    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }



    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
