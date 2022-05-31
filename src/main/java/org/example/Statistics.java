package org.example;

import java.util.Iterator;

/**
 * Простой класс поиска максимального значения, создан для изучения JUnit
 */
public class Statistics {
    public static int getMax(Iterable<Integer> list){
        int max = Integer.MIN_VALUE;
        for(Integer i : list){
            max = (i>max)?i:max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Statistics.getMax(IntegerFactory.createIntegerArray(10)));
    }
}
