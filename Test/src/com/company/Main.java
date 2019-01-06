package com.company;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {
        Field[] f1=LinkedHashMap.class.getDeclaredFields();
        Field[] f2=LinkedHashMap.class.getFields();

        // write your code here
        for (Field f:LinkedHashMap.class.getDeclaredFields()
             ) {
            System.out.println(f.getName());
        }
        System.out.println("-----------------");

        for (Field f:LinkedHashMap.class.getFields()
                ) {
            System.out.println(f.getAnnotations());
        }
    }
}
